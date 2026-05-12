# Analizador Semántico en Compiladores

## Introducción

Un compilador es un programa encargado de traducir código fuente escrito en un lenguaje de programación hacia un lenguaje entendible por la computadora, generalmente código máquina o código intermedio. Para lograr esta tarea, el compilador divide el proceso en varias fases, entre las que destacan el análisis léxico, análisis sintáctico, análisis semántico, optimización y generación de código.

El análisis semántico es una de las etapas más importantes porque se encarga de verificar que las instrucciones del programa tengan significado lógico y cumplan correctamente las reglas del lenguaje de programación. Esta fase se ejecuta después del análisis sintáctico y utiliza la información generada previamente para validar operaciones, tipos de datos, funciones y variables.

Un programa puede estar perfectamente escrito desde el punto de vista sintáctico y aun así contener errores semánticos que impedirían su correcta ejecución. Por ejemplo:

```c
int edad;
edad = "veinte";
```

La sintaxis es correcta porque la estructura de la instrucción es válida, pero semánticamente existe un error porque una variable entera no puede almacenar una cadena de texto.

El análisis semántico es fundamental porque evita errores lógicos antes de la ejecución del programa y permite que el compilador produzca código más seguro y eficiente.

---

# 1. Teoría del Analizador Semántico

## Definición del análisis semántico

El análisis semántico es la fase del compilador encargada de comprobar que el programa tenga coherencia lógica de acuerdo con las reglas del lenguaje de programación.

Durante esta etapa el compilador analiza aspectos como:

- Compatibilidad de tipos de datos.
- Uso correcto de variables.
- Declaración previa de identificadores.
- Alcance de variables y funciones.
- Llamadas correctas a funciones.
- Uso válido de operadores.
- Conversión de tipos.
- Validación de expresiones.

El objetivo principal es detectar errores que no pueden identificarse únicamente mediante la gramática del lenguaje.

---

## Diferencia entre análisis sintáctico y semántico

Muchas veces se confunden ambas fases porque trabajan de manera muy cercana, pero tienen funciones diferentes.

| Análisis Sintáctico | Análisis Semántico |
|---|---|
| Verifica estructura gramatical | Verifica significado lógico |
| Usa reglas de gramática | Usa reglas semánticas |
| Detecta errores de sintaxis | Detecta errores de lógica |
| Genera el árbol sintáctico | Valida el contenido del árbol |

Por ejemplo:

```c
int x;
x = 5 + ;
```

El error es sintáctico porque la expresión está incompleta.

En cambio:

```c
int x;
x = "hola";
```

El error es semántico porque la estructura es válida pero el significado es incorrecto.

---

## Objetivos del análisis semántico

El análisis semántico tiene varios objetivos importantes:

### Verificación de tipos

Comprueba que las operaciones realizadas sean compatibles entre sí.

Ejemplo:

```c
int a = 5;
float b = 2.5;
float c = a + b;
```

En este caso la operación es válida porque el compilador puede convertir automáticamente el entero en flotante.

---

### Validación de identificadores

Comprueba que las variables y funciones hayan sido declaradas antes de utilizarse.

Ejemplo:

```c
resultado = 10;
```

Aquí existe un error porque la variable no fue declarada.

---

### Verificación de funciones

El compilador revisa:

- Número de parámetros.
- Tipo de parámetros.
- Tipo de retorno.

Ejemplo:

```c
int suma(int a, int b);

suma(5);
```

La función requiere dos parámetros y solo se envió uno.

---

### Control de alcance

El análisis semántico verifica desde qué partes del programa puede accederse a una variable.

Ejemplo:

```c
{
    int x = 5;
}

x = 10;
```

La variable `x` ya no existe fuera del bloque.

---

# 2. Herramientas y Técnicas

## Tabla de símbolos

La tabla de símbolos es una estructura de datos utilizada para almacenar información relacionada con los identificadores del programa.

Es una de las herramientas más importantes del análisis semántico.

---

## Información almacenada

La tabla de símbolos puede contener:

- Nombre del identificador.
- Tipo de dato.
- Alcance.
- Dirección de memoria.
- Número de parámetros.
- Tipo de retorno.
- Valor actual.

