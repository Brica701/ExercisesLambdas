package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        int reference = 25;

        Comparator<Integer> closenessComparator = (a, b) -> {
            int diff1 = Math.abs(a - reference);
            int diff2 = Math.abs(b - reference);
            return Integer.compare(diff1, diff2);
        };

        List<Integer> list = new ArrayList<>(List.of(10, 30, 22, 15, 35, 25));
        Collections.sort(list, closenessComparator);
        System.out.println("Sorted list based on closeness to " + reference + ": " + list);

        TreeSet<Integer> treeSet = new TreeSet<>(closenessComparator);
        treeSet.addAll(List.of(10, 30, 22, 15, 35, 25));
        System.out.println("TreeSet ordered by closeness to " + reference + ": " + treeSet);

        List<Integer> sortedStreamList = list.stream()
                .sorted(closenessComparator)
                .toList();
        System.out.println("Stream-sorted list based on closeness to " + reference + ": " + sortedStreamList);
    }
}
