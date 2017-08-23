JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} org.antlr.v4.Tool
PARSER_FLAGS=-lib org/fujure/fbc/bnfc/antlr/Fujure -package org.fujure.fbc.bnfc.antlr.Fujure
LEXER=${JAVA} ${JAVA_FLAGS} org.antlr.v4.Tool
LEXER_FLAGS=-lib org/fujure/fbc/bnfc/antlr/Fujure -package org.fujure.fbc.bnfc.antlr.Fujure
all: test

test: absyn org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.class org/fujure/fbc/bnfc/antlr/Fujure/PrettyPrinter.class org/fujure/fbc/bnfc/antlr/Fujure/Test.class org/fujure/fbc/bnfc/antlr/Fujure/ComposVisitor.class org/fujure/fbc/bnfc/antlr/Fujure/AbstractVisitor.class org/fujure/fbc/bnfc/antlr/Fujure/FoldVisitor.class org/fujure/fbc/bnfc/antlr/Fujure/AllVisitor.class org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.class org/fujure/fbc/bnfc/antlr/Fujure/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileContents.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileInNamedPackage.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileInDefaultPackage.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListPkgFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/PkgFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/PackageFragment.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListValDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ValDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/UntypedValueDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypedValueDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpec.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecifier.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListTypeSpecFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecFragment.java
	${JAVAC} ${JAVAC_FLAGS} $^

org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.java: org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.g4
	${LEXER} ${LEXER_FLAGS} org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.g4

org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.java: org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.g4
	${PARSER} ${PARSER_FLAGS} org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.g4

org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.class: org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.java org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.java

org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.class: org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.java

org/fujure/fbc/bnfc/antlr/Fujure/PrettyPrinter.class: org/fujure/fbc/bnfc/antlr/Fujure/PrettyPrinter.java

clean:
	rm -f org/fujure/fbc/bnfc/antlr/Fujure/Absyn/*.class org/fujure/fbc/bnfc/antlr/Fujure/*.class

distclean: vclean

vclean:
	 rm -f org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileContents.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileInNamedPackage.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileInDefaultPackage.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListPkgFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/PkgFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/PackageFragment.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListValDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ValDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/UntypedValueDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypedValueDef.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpec.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecifier.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListTypeSpecFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecFragm.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecFragment.java org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileContents.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileInNamedPackage.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/FileInDefaultPackage.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListPkgFragm.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/PkgFragm.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/PackageFragment.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListValDef.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ValDef.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/UntypedValueDef.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypedValueDef.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpec.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecifier.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/ListTypeSpecFragm.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecFragm.class org/fujure/fbc/bnfc/antlr/Fujure/Absyn/TypeSpecFragment.class
	 rm -f org/fujure/fbc/bnfc/antlr/Fujure/Absyn/*.class
	 rmdir org/fujure/fbc/bnfc/antlr/Fujure/Absyn/
	 rm -f org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.g4 org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.g4 org/fujure/fbc/bnfc/antlr/Fujure/FujureLexer.java org/fujure/fbc/bnfc/antlr/Fujure/VisitSkel.java org/fujure/fbc/bnfc/antlr/Fujure/ComposVisitor.java org/fujure/fbc/bnfc/antlr/Fujure/AbstractVisitor.java org/fujure/fbc/bnfc/antlr/Fujure/FoldVisitor.java org/fujure/fbc/bnfc/antlr/Fujure/AllVisitor.java org/fujure/fbc/bnfc/antlr/Fujure/PrettyPrinter.java org/fujure/fbc/bnfc/antlr/Fujure/Skeleton.java org/fujure/fbc/bnfc/antlr/Fujure/Test.java org/fujure/fbc/bnfc/antlr/Fujure/FujureParser.java org/fujure/fbc/bnfc/antlr/Fujure/*.class
	 rm -f Makefile
	 rmdir -p org/fujure/fbc/bnfc/antlr/Fujure/
