package org.fujure.truffle.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import org.fujure.truffle.FujureTruffleContext;
import org.fujure.truffle.FujureTruffleLanguage;

import java.util.Arrays;
import java.util.List;

public final class ModuleNode extends RootNode {
    private final TruffleLanguage.ContextReference<FujureTruffleContext> contextReference;
    private final String packageName;
    private final String moduleName;
    @Children
    private final DefNode[] defs;

    private boolean registered = false;

    public ModuleNode(FujureTruffleLanguage language, String packageName, String moduleName,
            List<DefNode> defs) {
        super(language);
        this.contextReference = language.getContextReference();
        this.packageName = packageName;
        this.moduleName = moduleName;
        this.defs = defs.toArray(new DefNode[0]);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if (!registered) {
            // register values defined in the file as Truffle bindings
            contextReference.get().register(this, frame);
            registered = true;
        }

        return packageName.isEmpty()
                ? 42
                : 129;
    }

    public String fullyQualifiedModuleName() {
        return packageName.isEmpty()
                ? moduleName
                : packageName + "." + moduleName;
    }

    public List<DefNode> definitions() {
        return Arrays.asList(defs);
    }
}
