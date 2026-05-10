package org.example;

public class Main {
    public static void main(String[] args) {

        String frase = "voltando as origens!!";
        System.out.println(frase);

        String[] fraseSeparada = frase.split(" ");

        for (String palavra : fraseSeparada) {
            System.out.println(palavra+ "\n");
        }

        System.out.println("feplps");
    }
}