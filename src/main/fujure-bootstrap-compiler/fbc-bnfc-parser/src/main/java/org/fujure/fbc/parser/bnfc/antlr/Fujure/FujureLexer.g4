// This Antlr4 file was machine-generated by the BNF converter
lexer grammar FujureLexer;
// Predefined regular expressions in BNFC
fragment LETTER  : CAPITAL | SMALL ;
fragment CAPITAL : [A-Z\u00C0-\u00D6\u00D8-\u00DE] ;
fragment SMALL   : [a-z\u00DF-\u00F6\u00F8-\u00FF] ;
fragment DIGIT   : [0-9] ;
Surrogate_id_SYMB_0 : '.' ;
Surrogate_id_SYMB_1 : '=' ;
Surrogate_id_SYMB_2 : ':' ;
Surrogate_id_SYMB_3 : 'def' ;
Surrogate_id_SYMB_4 : 'false' ;
Surrogate_id_SYMB_5 : 'import' ;
Surrogate_id_SYMB_6 : 'package' ;
Surrogate_id_SYMB_7 : 'true' ;
Surrogate_id_SYMB_8 : 'unit' ;


JID : ('_'|'$'|LETTER)('_'|'$'|LETTER|DIGIT)*;
JCHAR : '\''(~[\'\\]|'\\'[\'\\nt])'\'';
// String token type
STRING : '"' -> more, mode(STRINGMODE);


//Integer predefined token type
INTEGER : DIGIT+;

// Whitespace
WS : (' ' | '\r' | '\t' | '\n')+ ->  skip;
// Escapable sequences
fragment
Escapable : ('"' | '\\' | 'n' | 't' | 'r');
ErrorToken : . ;
mode STRESCAPE;
STRESCAPED : Escapable  -> more, popMode ;
mode STRINGMODE;
STRINGESC : '\\' -> more , pushMode(STRESCAPE);
STRINGEND : '"' ->  type(STRING), mode(DEFAULT_MODE);
STRINGTEXT : ~[\"\\] -> more;
