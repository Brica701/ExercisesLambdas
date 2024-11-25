package org.example;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce algunas palabras (separadas por espacios):");
        String entrada = scanner.nextLine();

        Set<String> palabras = new TreeSet<>();
        for (String palabra : entrada.split(" ")) {
            palabras.add(palabra);
        }

        System.out.println("Palabras en TreeSet:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        scanner.close();
    }
}
