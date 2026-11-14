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

        double[] notas = new double[quantidade];
        double soma = 0;
        double maior = 0;
        double menor = 10;
        int aprovados = 0;
        int reprovados = 0;

        for (int i = 0; i < quantidade; i++) {
            notas[i] = sc.nextDouble();

            while (notas[i] < 0 || notas[i] > 10) {
                System.out.println("Nota inválida");
                notas[i] = sc.nextDouble();
            }

            soma += notas[i];

            if (notas[i] > maior) {
                maior = notas[i];
            }

            if (notas[i] < menor) {
                menor = notas[i];
            }

            if (notas[i] >= 6) {
                aprovados++;
            } else {
                reprovados++;
            }
        }

        double media = soma / quantidade;

        System.out.println(">> Resultado da Turma <<");
        System.out.print("Notas informadas: ");

        for (int i = 0; i < quantidade; i++) {
            System.out.print(notas[i]);

            if (i < quantidade - 1) {
                System.out.print(", ");
            }
        }

        System.out.printf(Locale.US, "%nMédia da turma: %.2f%n", media);
        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Reprovados: " + reprovados);

        if (reprovados == 0) {
            System.out.println("Situação geral: Todos os alunos foram aprovados");
        } else {
            System.out.println("Situação geral: Nem todos os alunos foram aprovados");
        }

        sc.close();
    }
}
