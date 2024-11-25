package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LineasDeEnterosConSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Set<Integer>> listaDeConjuntos = new ArrayList<>();

        System.out.println("Introduce varias líneas de texto que consistan en palabras y números. Escribe 'fin' para terminar:");

        while (true) {
            String linea = scanner.nextLine();
            if (linea.equalsIgnoreCase("fin")) {
                break;
            }

            Set<Integer> conjuntoDeEnteros = new HashSet<>();
            String[] elementos = linea.split(" ");
            conjuntoDeEnteros = java.util.Arrays.stream(elementos)
                    .filter(elemento -> {
                        try {
                            Integer.parseInt(elemento);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            listaDeConjuntos.add(conjuntoDeEnteros);
        }

        System.out.println("Contenido de la lista de conjuntos:");
        listaDeConjuntos.forEach(conjunto -> {
            conjunto.forEach(numero -> System.out.print(numero + " "));
            System.out.println();
        });

        scanner.close();
    }
}
