/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gramatica.formal;

import java.util.ArrayList;

public class ExpresionesRegulares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   ArrayList<String> cadenas = new ArrayList<>();

        cadenas.add("123");
        cadenas.add("hola");
        cadenas.add("JAVA");
        cadenas.add("contador");
        cadenas.add("_total");
        cadenas.add("9variable");
        cadenas.add("Suma1");
        cadenas.add("?%&");

        // Analizar cada cadena
        for (String cadena : cadenas) {

            if (esEntero(cadena)) {
                System.out.println(cadena + " -> Número entero");

            } else if (esMinusculas(cadena)) {
                System.out.println(cadena + " -> Palabra en minúsculas");

            } else if (esMayusculas(cadena)) {
                System.out.println(cadena + " -> Palabra en mayúsculas");

            } else if (esIdentificador(cadena)) {
                System.out.println(cadena + " -> Identificador válido");
         
            }else if (esSimbolo(cadena)) {
                System.out.println(cadena + " -> Compuesto por simbolos");
        
            } else {
                System.out.println(cadena + " -> No reconocido");
            }
        }
    }

    // Métodos de validación

    public static boolean esEntero(String s) {
        return s.matches("[0-9]+");
    }

    public static boolean esMinusculas(String s) {
        return s.matches("[a-z]+");
    }

    public static boolean esMayusculas(String s) {
        return s.matches("[A-Z]+");
    }

    public static boolean esIdentificador(String s) {
        return s.matches("[a-zA-Z_$][a-zA-Z0-9_$]*");
    }
    public static boolean esSimbolo(String s){
        return s.matches("[+\\-*/%<>=!&|^~(){}\\[\\];,.:?_#@]+");
    }
    }
    

