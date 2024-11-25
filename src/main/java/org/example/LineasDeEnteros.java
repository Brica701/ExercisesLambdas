package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LineasDeEnteros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<List<Integer>> conjuntoDeListas = new HashSet<>();

        System.out.println("Introduce varias líneas de texto que consistan solo en enteros (separados por espacios). Escribe 'fin' para terminar:");

        while (true) {
            String linea = scanner.nextLine();
            if (linea.equalsIgnoreCase("fin")) {
                break;
            }

            List<Integer> listaDeEnteros = new ArrayList<>();
            String[] numeros = linea.split(" ");
            for (String numero : numeros) {
                listaDeEnteros.add(Integer.parseInt(numero));
            }

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

