
import java.util.Scanner;

public class TrocaFigurinhas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtdA = sc.nextInt();
        int[] jogadorA = new int[qtdA];

        for (int i = 0; i < qtdA; i++) {
            jogadorA[i] = sc.nextInt();
        }

        int qtdB = sc.nextInt();
        int[] jogadorB = new int[qtdB];

        for (int i = 0; i < qtdB; i++) {
            jogadorB[i] = sc.nextInt();
        }

        int[] comuns = new int[Math.min(qtdA, qtdB)];
        int[] apenasA = new int[qtdA];
        int[] apenasB = new int[qtdB];

        int totalComuns = 0;
        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < qtdA; i++) {
            boolean existeB = false;

            for (int j = 0; j < qtdB; j++) {
                if (jogadorA[i] == jogadorB[j]) {
                    existeB = true;
                    break;
                }
            }

            if (existeB) {
                boolean repetida = false;

                for (int j = 0; j < totalComuns; j++) {
                    if (comuns[j] == jogadorA[i]) {
                        repetida = true;
                    }
                }

                if (!repetida) {
                    comuns[totalComuns++] = jogadorA[i];
                }
            } else {
                boolean repetida = false;

                for (int j = 0; j < totalA; j++) {
                    if (apenasA[j] == jogadorA[i]) {
                        repetida = true;
                    }
                }

                if (!repetida) {
                    apenasA[totalA++] = jogadorA[i];
                }
            }
        }

        for (int i = 0; i < qtdB; i++) {
            boolean existeA = false;

            for (int j = 0; j < qtdA; j++) {
                if (jogadorB[i] == jogadorA[j]) {
                    existeA = true;
                    break;
                }
            }

            if (!existeA) {
                boolean repetida = false;

                for (int j = 0; j < totalB; j++) {
                    if (apenasB[j] == jogadorB[i]) {
                        repetida = true;
                    }
                }

                if (!repetida) {
                    apenasB[totalB++] = jogadorB[i];
                }
            }
        }

        System.out.print("Figurinhas em comum: ");
        for (int i = 0; i < totalComuns; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(comuns[i]);
        }

        System.out.println();

        System.out.print("Apenas jogador A: ");
        for (int i = 0; i < totalA; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(apenasA[i]);
        }

        System.out.println();

        System.out.print("Apenas jogador B: ");
        for (int i = 0; i < totalB; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(apenasB[i]);
        }

        System.out.println();

        int trocas = Math.min(totalA, totalB);

        System.out.println("Quantidade de trocas possíveis: " + trocas);

        sc.close();
    }
}
