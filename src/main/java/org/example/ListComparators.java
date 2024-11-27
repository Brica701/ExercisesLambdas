package org.example;

import java.util.*;

public class ListComparators {
    public static void main(String[] args) {
        // Crear un HashSet de listas
        Set<List<Integer>> listSet = new HashSet<>();
        listSet.add(Arrays.asList(1, 2, 3));
        listSet.add(Arrays.asList(4, 5));
        listSet.add(Arrays.asList(6, 7, 8, 9));
        listSet.add(List.of(10));

        Comparator<List<Integer>> byLength = (list1, list2) -> Integer.compare(list1.size(), list2.size());

        Comparator<List<Integer>> bySum = (list1, list2) -> Integer.compare(
                list1.stream().mapToInt(Integer::intValue).sum(),
                list2.stream().mapToInt(Integer::intValue).sum()
        );

        List<Integer> longestList = Collections.max(listSet, byLength);
        System.out.println("Lista más larga: " + longestList);

        List<Integer> highestSumList = Collections.max(listSet, bySum);
        System.out.println("Lista con la suma más alta: " + highestSumList);

        List<Integer> longestListStream = listSet.stream()
                .max(Comparator.comparingInt(List::size))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Lista más larga (streams): " + longestListStream);

        List<Integer> highestSumListStream = listSet.stream()
                .max(Comparator.comparingInt(list -> list.stream().mapToInt(Integer::intValue).sum()))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Lista con la suma más alta (streams): " + highestSumListStream);
    }
}


