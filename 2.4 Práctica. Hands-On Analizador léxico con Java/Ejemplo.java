/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analisislexico;

/**
 *
 * @author namis
 */
public class Ejemplo{
    /** Programa de prueba para el analizador léxico */
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int c = a + b;

        double pi = 3.1416;
        float f = 2.5f;

        String mensaje = "Hola mundo";
        char letra = 'A';

        if (a < b && b > 0) {
            a++;
            b--;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Iteración: " + i);
        }

        while (a > 0) {
            a--;
        }

        // Bloque de operaciones
        int suma = 0;
        suma += 1;
        suma += 2;
        suma += 3;
        suma += 4;
        suma += 5;
        suma += 6;
        suma += 7;
        suma += 8;
        suma += 9;
        suma += 10;

        // Literales
        int hex = 0xFF;
        int bin = 0b1010;
        int oct = 077;

        double num1 = 1.1;
        double num2 = 2.2;
        double num3 = 3.3;

        String s1 = "uno";
        String s2 = "dos";
        String s3 = "tres";

        // Condiciones múltiples
        if (num1 < num2 || num3 > num2) {
            System.out.println("Condición verdadera");
        }

        // Más ciclos
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 3; k++) {
                System.out.println(j + ":" + k);
            }
        }

        // Operadores
        int x = 5;
        x += 2;
        x -= 1;
        x *= 3;
        x /= 2;
        x %= 2;

        boolean flag = true;
        if (!flag) {
            System.out.println("Falso");
        }

        // Uso de switch
        int opcion = 2;
        switch (opcion) {
            case 1:
                System.out.println("Uno");
                break;
            case 2:
                System.out.println("Dos");
                break;
            default:
                System.out.println("Otro");
        }

        // Variables varias
        int v1 = 1;
        int v2 = 2;
        int v3 = 3;
        int v4 = 4;
        int v5 = 5;
        int v6 = 6;
        int v7 = 7;
        int v8 = 8;
        int v9 = 9;
        int v10 = 10;

        // Strings adicionales
        String t1 = "a";
        String t2 = "b";
        String t3 = "c";
        String t4 = "d";
        String t5 = "e";

        // Más condiciones
        if (v1 == 1 && v2 == 2) {
            System.out.println("Correcto");
        }

        if (v3 != 0) {
            System.out.println("No es cero");
        }

        // Error léxico intencional
        @

    }
}

