/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automata_finito_determinista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lectura {

    public void leer(String archivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String[] primera = br.readLine().split("\\s+");

            int N = Integer.parseInt(primera[0]);
            int S = Integer.parseInt(primera[1]);
            int D = Integer.parseInt(primera[2]);
            int q0 = Integer.parseInt(primera[3]);
            int T = Integer.parseInt(primera[4]);
            int C = Integer.parseInt(primera[5]);

            // Leer alfabeto
            String[] alfabeto = br.readLine().split("\\s+");

            if (alfabeto.length != S) {
                System.out.println("Error: tamaño de alfabeto incorrecto");
                return;
            }

            // Mapa para convertir símbolo → índice
            Map<String, Integer> indiceSimbolo = new HashMap<>();
            for (int i = 0; i < S; i++) {
                indiceSimbolo.put(alfabeto[i], i);
            }

            // Estados finales
            String[] finalesStr = br.readLine().split("\\s+");
            boolean[] esFinal = new boolean[N + 1];

            if (finalesStr.length != T) {
                System.out.println("Error: número de estados finales incorrecto");
                return;
            }

            for (String f : finalesStr) {
                int estado = Integer.parseInt(f);
                if (estado < 1 || estado > N) {
                    System.out.println("Estado final fuera de rango");
                    return;
                }
                esFinal[estado] = true;
            }

            // Tabla de transiciones
            int[][] trans = new int[N + 1][S];

            for (int i = 0; i < D; i++) {

                String[] partes = br.readLine().split("\\s+");

                int origen = Integer.parseInt(partes[0]);
                String simbolo = partes[1];
                int destino = Integer.parseInt(partes[2]);

                if (!indiceSimbolo.containsKey(simbolo)) {
                    System.out.println("Símbolo no pertenece al alfabeto: " + simbolo);
                    return;
                }

                if (origen < 1 || origen > N || destino < 1 || destino > N) {
                    System.out.println("Estado fuera de rango en transición");
                    return;
                }

                int col = indiceSimbolo.get(simbolo);
                trans[origen][col] = destino;
            }

            // Procesar cadenas
            for (int i = 0; i < C; i++) {

                String cadena = br.readLine();
                int estado = q0;

                for (int j = 0; j < cadena.length(); j++) {

                    String simbolo = String.valueOf(cadena.charAt(j));

                    if (!indiceSimbolo.containsKey(simbolo)) {
                        estado = -1;
                        break;
                    }

                    int col = indiceSimbolo.get(simbolo);
                    estado = trans[estado][col];
                }

                if (estado != -1 && esFinal[estado]) {
                    System.out.println(cadena + " ACEPTADA");
                } else {
                    System.out.println(cadena + " RECHAZADA");
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }
}

