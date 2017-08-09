JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} org.antlr.v4.Tool
PARSER_FLAGS=-lib org/fujure/fjc/bnfc/antlr/Fujure -package org.fujure.fjc.bnfc.antlr.Fujure
LEXER=${JAVA} ${JAVA_FLAGS} org.antlr.v4.Tool
LEXER_FLAGS=-lib org/fujure/fjc/bnfc/antlr/Fujure -package org.fujure.fjc.bnfc.antlr.Fujure
all: test

test: absyn org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.class org/fujure/fjc/bnfc/antlr/Fujure/PrettyPrinter.class org/fujure/fjc/bnfc/antlr/Fujure/Test.class org/fujure/fjc/bnfc/antlr/Fujure/ComposVisitor.class org/fujure/fjc/bnfc/antlr/Fujure/AbstractVisitor.class org/fujure/fjc/bnfc/antlr/Fujure/FoldVisitor.class org/fujure/fjc/bnfc/antlr/Fujure/AllVisitor.class org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.class org/fujure/fjc/bnfc/antlr/Fujure/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: org/fujure/fjc/bnfc/antlr/Fujure/Absyn/ValueDef.java org/fujure/fjc/bnfc/antlr/Fujure/Absyn/VDef.java
	${JAVAC} ${JAVAC_FLAGS} $^

org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.java: org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.g4
	${LEXER} ${LEXER_FLAGS} org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.g4

org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.java: org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.g4
	${PARSER} ${PARSER_FLAGS} org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.g4

org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.class: org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.java org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.java

org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.class: org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.java

org/fujure/fjc/bnfc/antlr/Fujure/PrettyPrinter.class: org/fujure/fjc/bnfc/antlr/Fujure/PrettyPrinter.java

clean:
	rm -f org/fujure/fjc/bnfc/antlr/Fujure/Absyn/*.class org/fujure/fjc/bnfc/antlr/Fujure/*.class

distclean: vclean

vclean:
	 rm -f org/fujure/fjc/bnfc/antlr/Fujure/Absyn/ValueDef.java org/fujure/fjc/bnfc/antlr/Fujure/Absyn/VDef.java org/fujure/fjc/bnfc/antlr/Fujure/Absyn/ValueDef.class org/fujure/fjc/bnfc/antlr/Fujure/Absyn/VDef.class
	 rm -f org/fujure/fjc/bnfc/antlr/Fujure/Absyn/*.class
	 rmdir org/fujure/fjc/bnfc/antlr/Fujure/Absyn/
	 rm -f org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.g4 org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.g4 org/fujure/fjc/bnfc/antlr/Fujure/FujureLexer.java org/fujure/fjc/bnfc/antlr/Fujure/VisitSkel.java org/fujure/fjc/bnfc/antlr/Fujure/ComposVisitor.java org/fujure/fjc/bnfc/antlr/Fujure/AbstractVisitor.java org/fujure/fjc/bnfc/antlr/Fujure/FoldVisitor.java org/fujure/fjc/bnfc/antlr/Fujure/AllVisitor.java org/fujure/fjc/bnfc/antlr/Fujure/PrettyPrinter.java org/fujure/fjc/bnfc/antlr/Fujure/Skeleton.java org/fujure/fjc/bnfc/antlr/Fujure/Test.java org/fujure/fjc/bnfc/antlr/Fujure/FujureParser.java org/fujure/fjc/bnfc/antlr/Fujure/*.class
	 rm -f Makefile
	 rmdir -p org/fujure/fjc/bnfc/antlr/Fujure/
