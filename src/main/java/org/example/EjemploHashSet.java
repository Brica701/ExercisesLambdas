package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EjemploHashSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce algunas palabras (separadas por espacios):");
        String entrada = scanner.nextLine();

        Set<String> palabras = new HashSet<>();
        for (String palabra : entrada.split(" ")) {
            palabras.add(palabra);
        }

        System.out.println("Palabras en HashSet:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        scanner.close();
    }
}


