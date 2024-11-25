package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LineasDeEnterosFiltrados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<List<Integer>> conjuntoDeListas = new HashSet<>();

        System.out.println("Introduce varias líneas de texto que consistan en palabras y números. Escribe 'fin' para terminar:");

        while (true) {
            String linea = scanner.nextLine();
            if (linea.equalsIgnoreCase("fin")) {
                break;
            }

            List<Integer> listaDeEnteros = new ArrayList<>();
            String[] elementos = linea.split(" ");
            listaDeEnteros = java.util.Arrays.stream(elementos)
                    .filter(elemento -> {
                        try {
                            Integer.parseInt(elemento);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            conjuntoDeListas.add(listaDeEnteros);
        }

        System.out.println("Contenido del conjunto:");
        conjuntoDeListas.forEach(lista -> {
            lista.forEach(numero -> System.out.print(numero + " "));
            System.out.println();
        });

        scanner.close();
    }
}

