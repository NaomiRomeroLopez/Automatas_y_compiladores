# Práctica: Analizador Léxico con Flex

## Objetivo
Desarrollar un analizador léxico utilizando Flex capaz de reconocer los diferentes componentes léxicos del lenguaje C++, tales como palabras reservadas, identificadores, literales, operadores, separadores y comentarios.

## Introducción
Un analizador léxico es la primera fase de un compilador. Su función es leer un archivo de entrada y dividirlo en unidades significativas llamadas *tokens*.

En esta práctica se utilizó Flex, una herramienta que permite generar analizadores léxicos a partir de expresiones regulares.

Flex funciona mediante:
- Definición de patrones (expresiones regulares)
- Asociación de acciones a dichos patrones
- Generación automática de un escáner eficiente

## Desarrollo
El programa se estructuró en tres secciones principales:

### 1. Definiciones
Se declararon expresiones regulares para distintos tipos de tokens:

- Dígitos y letras  
- Identificadores  
- Literales numéricos  
- Literales de cadena y carácter  
- Operadores y separadores  
- Comentarios  

Ejemplo:

    ID [a-zA-Z_][a-zA-Z0-9_]*
    INTEGERLIT  0|[1-9][0-9_]*([lL])?
    FLOATLIT    [0-9][0-9_]*\.[0-9][0-9_]*([eE][+-]?[0-9]+)?([fFdD])?

### 2. Reglas

Se definieron reglas para reconocer diferentes tipos de tokens:

#### Palabras reservadas

Se declararon explícitamente como cadenas:

    "int" { fprintf(yyout, "KEYWORD: int\n"); }

Estas se colocaron antes del identificador para evitar errores


####  Identificadores

    {ID} { fprintf(yyout, "IDENTIFIER: %s\n", yytext); }


#### Literales

Se reconocen distintos tipos de números:
- Enteros  
- Flotantes  
- Hexadecimales  
- Binarios  
- Octales  

#### Operadores

Se manejaron operadores simples y compuestos:

    "<<="|">>="|"=="|"!="|"<="|">="|"&&"|"||"|"<<"|">>"|"++"|"--"|"+="|"-="|"*="|"/="|"%="|"&="|"|="|"^=" {
        fprintf(yyout, "OPERATOR: %s\n", yytext);
    }

Además:

    {SIMPLEOP} { fprintf(yyout, "OPERATOR: %s\n", yytext); }

Se dio prioridad a los operadores más largos para evitar conflictos.

#### Separadores

    {SEPARATOR} { fprintf(yyout, "SEPARATOR: %s\n", yytext); }


#### Comentarios
    {LINECOMMENT} { }
    {BLOCKCOMMENT} { }

Los comentarios son ignorados.


#### Espacios en blanco
    [ \t\n] { }

#### Manejo de errores
    . { fprintf(yyout, "ERROR: %s\n", yytext); }

### 3. Código principal en C
Se utilizó la función `main()` para abrir los archivos y ejecutar el analizador:

    int main() {

        yyin = fopen("archivoentrada.cpp", "r");
        yyout = fopen("MyScanner.txt", "w");

        yylex();

        fclose(yyin);
        fclose(yyout);
        return 0;
    }


## Problemas encontrados
Durante el desarrollo se presentaron varios errores:

###  Error: "unrecognized rule"
**Causas:**
- Uso incorrecto del operador `|`
- División incorrecta de reglas en varias líneas
- Conflictos entre operadores como `<<` y `<<=`

**Soluciones:**
- Escribir reglas completas en una sola línea
- Ordenar operadores del más largo al más corto
- Evitar ambigüedades en los patrones

## Resultados
El analizador fue capaz de:

- Identificar palabras reservadas  
- Reconocer identificadores  
- Detectar distintos tipos de literales  
- Procesar operadores  
- Ignorar comentarios  
- Reportar errores léxicos  

##  Conclusiones
- Flex permite construir analizadores léxicos de manera formal y eficiente  
- El orden de las reglas es fundamental  
- Las palabras reservadas son patrones definidos antes que los identificadores  
- Es una herramienta más estricta pero más robusta que hacerlo manualmente  

## Aprendizajes
- Uso de expresiones regulares  
- Importancia del "longest match"  
- Manejo de conflictos léxicos  
- Diferencias entre implementación manual y automática  

## Archivos generados
- archivoentrada.cpp → Archivo de entrada  
- MyScanner.txt → Salida del analizador  
- scanner.l → Código fuente en Flex  
