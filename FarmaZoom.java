package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);


        int quantidade = sc.nextInt();

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida");
            sc.close();
            return;
        }

        double[] farmaciaA = new double[quantidade];
        double[] farmaciaB = new double[quantidade];

        double totalA = 0;
        double totalB = 0;

        int baratosA = 0;
        int baratosB = 0;
        int iguais = 0;

        for (int i = 0; i < quantidade; i++) {
            farmaciaA[i] = sc.nextDouble();
            totalA += farmaciaA[i];
        }

        for (int i = 0; i < quantidade; i++) {
            farmaciaB[i] = sc.nextDouble();
            totalB += farmaciaB[i];
        }

        for (int i = 0; i < quantidade; i++) {
            if (farmaciaA[i] < farmaciaB[i]) {
                baratosA++;
            } else if (farmaciaB[i] < farmaciaA[i]) {
                baratosB++;
            } else {
                iguais++;
            }
        }

        System.out.println("FARMAZOOM");

        System.out.print("Farmácia A: ");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(farmaciaA[i]);
            if (i < quantidade - 1) System.out.print(", ");
        }

        System.out.println();

        System.out.print("Farmácia B: ");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(farmaciaB[i]);
            if (i < quantidade - 1) System.out.print(", ");
        }

        System.out.println();
        System.out.println("Produtos mais Baratos");
        System.out.println("Na Farmácia A: " + baratosA);
        System.out.println("Na Farmácia B: " + baratosB);
        System.out.println("Mesmo preço: " + iguais);

        System.out.println("Total");
        System.out.printf(Locale.US, "Farmácia A: R$ %.2f%n", totalA);
        System.out.printf(Locale.US, "Farmácia B: R$ %.2f%n", totalB);

        System.out.println("Melhor opção");

        if (totalA < totalB) {
            System.out.println("Farmácia A");
        } else if (totalB < totalA) {
            System.out.println("Farmácia B");
        } else {
            System.out.println("Empate");
        }

        sc.close();
    }
}
