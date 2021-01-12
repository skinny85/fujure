package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;
import org.fujure.fbc.analyze.PartialType;
import org.fujure.fbc.ast.Module;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;
import org.fujure.truffle.runtime.FujureFunctionObject;
import org.fujure.truffle.runtime.Unit;

public final class RootModuleNode extends RootNode {
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;
    private final Module module;

    @Children
    private final DefNode[] defs;

    private boolean registered = false;
    @Child
    private DirectCallNode mainFunctionCallNode;

    public RootModuleNode(FujureTruffleLanguage language,
            FrameDescriptor frameDescriptor, ModuleNonRootNode moduleNode) {
        super(language, frameDescriptor);

        this.contextReference = language.getContextReference();
        this.module = moduleNode.getModule();
        this.defs = moduleNode.getDefs().toArray(new DefNode[0]);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if (!registered) {
            registered = true;
            registerTruffleValues(frame);
        }

        return mainFunctionCallNode == null
                ? Unit.INSTANCE // you can't return null from RootNode.execute()
                : mainFunctionCallNode.call(frame.getArguments());
    }

    private void registerTruffleValues(VirtualFrame frame) {
        contextReference.get().resetModule(module);

        // First, initialize the simple values with their defaults.
        // We have to do this, as the functions can use them in their bodies,
        // and then their initializers can call those functions,
        // thereby observing an uninitialized value for things that are otherwise constants
        for (DefNode defNode : defs) {
            if (defNode instanceof SimpleValueDefNode) {
                SimpleValueDefNode simpleValueDefNode = (SimpleValueDefNode) defNode;
                contextReference.get().registerValue(module, simpleValueDefNode.id,
                        this.defaultValueFor(simpleValueDefNode.type.getPartialType()));
            }
        }

        // start with functions, as simple values are eagerly executed,
        // and may use functions in their definitions
        for (DefNode defNode : defs) {
            if (defNode instanceof FunctionValueDefNode) {
                FunctionValueDefNode functionValueDefNode = (FunctionValueDefNode) defNode;
                FujureFunctionObject functionDefFujureFunction = functionValueDefNode.execute(frame);
                contextReference.get().registerValue(module, functionValueDefNode.id,
                        functionDefFujureFunction);
                if ("main".equals(functionValueDefNode.id)) {
                    // the main function is special - it will be invoked when the module is evaluated
                    mainFunctionCallNode = DirectCallNode.create(functionDefFujureFunction.callTarget);
                }
            }
        }

        // and now, simple values
        for (DefNode defNode : defs) {
            if (defNode instanceof SimpleValueDefNode) {
                SimpleValueDefNode simpleValueDefNode = (SimpleValueDefNode) defNode;
                contextReference.get().registerValue(module, simpleValueDefNode.id,
                        simpleValueDefNode.execute(frame));
            }
        }
    }

    private Object defaultValueFor(PartialType type) {
        if (type instanceof PartialType.NonFunc.KnownType) {
            PartialType.NonFunc.KnownType knownType = (PartialType.NonFunc.KnownType) type;
            if ("fujure".equals(knownType.getPackageName())) {
                switch (knownType.getTypeName()) {
                    case "Int": return 0;
                    case "Char": return 0;
                    case "Bool": return false;
                    case "Unit": return Unit.INSTANCE;
                }
            }
        }
        return null;
    }
}
