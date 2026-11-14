package dobackofront;


import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int dias = sc.nextInt();

        if (dias <= 0) {
            System.out.println("Quantidade inválida");
            sc.close();
            return;
        }

        double[] pesos = new double[dias];

        for (int i = 0; i < dias; i++) {
            pesos[i] = sc.nextDouble();

            while (pesos[i] <= 0) {
                System.out.println("Peso inválido");
                pesos[i] = sc.nextDouble();
            }
        }

        double maior = pesos[0];
        double menor = pesos[0];
        int diaMaior = 1;
        int diaMenor = 1;

        for (int i = 1; i < dias; i++) {
            if (pesos[i] > maior) {
                maior = pesos[i];
                diaMaior = i + 1;
            }

            if (pesos[i] < menor) {
                menor = pesos[i];
                diaMenor = i + 1;
            }
        }

        System.out.print("Pesos informados: ");

        for (int i = 0; i < dias; i++) {
            System.out.print(pesos[i]);

            if (i < dias - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Maior peso: " + maior + " kg (Dia " + diaMaior + ")");
        System.out.println("Menor peso: " + menor + " kg (Dia " + diaMenor + ")");

        System.out.println("Gráfico de evolução:");

        for (int i = 0; i < dias; i++) {
            System.out.print("Dia " + (i + 1) + " | ");

            int barras = (int) (pesos[i] / 5);

            for (int j = 0; j < barras; j++) {
                System.out.print("█");
            }

            System.out.println(" " + pesos[i]);
        }

        sc.close();
    }
}
