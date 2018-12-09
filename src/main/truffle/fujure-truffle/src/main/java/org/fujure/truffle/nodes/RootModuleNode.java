package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import org.fujure.fbc.ast.InputFile;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

public final class RootModuleNode extends RootNode {
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;
    private final InputFile inputFile;
    private final String packageName;

    @Children
    private final DefNode[] defs;

    private boolean registered = false;

    public RootModuleNode(FujureTruffleLanguage language,
            InputFile inputFile, ModuleNonRootNode moduleNode) {
        super(language);

        this.contextReference = language.getContextReference();
        this.inputFile = inputFile;
        this.packageName = moduleNode.getPackageName();
        this.defs = moduleNode.getDefs().toArray(new DefNode[0]);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if (!registered) {
            registered = true;
            registerTruffleValues(frame);
        }

        return packageName.isEmpty()
                ? 42
                : 129;
    }

    private void registerTruffleValues(VirtualFrame frame) {
        contextReference.get().enterModuleScope(fullyQualifiedModuleName());
        contextReference.get().resetCurrentModule();
        for (DefNode defNode : defs) {
            if (defNode instanceof SimpleValueDefNode) {
                SimpleValueDefNode simpleValueDefNode = (SimpleValueDefNode) defNode;
                contextReference.get().registerInCurrentModule(simpleValueDefNode.id,
                        simpleValueDefNode.execute(frame));
            }
        }
        contextReference.get().leaveCurrentModule();
    }

    private String fullyQualifiedModuleName() {
        return packageName.isEmpty()
                ? moduleName()
                : packageName + "." + moduleName();
    }

    private String moduleName() {
        return inputFile.getModuleName();
    }
}
