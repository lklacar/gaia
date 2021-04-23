grammar Gaia;

program: functionDefinition*;

statement
    : variableDefinitionStatement
    | ifStatement
    | printStatement
    | whileStatement
    | assignmentStatement
    ;

functionDefinition: 'func' ID LPAREN (functionParameters)* (COMMA functionParameters)*  RPAREN LBRACE body returnStatement? RBRACE;

functionParameters : ID COLON type;

variableDefinitionStatement: 'let' ID COLON type EQ expression;

assignmentStatement: ID EQ expression;

ifStatement:
    'if' LPAREN expression RPAREN LBRACE ifBody RBRACE
    ;

returnStatement: 'return' atom;

whileStatement :
    'while' LPAREN expression RPAREN LBRACE whileBody RBRACE
    ;

ifBody : body;
whileBody: body;

body: (statement | expression)*;

printStatement: 'print' expression;

expression
   : functionCallExpression                   #expressionFunctionCall
   |  expression op=TIMES  expression         #expressionMul
   |  expression op=DIV  expression           #expressionDiv
   |  expression op=PLUS expression           #expressionAdd
   |  expression op=MINUS expression          #expressionSub
   |  LPAREN expression RPAREN                #expressionNested
   |  MINUS expression                        #expressionNegate
   |  expression op=MOD expression            #expressionMod
   |  expression op=GT expression             #expressionGreaterThan
   |  expression op=LT expression             #expressionLessThan
   |  expression op=EQ_EQ expression          #expressionEquals
   |  atom                                    #expressionNumber
   ;

functionCallExpression: ID LPAREN (functionArguments)* (COMMA functionArguments)* RPAREN;

functionArguments: expression;

atom
    : op=INT                                #atomInt
    | op=ID                                 #atomId
    ;

type
    : 'i64'
    ;

ID: [a-zA-Z]+ DIGIT*;
TIMES: '*';
DIV: '/';
PLUS: '+';
MINUS: '-';
LPAREN: '(';
RPAREN: ')';
POW: '^';
EQ: '=';
EQ_EQ: '==';
LBRACE: '{';
RBRACE: '}';
COLON: ':';
GT: '>';
LT: '<';
MOD: '%';
COMMA: ',';

INT: DIGIT+;
DECIMAL: INT '.' INT;

fragment DIGIT: [0-9];
fragment SIGN: (MINUS)?;


WS
   : [ \r\n\t] + -> skip
   ;


COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
