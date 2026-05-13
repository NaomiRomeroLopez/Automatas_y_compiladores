%{
#include <stdio.h>
#include <stdlib.h>

extern int linea;
extern FILE *yyin;
extern FILE *yyout;
extern char *yytext;

int huboErrores = 0;

void yyerror(const char *s);
int yylex();
void yyrestart(FILE *input_file); 
%}

%token SELECT FROM WHERE INSERT INTO VALUES UPDATE SET DELETE
%token ID NUMBER ASTERISK COMMA EQUALS LPAREN RPAREN ERROR
%token SEMICOLON STRING GREATER LESS

%%

programa:
    lista_sentencias
    ;

lista_sentencias:
      sentencia
    | lista_sentencias sentencia
    ;

sentencia:
      instruccion SEMICOLON
      {
          fprintf(yyout,
              "[Línea %d]: Sentencia válida.\n",
              linea);
      }

    | error SEMICOLON
      {
          fprintf(yyout,
              "[Línea %d]: Sentencia inválida.\n",
              linea);

	  huboErrores = 1;
          yyerrok;
      }
;

instruccion:
    select_stmt | insert_stmt | update_stmt | delete_stmt
    ;

operador:
      EQUALS
    | GREATER
    | LESS
;

select_stmt: SELECT columnas FROM ID opt_where ;
columnas: ASTERISK | lista_ids ;
insert_stmt: INSERT INTO ID LPAREN lista_ids RPAREN VALUES LPAREN lista_vals RPAREN ;
update_stmt: UPDATE ID SET asignaciones opt_where ;
delete_stmt: DELETE FROM ID opt_where ;
lista_ids: ID | lista_ids COMMA ID ;
lista_vals: valor | valor COMMA lista_vals ;
valor: ID | NUMBER | STRING ;
opt_where: WHERE ID operador valor | ;
asignaciones: ID EQUALS valor | asignaciones COMMA ID EQUALS valor ;

%%

void yyerror(const char *s) {
    huboErrores = 1;

    fprintf(yyout,
        "[Línea %d] Error sintáctico cerca de '%s': %s\n",
        linea,
        yytext,
        s
    );
}

int main(int argc, char *argv[]) {
    FILE *archivo1, *archivo2;
    linea = 1;

    yyout = fopen("D:\\Flex Windows\\EditPlusPortable\\PracticaFinal\\resultado.txt", "w");
    if (!yyout) {
        perror("Error al crear resultado.txt");
        return 1;
    }

    archivo1 = fopen("D:\\Flex Windows\\EditPlusPortable\\PracticaFinal\\sqlcorrecto.txt", "r");

	if (!archivo1) {
	    fprintf(yyout,
		"No se encontró sqlcorrecto.txt\n");
	} else {
	    yyin = archivo1;
	    linea = 1;
	    huboErrores = 0;
	    fprintf(yyout,
		"--- ANALIZANDO ARCHIVO CORRECTO ---\n");
	    yyparse();
	    if (!huboErrores) {
		printf("Archivo SQL correcto: OK\n");
		fprintf(yyout,
		    "\n>>> RESULTADO FINAL: Análisis Exitoso.\n\n");
	    } else {
		printf("Archivo SQL correcto: ERROR\n");
		fprintf(yyout,
		    "\n>>> RESULTADO FINAL: Se encontraron errores.\n\n");
	    }
	    fclose(archivo1);
	}

	linea = 1;

	archivo2 = fopen("D:\\Flex Windows\\EditPlusPortable\\PracticaFinal\\sqlincorrecto.txt", "r");

	if (!archivo2) {
	    fprintf(yyout,
		"No se encontró sqlincorrecto.txt\n");
	} else {
	    yyin = archivo2;
	    linea = 1;
	    huboErrores = 0;
	    fprintf(yyout,
		"--- ANALIZANDO ARCHIVO INCORRECTO ---\n");
	    yyparse();
	    if (!huboErrores) {
		printf("Archivo SQL incorrecto: OK (Inesperado)\n");
		fprintf(yyout,
		    "\n>>> RESULTADO FINAL: Análisis Exitoso.\n");
	    } else {
		printf("Archivo SQL incorrecto: ERROR (Esperado)\n");
		fprintf(yyout,
		    "\n>>> RESULTADO FINAL: Se encontraron errores.\n");
	    }
	    fclose(archivo2);
	}

    fclose(yyout);
    printf("Proceso terminado. Revisa 'resultado.txt'\n");
    return 0;
}