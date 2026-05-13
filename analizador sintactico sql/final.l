%{
#include "y.tab.h"
#include <stdio.h>
int linea = 1;
%}

%option noyywrap

%%
"SELECT"    { return SELECT; }
"FROM"      { return FROM; }
"WHERE"     { return WHERE; }
"INSERT"    { return INSERT; }
"INTO"      { return INTO; }
"VALUES"    { return VALUES; }
"UPDATE"    { return UPDATE; }
"SET"       { return SET; }
"DELETE"    { return DELETE; }
"*"         { return ASTERISK; }
","         { return COMMA; }
"="         { return EQUALS; }
"("         { return LPAREN; }
")"         { return RPAREN; }
[0-9]+      { return NUMBER; }
[a-zA-Z][a-zA-Z0-9_]* { return ID; }
";"         { return SEMICOLON; }
\'[^\']*\'  { return STRING; }
">"         { return GREATER; }
"<"         { return LESS; }
"\n"        { linea++; }
[ \t\r]+    ; /* Ignorar espacios */
.           { return ERROR; }
%%