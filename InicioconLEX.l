%option noyywrap
%{
#include <stdio.h>
%}

%%

[0-9]+"."[0-9]+ { printf("TOKEN_DECIMAL=%s\n", yytext); }
[0-9]+ { printf("TOKEN_NUMERO=%s\n", yytext); }

[A-ZÑ&]{3,4}[0-9]{2}((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01])|(0[469]|11)(0[1-9]|[12][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[A-Z0-9]{3} { printf("TOKEN_RFC=%s\n", yytext); }

[A-Z][AEIOU][A-Z]{2}[0-9]{2}((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01])|(0[469]|11)(0[1-9]|[12][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9][0-9] { printf("TOKEN_CURP=%s\n", yytext); }

[a-z]{2}[0-9]{6}"@uaeh.edu.mx" { printf("TOKEN_EMAIL=%s\n", yytext); }

[a-zA-Z_$][a-zA-Z0-9_$]* { printf("TOKEN_ID=%s\n", yytext); }

[ \t\n] { }

. { printf("TOKEN_DESCONOCIDO=%s\n", yytext); }

%%

int main()
{
    yylex();
    return 0;
}