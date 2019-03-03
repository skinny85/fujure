// This Antlr4 file was machine-generated by the BNF converter
lexer grammar FujureLexer;
// Predefined regular expressions in BNFC
fragment LETTER  : CAPITAL | SMALL ;
fragment CAPITAL : [A-Z\u00C0-\u00D6\u00D8-\u00DE] ;
fragment SMALL   : [a-z\u00DF-\u00F6\u00F8-\u00FF] ;
fragment DIGIT   : [0-9] ;
Surrogate_id_SYMB_0 : '.' ;
Surrogate_id_SYMB_1 : ':' ;
Surrogate_id_SYMB_2 : '=' ;
Surrogate_id_SYMB_3 : '||' ;
Surrogate_id_SYMB_4 : '&&' ;
Surrogate_id_SYMB_5 : '==' ;
Surrogate_id_SYMB_6 : '!=' ;
Surrogate_id_SYMB_7 : '<' ;
Surrogate_id_SYMB_8 : '<=' ;
Surrogate_id_SYMB_9 : '>' ;
Surrogate_id_SYMB_10 : '>=' ;
Surrogate_id_SYMB_11 : '+' ;
Surrogate_id_SYMB_12 : '-' ;
Surrogate_id_SYMB_13 : '*' ;
Surrogate_id_SYMB_14 : '/' ;
Surrogate_id_SYMB_15 : '%' ;
Surrogate_id_SYMB_16 : '!' ;
Surrogate_id_SYMB_17 : '(' ;
Surrogate_id_SYMB_18 : ')' ;
Surrogate_id_SYMB_19 : 'def' ;
Surrogate_id_SYMB_20 : 'false' ;
Surrogate_id_SYMB_21 : 'import' ;
Surrogate_id_SYMB_22 : 'package' ;
Surrogate_id_SYMB_23 : 'true' ;
Surrogate_id_SYMB_24 : 'unit' ;


JID : ('_'|'$'|LETTER)('_'|'$'|LETTER|DIGIT)*;
JCHAR : '\''(~[\'\\]|'\\'[\'\\nt])'\'';
JSTRING : '"'(~["\\]|'\\'["\\nt])*'"';



//Integer predefined token type
INTEGER : DIGIT+;

// Whitespace
WS : (' ' | '\r' | '\t' | '\n')+ ->  skip;
// Escapable sequences
fragment
Escapable : ('"' | '\\' | 'n' | 't' | 'r');
ErrorToken : . ;

