/**
John wrote this. Except where noted.
Developed with a ton of help from The Definitive ANTLR 4 Reference.
*/

grammar BabyJavaV1;
	
//start rule
start : context ;

context: (assignment | whileLoop | jump | call)+ ;


/**Calls*/
call : intCall | strCall | boolCall ;

intCall : 'getInt()' ;

strCall : 'getStr()' ;

boolCall : 'getBool()' ;


/**Jump*/
jump : 'if' '(' (boolOp | compare) ')' '{' context '}' 'else' '{' context '}'


/**Loop*/
whileLoop : 'while' (IDENT | boolOp | intComp | strComp) '{' context '}' ;


/**Assignment*/
assignment : intAssignment | strAssignment | boolAssignment ;

intAssignment : IDENT '=' (INT | intOp | intCall) ;

strAssignment : IDENT '=' (STR | strOp | strCall) ;

boolAssignment : IDENT '=' (BOOL | boolOp | boolCall) ;


/**Operations*/
operation : intOperation | stringOperation | booleanOperation ;

intOperation : IDENT intOp IDENT ;

stringOperation : IDENT strOp IDENT ;

booleanOperation : IDENT boolOp IDENT ;


/**Comparison functions*/
compare : integerCompare | stringCompare ;

integerCompare : IDENT intComp IDENT ;

stringCompare : IDENT strComp IDENT ;


/**Operators*/

//integer operators
intOp : '+' | '-' | '*' | '/' | '%' ; 

//string operators
strOp : **What do we need here?*

//boolean operators
boolOp : 'and' | 'or' | 'xor' ;

/**Comparators*/

//integer comparators
intComp : '>' | '<' | '==' ;

//string comparators
strComp : '==' ;

/**Types*/
	
//valid identifiers (letters of either case and numbers)
IDENT : [ a-zA-Z0-9]+ ;

//integer
INT : [0-9]+ ;

//string
STR : '"' [ a-zA-Z0-9]+ '"' ;

//boolean
BOOL : 'true' | 'false' ;

/**Whitespace and comments - These are from chapter 5 of The Definitive ANTLR 4 Reference*/

//whitespace
WS : [ \t\r\n]+ -> skip ;

//comments
COMMENT : '//' ~( '\r' | '\n' )* -> skip ;

/**Ignore this for now
//statement sequence
statements : (statement ';')* ; //just as in Java, a statement is terminated by a semicolon

//expression list
expressionList : expression (',' expression)* ; //an expression followed by zero or more expressions (like inside a for loop)
*/