Ejemplo:

| Identificador | Tipo | Alcance |
|---|---|---|
| edad | int | global |
| promedio | float | local |
| suma | función | global |

---

## Funcionamiento de la tabla de símbolos

Cuando el compilador encuentra una declaración:

```c
int numero;
```

Registra el identificador en la tabla.

Cuando posteriormente aparece:

```c
numero = 10;
```

El compilador consulta la tabla para comprobar:

- Que la variable exista.
- Que el tipo sea compatible.
- Que esté dentro del alcance permitido.

---

## Árbol de Sintaxis Abstracta (AST)

El Árbol de Sintaxis Abstracta representa la estructura lógica del programa de forma jerárquica.

Ejemplo:

```c
a + b * c
```

Representación simplificada:

```text
      +
     / \
    a   *
       / \
      b   c
```

El árbol facilita la evaluación semántica porque el compilador puede recorrer cada nodo verificando operaciones y tipos.

---

## Recorridos del AST

El compilador puede recorrer el árbol de varias maneras:

### Recorrido en profundidad

Analiza primero los nodos hijos antes del nodo principal.

### Recorrido postorden

Muy utilizado para evaluar expresiones y verificar tipos.

---

## Verificación de tipos

La verificación de tipos compara los operandos y determina si una operación es válida.

Ejemplo válido:

```c
int a = 5;
float b = 2.5;
```

Ejemplo inválido:

```c
int a = "texto";
```

---

## Conversión de tipos

El compilador puede realizar conversiones automáticas llamadas coerciones.

Ejemplo:

```c
int a = 5;
float b = a;
```

El entero se convierte automáticamente en flotante.

Sin embargo, algunas conversiones generan errores o advertencias.

---

## Reglas semánticas

Las reglas semánticas son restricciones que el programa debe cumplir.

Ejemplos:

- Las variables deben declararse antes de usarse.
- No pueden existir operaciones incompatibles.
- Las funciones deben retornar el tipo correcto.
- Los arreglos deben utilizar índices válidos.

---

## Atributos semánticos

Los atributos semánticos transportan información dentro del árbol sintáctico.

### Atributos sintetizados

Se calculan desde los hijos hacia el padre.

### Atributos heredados

Se transmiten desde el padre hacia los hijos.

Estos atributos permiten determinar tipos y propiedades de expresiones complejas.

---

# 3. Manejo de Errores

El manejo de errores es una de las tareas más complejas e importantes del análisis semántico. El compilador debe detectar errores, reportarlos claramente y continuar el análisis para encontrar la mayor cantidad posible de problemas.

---

# Tipos de errores semánticos

## Variables no declaradas

```c
x = 10;
```

La variable no existe en la tabla de símbolos.

---

## Variables duplicadas

```c
int x;
float x;
```

El identificador fue declarado más de una vez en el mismo alcance.

---

## Incompatibilidad de tipos

```c
int numero;
numero = "hola";
```

El compilador detecta incompatibilidad entre entero y cadena.

---

## Errores en funciones

```c
int suma(int a, int b);

suma(5);
```

Número incorrecto de argumentos.

---

## Errores de retorno

```c
int funcion() {
    return "texto";
}
```

La función debe retornar un entero.

---

# Estrategias de recuperación de errores

Un compilador moderno no debe detenerse al encontrar el primer error. Debe continuar el análisis para generar reportes más completos.

---

## Recuperación por continuación

El compilador ignora temporalmente el error y sigue procesando instrucciones.

### Ejemplo

```c
int x;
x = "hola";
y = 10;
```

Aunque exista un error en `x`, el compilador continúa y detecta también que `y` no fue declarada.

---

## Recuperación mediante valores ficticios

El compilador asigna temporalmente un tipo por defecto para continuar el análisis.

### Ejemplo

Si una variable no existe:

```c
resultado = x + y;
```

El compilador puede asumir temporalmente que `x` y `y` son enteros para continuar verificando el resto del programa.

---

## Supresión de errores en cascada

Un error puede provocar muchos errores derivados.

Ejemplo:

```c
int x = "hola";
x + true;
x / "texto";
```

Todos los errores posteriores provienen del primero.

