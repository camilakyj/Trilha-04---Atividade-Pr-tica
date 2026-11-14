package dobackofront;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine().toUpperCase();

        if (palavra.isEmpty()) {
            System.out.println("Palavra inválida");
            sc.close();
            return;
        }

        char[] secreta = palavra.toCharArray();
        char[] descoberta = new char[secreta.length];

        for (int i = 0; i < descoberta.length; i++) {
            descoberta[i] = '_';
        }

        // Oculta a palavra no console
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        int erros = 0;
        boolean venceu = false;

        while (erros < 7 && !venceu) {
            String entrada = sc.nextLine().toUpperCase();

            if (entrada.isEmpty()) {
                continue;
            }

            char letra = entrada.charAt(0);
            boolean encontrou = false;

            for (int i = 0; i < secreta.length; i++) {
                if (secreta[i] == letra) {
                    descoberta[i] = letra;
                    encontrou = true;
                }
            }

            if (!encontrou) {
                erros++;
            }

            System.out.print("Forca: ");

            for (int i = 0; i < descoberta.length; i++) {
                System.out.print(descoberta[i] + " ");
            }

            System.out.println();
            System.out.println("Erros: " + erros);

            venceu = true;

            for (int i = 0; i < descoberta.length; i++) {
                if (descoberta[i] == '_') {
                    venceu = false;
                }
            }
        }

        if (venceu) {
            System.out.println("Parabéns! Você descobriu a palavra.");
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavra);
        }

        sc.close();
    }
}
