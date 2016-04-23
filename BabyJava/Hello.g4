/*
Developed with a ton of help from The Definitive ANTLR 4 Reference.
*/

grammar Hello;
	
//start rule
start : context ;

context: (assignment | whileLoop | jump | call)+ ;


/**Calls*/
call : voidcall | intCall | strCall | boolCall ;

voidcall : 'print(' IDENT ')' ;

intCall : 'getInt()' ;

strCall : 'getStr()' ;

boolCall : 'getBool()' ;


/**Jump*/
jump : 'if' '(' (booleanOperation | compare) ')' '{' context '}' 'else' '{' context '}';


/**Loop*/
whileLoop : 'WHILE' (IDENT | booleanOperation | compare) '{' context '}' ;


/**Assignment*/
assignment : intAssignment | strAssignment | boolAssignment ;

intAssignment : IDENT '=' (INT | intOperation | intCall)+ ;

strAssignment : IDENT '=' (STR | stringOperation)+ ;

boolAssignment : IDENT '=' (BOOL | booleanOperation | boolCall)+ ;


/**Operations*/
operation : intOperation | stringOperation | booleanOperation ;

intOperation : IDENT INTOP IDENT ;

stringOperation : IDENT STROP IDENT ;

booleanOperation : IDENT BOOLOP IDENT ;


/**Comparison functions*/
compare : integerCompare | stringCompare ;

integerCompare : IDENT INTCOMP IDENT ;

stringCompare : IDENT STRCOMP IDENT ;


/**Operators*/

//integer operators
INTOP : '+' | '-' | '*' | '/' | '%' ; 

//string operators
STROP : 'concat' ;//**What do we need here?*

//boolean operators
BOOLOP : 'and' | 'or' | 'xOr' ;

/**Comparators*/

//integer comparators
INTCOMP : '>' | '<' | '==' ;

//string comparators
STRCOMP : 'isequal' ;

/**Types*/
	
//valid identifiers (letters of either case and numbers)
IDENT : [ a-z]+ ;

//integer
INT : [ 0-9]+ ;

//string
STR : '"' [ a-zA-Z0-9]+ '"' ;

//boolean
BOOL : ['true' | 'false']* ;

/**Whitespace and comments - These are from chapter 5 of The Definitive ANTLR 4 Reference*/

//whitespace
WS : [ \t\r\n]+ -> skip ;

//comments
/**Ignore this for now
//statement sequence
statements : (statement ';')* ; //just as in Java, a statement is terminated by a semicolon
//expression list
expressionList : expression (',' expression)* ; //an expression followed by zero or more expressions (like inside a for loop)
*/

COMMENT : '//' ~( '\r' | '\n' )* -> skip 
;





