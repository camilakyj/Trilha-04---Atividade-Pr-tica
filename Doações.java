package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);


        String projeto = sc.nextLine();
        int quantidade = sc.nextInt();
        double meta = sc.nextDouble();

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida");
            sc.close();
            return;
        }

        double[] doacoes = new double[quantidade];
        double total = 0;
        double maior = 0;

        for (int i = 0; i < quantidade; i++) {
            doacoes[i] = sc.nextDouble();

            total += doacoes[i];

            if (doacoes[i] > maior) {
                maior = doacoes[i];
            }
        }

        System.out.println(">> Resumo das Doações <<");
        System.out.println("Projeto: " + projeto);
        System.out.print("Doações recebidas: ");

        for (int i = 0; i < quantidade; i++) {
            System.out.print(doacoes[i]);

            if (i < quantidade - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Total arrecadado: " + total);
        System.out.println("Maior doação: " + maior);

        if (total >= meta) {
            System.out.println("Situação: Meta atingida");
        } else {
            System.out.println("Situação: Meta não atingida");
        }

        sc.close();
    }
}
