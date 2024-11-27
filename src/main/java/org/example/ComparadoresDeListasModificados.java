package org.example;

import java.util.*;

public class ComparadoresDeListasModificados {
    public static void main(String[] args) {

        Set<List<Integer>> conjuntoListas = new HashSet<>();
        conjuntoListas.add(Arrays.asList(1, 2, 3));
        conjuntoListas.add(Arrays.asList(4, 5));
        conjuntoListas.add(Arrays.asList(6, 7, 8, 9));
        conjuntoListas.add(List.of(10));

        Comparator<List<Integer>> porLongitudYSuma = (lista1, lista2) -> {
            int comparacionLongitud = Integer.compare(lista1.size(), lista2.size());
            if (comparacionLongitud != 0) {
                return comparacionLongitud;
            } else {
                return Integer.compare(
                        lista1.stream().mapToInt(Integer::intValue).sum(),
                        lista2.stream().mapToInt(Integer::intValue).sum()
                );
            }
        };

        Comparator<List<Integer>> porSumaYLongitud = (lista1, lista2) -> {
            int suma1 = lista1.stream().mapToInt(Integer::intValue).sum();
            int suma2 = lista2.stream().mapToInt(Integer::intValue).sum();
            int comparacionSuma = Integer.compare(suma1, suma2);
            if (comparacionSuma != 0) {
                return comparacionSuma;
            } else {
                return Integer.compare(lista1.size(), lista2.size());
            }
        };

        TreeSet<List<Integer>> conjuntoPorLongitudYSuma = new TreeSet<>(porLongitudYSuma);
        conjuntoPorLongitudYSuma.addAll(conjuntoListas);

        TreeSet<List<Integer>> conjuntoPorSumaYLongitud = new TreeSet<>(porSumaYLongitud);
        conjuntoPorSumaYLongitud.addAll(conjuntoListas);

        System.out.println("Conjunto ordenado por longitud y luego por suma:");
        for (List<Integer> lista : conjuntoPorLongitudYSuma) {
            System.out.println(lista + " - Longitud: " + lista.size() + ", Suma: " + lista.stream().mapToInt(Integer::intValue).sum());
        }

        System.out.println("\nConjunto ordenado por suma y luego por longitud:");
        for (List<Integer> lista : conjuntoPorSumaYLongitud) {
            System.out.println(lista + " - Suma: " + lista.stream().mapToInt(Integer::intValue).sum() + ", Longitud: " + lista.size());
        }
    }
}
