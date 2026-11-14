package dobackofront;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tarefas = new String[1000];
        boolean[] concluidas = new boolean[1000];

        int total = 0;
        int opcao;

        do {
            System.out.println("Menu de Opções");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar concluída");
            System.out.println("4. Exibir pendentes");
            System.out.println("0. Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (total >= 1000) {
                        System.out.println("Limite de tarefas atingido");
                    } else {
                        tarefas[total] = sc.nextLine();
                        concluidas[total] = false;
                        total++;

                        System.out.println("Tarefa adicionada com sucesso!");
                    }
                    break;

                case 2:
                    if (total == 0) {
                        System.out.println("Nenhuma tarefa cadastrada");
                    } else {
                        System.out.println("Lista de tarefas:");

                        for (int i = 0; i < total; i++) {
                            String status = concluidas[i] ? "[X]" : "[ ]";

                            System.out.println((i + 1) + " - " +
                                    status + " " + tarefas[i]);
                        }
                    }
                    break;

                case 3:
                    if (total == 0) {
                        System.out.println("Nenhuma tarefa cadastrada");
                        break;
                    }

                    int numero = sc.nextInt();

                    if (numero < 1 || numero > total) {
                        System.out.println("Tarefa inválida");
                    } else {
                        concluidas[numero - 1] = true;

                        System.out.println("Tarefa " + numero +
                                " marcada como concluída.");
                    }
                    break;

                case 4:
                    if (total == 0) {
                        System.out.println("Nenhuma tarefa cadastrada");
                    } else {
                        System.out.println("Tarefas pendentes:");

                        boolean possuiPendentes = false;

                        for (int i = 0; i < total; i++) {
                            if (!concluidas[i]) {
                                System.out.println((i + 1) +
                                        " - [ ] " + tarefas[i]);
                                possuiPendentes = true;
                            }
                        }

                        if (!possuiPendentes) {
                            System.out.println("Nenhuma tarefa pendente");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);

        sc.close();
    }
}
