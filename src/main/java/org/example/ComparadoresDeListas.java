package org.example;

import java.util.*;

public class ComparadoresDeListas {
    public static void main(String[] args) {
        Set<List<Integer>> conjuntoListas = new HashSet<>();

        conjuntoListas.add(Arrays.asList(1, 2, 3));
        conjuntoListas.add(Arrays.asList(4, 5));
        conjuntoListas.add(Arrays.asList(6, 7, 8, 9));
        conjuntoListas.add(List.of(10));

        Comparator<List<Integer>> porSuma = (lista1, lista2) -> Integer.compare(
                lista1.stream().mapToInt(Integer::intValue).sum(),
                lista2.stream().mapToInt(Integer::intValue).sum()
        );

        Comparator<List<Integer>> porLongitud = (lista1, lista2) -> Integer.compare(lista1.size(), lista2.size());

        TreeSet<List<Integer>> conjuntoPorSuma = new TreeSet<>(porSuma);
        conjuntoPorSuma.addAll(conjuntoListas);

        TreeSet<List<Integer>> conjuntoPorLongitud = new TreeSet<>(porLongitud);
        conjuntoPorLongitud.addAll(conjuntoListas);

        System.out.println("Conjunto ordenado por suma:");
        for (List<Integer> lista : conjuntoPorSuma) {
            System.out.println(lista + " - Suma: " + lista.stream().mapToInt(Integer::intValue).sum());
        }

        System.out.println("\nConjunto ordenado por longitud:");
        for (List<Integer> lista : conjuntoPorLongitud) {
            System.out.println(lista + " - Longitud: " + lista.size());
        }
    }
}

