package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Given number to compare closeness to
        int reference = 25;

        // Define a Comparator using a lambda
        Comparator<Integer> closenessComparator = (a, b) -> {
            int diff1 = Math.abs(a - reference);
            int diff2 = Math.abs(b - reference);
            return Integer.compare(diff1, diff2); // Compare based on closeness
        };

        // 1. Using ArrayList and Collections.sort
        List<Integer> list = new ArrayList<>(List.of(10, 30, 22, 15, 35, 25));
        Collections.sort(list, closenessComparator);
        System.out.println("Sorted list based on closeness to " + reference + ": " + list);

        // 2. Using a TreeSet with the Comparator
        TreeSet<Integer> treeSet = new TreeSet<>(closenessComparator);
        treeSet.addAll(List.of(10, 30, 22, 15, 35, 25));
        System.out.println("TreeSet ordered by closeness to " + reference + ": " + treeSet);

        // 3. Using a stream with its built-in sort method
        List<Integer> sortedStreamList = list.stream()
                .sorted(closenessComparator)
                .toList();
        System.out.println("Stream-sorted list based on closeness to " + reference + ": " + sortedStreamList);
    }
}
