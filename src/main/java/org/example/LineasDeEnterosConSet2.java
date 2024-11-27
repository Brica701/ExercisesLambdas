package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LineasDeEnterosConSet2 {
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

        List<Integer> listaMasLarga = encontrarListaMasLarga(conjuntoDeListas);
        System.out.println("La lista más larga es:");
        listaMasLarga.forEach(numero -> System.out.print(numero + " "));
        System.out.println();

        scanner.close();
    }

    public static List<Integer> encontrarListaMasLarga(Set<List<Integer>> conjunto) {
        return conjunto.stream()
                .reduce(new ArrayList<>(), (l1, l2) -> l1.size() > l2.size() ? l1 : l2);
    }
}
