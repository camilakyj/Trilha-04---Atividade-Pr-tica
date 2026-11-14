package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double[] transacoes = new double[1000];
        int quantidade = 0;

        while (true) {
            double valor = sc.nextDouble();

            if (valor == -1) {
                break;
            }

            if (valor == 0) {
                if (quantidade > 0) {
                    quantidade--;
                }
            } else {
                if (quantidade < 1000) {
                    transacoes[quantidade] = valor;
                    quantidade++;
                } else {
                    System.out.println("Limite de operações atingido");
                }
            }
        }

        double saldo = 0;

        for (int i = 0; i < quantidade; i++) {
            saldo += transacoes[i];
        }

        System.out.printf(Locale.US, "Saldo final: %.2f%n", saldo);

        sc.close();
    }
}
