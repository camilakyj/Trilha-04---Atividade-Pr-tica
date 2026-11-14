package dobackofront;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        

                int meses = sc.nextInt();

                if (meses <= 0) {
                    System.out.println("Quantidade inválida");
                    sc.close();
                    return;
                }

                double[] faturamento = new double[meses];

                for (int i = 0; i < meses; i++) {
                    faturamento[i] = sc.nextDouble();
                }

                boolean crescimento = true;
                boolean queda = true;
                boolean constante = true;

                for (int i = 1; i < meses; i++) {
                    if (faturamento[i] < faturamento[i - 1]) {
                        crescimento = false;
                    }

                    if (faturamento[i] > faturamento[i - 1]) {
                        queda = false;
                    }

                    if (faturamento[i] != faturamento[i - 1]) {
                        constante = false;
                    }
                }

                System.out.println(">> Análise de Faturamento <<");
                System.out.print("Faturamento informado: ");

                for (int i = 0; i < meses; i++) {
                    System.out.print(faturamento[i]);

                    if (i < meses - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println();

                if (constante) {
                    System.out.println("Situação: Constante");
                } else if (crescimento) {
                    System.out.println("Situação: Crescimento");
                } else if (queda) {
                    System.out.println("Situação: Queda");
                } else {
                    System.out.println("Situação: Sem padrão");
                }

                sc.close();
            }
        }

