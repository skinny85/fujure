package org.fujure.truffle;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileContents;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInDefaultPackage;
import org.fujure.fbc.parser.bnfc.antlr.Fujure.Absyn.FileInNamedPackage;

public class FujureRootNode extends RootNode {
    private final FileContents fileContents;

    public FujureRootNode(FujureTruffleLanguage language, FileContents fileContents) {
        super(language);
        this.fileContents = fileContents;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return fileContents.accept(new FileContents.Visitor<Integer, Void>() {
            @Override
            public Integer visit(FileInDefaultPackage p, Void arg) {
                return 42;
            }

            @Override
            public Integer visit(FileInNamedPackage p, Void arg) {
                return 129;
            }
        }, null);
    }
}
