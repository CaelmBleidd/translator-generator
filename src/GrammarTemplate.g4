grammar GrammarTemplate;

file : (attributes) ? (nodeValues)? myRules myTokens EOF;

attributes : ATTR ATTRIBUTE_VALUE;

nodeValues : NODE NODE_VALUE;

myRules : (myRule)+;
myRule : RULE_NAME ARROW (RULE_NAME | TOKEN_NAME | SEMANTIC_RULE)+ SEMICOLON;

myTokens : (myToken)+;
myToken : TOKEN_NAME ARROW LITERAL SEMICOLON;

ARROW: '->';
SEMICOLON : ';';

ATTR : 'Attr';
NODE: 'Node';
ATTRIBUTE_VALUE : '%' ('%%' | ~ ('%'))* '%';
NODE_VALUE : '@' ('@@' | ~ ('@'))* '@';
SEMANTIC_RULE : '$' ('$$' | ~ ('$'))* '$';

TOKEN_NAME : ('A'..'Z')('A'..'Z' | '_' | '0' .. '9')+;
RULE_NAME : ('a' .. 'z')('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '`')*;

LITERAL : '\'' ('\'\'' | ~ ('\''))* '\'';

WS : [ \n\t\r] -> skip;