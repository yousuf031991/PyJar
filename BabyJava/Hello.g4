
/*
Developed with a ton of help from The Definitive ANTLR 4 Reference.
*/

grammar Hello;

//start rule
start : context ;

context: (assignment | whileLoop | ifelse | voidcall | functionDeclaration | functionCall | stackDeclaration | stackOps | functionReturn)* ;


/**Calls*/

voidcall : 'print' dataType;

readCall : 'read'; 

// function specs

functionDeclaration :'func' IDENT '(' argumentsDefinition ')' '{' functionBody '}';
    
argumentsDefinition : (() |(IDENT) (',' IDENT)*);

functionBody : context;

functionCall : IDENT '(' parametersDefinition ')';

parametersDefinition : (() | dataType (',' dataType)*);

dataType : (INT | BOOL | IDENT);

functionReturn : 'return' (IDENT | INT | BOOL | functionCall);

// stack specs

stackDeclaration : 'stack' IDENT;

stackOps : IDENT stackFuncs ;

stackFuncs : (stackPush | stackPop | stackIsEmpty);

stackPush : '.push' '(' dataType ')';

stackPop : '.pop' '(' ')';

stackIsEmpty : '.isEmpty' '(' ')';

/**if else statement*/
ifelse : (ifStatement)(elseIfStatement)* (elseStatement)?;

ifStatement : prefixIf prefixContext;

prefixIf : 'if' '(' (boolCompare | integerCompare) ')'  ;

elseIfStatement : prefixElseIf prefixContext;

prefixElseIf : 'else if' '(' (boolCompare | integerCompare) ')' ;

elseStatement : prefixElse prefixContext;

prefixElse : 'else' ;

prefixContext : '{' context '}';

/**Loop*/
whileLoop : whilePrefix '{' context '}' ;

whilePrefix : 'while' '(' (boolCompare | integerCompare) ')';


/**Assignment*/
assignment : IDENT '=' (readCall | expression | boolExpression | functionCall | stackOps) ;

/** Integer expression */

expression : (term)(subExpression)* ;

subExpression : ADDOP term ;

term : (factor) (subTerm)*;

subTerm : MULOP factor;

factor : (IDENT | INT | '(' expression ')');


/** Boolean expression */

boolExpression : (boolTerm) (boolSubExpression)*;

boolSubExpression : BOOLOR boolTerm ;

boolTerm : (boolFactor) (subBoolTerm)*;

subBoolTerm : BOOLAND boolFactor;

boolFactor : (IDENT | BOOL | '(' boolExpression ')');


/**Comparison functions*/

integerCompare : expression INTCOMP expression ;

boolCompare : boolExpression BOOLCOMP boolExpression;

/**Operators*/

//integer operators
MULOP : ('*' | '/' | '%');

ADDOP : ('+' | '-') ; 

INTCOMP : ('>' | '<' | '==' | '<=' | '>=');

BOOLAND : 'and' ;

BOOLOR : 'or' ;

BOOLCOMP : 'is' ;

/**Types*/

//boolean
BOOL : ('True' | 'False') ;

//integer
INT : [0-9]+ ;
	
//valid identifiers (letters of either case and numbers)
IDENT: ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;

/**Whitespace and comments - These are from chapter 5 of The Definitive ANTLR 4 Reference*/

//whitespace
WS: [ \t\r\n]+ -> skip;

//comments

COMMENT : '//' ~( '\r' | '\n' )* -> skip 
;