El compilador intenta evitar reportes innecesarios.

---

# Algoritmos de manejo de errores

## Algoritmo de verificación de variables

### Procedimiento general

1. Leer identificador.
2. Buscar identificador en la tabla de símbolos.
3. Si existe:
   - continuar análisis.
4. Si no existe:
   - generar error semántico.
   - registrar símbolo temporal.

---

## Algoritmo de comprobación de tipos

### Procedimiento

1. Obtener tipo del operando izquierdo.
2. Obtener tipo del operando derecho.
3. Comparar compatibilidad.
4. Si son compatibles:
   - realizar operación.
5. Si no son compatibles:
   - generar error.

---

## Algoritmo de validación de funciones

### Procedimiento

1. Buscar función en la tabla de símbolos.
2. Comparar número de parámetros.
3. Comparar tipos de parámetros.
4. Verificar tipo de retorno.
5. Reportar errores encontrados.

---

# Importancia del manejo de errores

El manejo de errores es fundamental porque:

- Facilita la depuración.
- Reduce tiempo de desarrollo.
- Mejora experiencia del programador.
- Permite detectar múltiples fallos.
- Evita terminaciones abruptas del compilador.

---

# 4. ¿Cómo se construye un Analizador Semántico?

La construcción de un analizador semántico requiere estructuras de datos, algoritmos y recorridos especializados.

---

# Paso 1: Construcción del AST

Después del análisis sintáctico se construye el Árbol de Sintaxis Abstracta.

Este árbol representa expresiones, instrucciones y estructuras del programa.

---

# Paso 2: Creación de la tabla de símbolos

El compilador registra:

- Variables.
- Funciones.
- Constantes.
- Tipos.
- Parámetros.

---

# Paso 3: Recorrido semántico

El compilador recorre el AST verificando reglas semánticas.

Durante este recorrido:

- Consulta la tabla de símbolos.
- Evalúa tipos.
- Detecta errores.
- Genera atributos semánticos.

---

# Paso 4: Reporte de errores

Cada error detectado debe incluir:

- Línea del error.
- Tipo de error.
- Descripción clara.

Ejemplo:

```text
Error semántico en línea 8:
No se puede asignar string a int.
```

---

# Paso 5: Generación de información intermedia

El análisis semántico produce información necesaria para:

- Optimización.
- Generación de código.
- Traducción final.

---

# Ejemplo General de Análisis Semántico

Código:

```c
int x;
float y;

x = y + 2;
```

## Proceso

1. Se registran `x` y `y`.
2. El compilador analiza `y + 2`.
3. Detecta operación entre `float` e `int`.
4. Realiza conversión implícita.
5. Detecta asignación de `float` a `int`.
6. Genera advertencia o conversión automática.

---

# Importancia del Analizador Semántico

El análisis semántico garantiza coherencia lógica y seguridad en los programas.

Sus beneficios incluyen:

- Prevención de errores de ejecución.
- Programas más seguros.
- Mejor optimización.
- Detección temprana de fallos.
- Generación de código más eficiente.

Sin esta etapa muchos errores aparecerían únicamente durante la ejecución del programa.

---

# Conclusión

El analizador semántico es una fase esencial dentro de la construcción de compiladores. Su función principal consiste en validar que las instrucciones del programa tengan significado lógico y respeten las reglas semánticas del lenguaje de programación.

A través de herramientas como la tabla de símbolos, el Árbol de Sintaxis Abstracta y la verificación de tipos, el compilador puede detectar errores relacionados con variables, funciones, operaciones y conversiones antes de ejecutar el programa.

Además, el manejo adecuado de errores permite generar diagnósticos más claros y facilita la depuración de programas complejos. Gracias a ello, el análisis semántico se convierte en un puente fundamental entre la estructura del código y su correcta ejecución.

---

# Bibliografía

Aho, A. V., Lam, M. S., Sethi, R., & Ullman, J. D. (2008). *Compilers: Principles, Techniques, and Tools* (2nd ed.). Pearson.

Appel, A. W. (2002). *Modern Compiler Implementation in Java* (2nd ed.). Cambridge University Press.

Holub, A. I. (1990). *Compiler Design in C*. Prentice Hall.
