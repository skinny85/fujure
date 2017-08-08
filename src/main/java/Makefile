JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
PARSER=${JAVA} ${JAVA_FLAGS} org.antlr.v4.Tool
PARSER_FLAGS=-lib Fujure -package Fujure
LEXER=${JAVA} ${JAVA_FLAGS} org.antlr.v4.Tool
LEXER_FLAGS=-lib Fujure -package Fujure
all: test

test: absyn Fujure/FujureLexer.class Fujure/PrettyPrinter.class Fujure/Test.class Fujure/ComposVisitor.class Fujure/AbstractVisitor.class Fujure/FoldVisitor.class Fujure/AllVisitor.class Fujure/FujureParser.class Fujure/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: Fujure/Absyn/ValueDef.java Fujure/Absyn/VDef.java
	${JAVAC} ${JAVAC_FLAGS} $^

Fujure/FujureLexer.java: Fujure/FujureLexer.g4
	${LEXER} ${LEXER_FLAGS} Fujure/FujureLexer.g4

Fujure/FujureParser.java: Fujure/FujureParser.g4
	${PARSER} ${PARSER_FLAGS} Fujure/FujureParser.g4

Fujure/FujureLexer.class: Fujure/FujureLexer.java Fujure/FujureParser.java

Fujure/FujureParser.class: Fujure/FujureParser.java

Fujure/PrettyPrinter.class: Fujure/PrettyPrinter.java

clean:
	rm -f Fujure/Absyn/*.class Fujure/*.class

distclean: vclean

vclean:
	 rm -f Fujure/Absyn/ValueDef.java Fujure/Absyn/VDef.java Fujure/Absyn/ValueDef.class Fujure/Absyn/VDef.class
	 rm -f Fujure/Absyn/*.class
	 rmdir Fujure/Absyn/
	 rm -f Fujure/FujureLexer.g4 Fujure/FujureParser.g4 Fujure/FujureLexer.java Fujure/VisitSkel.java Fujure/ComposVisitor.java Fujure/AbstractVisitor.java Fujure/FoldVisitor.java Fujure/AllVisitor.java Fujure/PrettyPrinter.java Fujure/Skeleton.java Fujure/Test.java Fujure/FujureParser.java Fujure/*.class
	 rm -f Makefile
	 rmdir -p Fujure/
