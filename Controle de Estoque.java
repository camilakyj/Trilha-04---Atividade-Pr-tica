package dobackofront;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] produtos = new String[1000];
        int[] quantidades = new int[1000];

        int total = 0;
        int opcao;

        do {
            System.out.println("Menu de Opções");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Realizar entrada no estoque");
            System.out.println("3. Realizar saída no estoque");
            System.out.println("4. Listar estoque");
            System.out.println("0. Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (total >= 1000) {
                        System.out.println("Limite de produtos atingido");
                    } else {
                        String nome = sc.nextLine();
                        int quantidade = sc.nextInt();

                        if (quantidade < 0) {
                            System.out.println("Quantidade inválida");
                        } else {
                            produtos[total] = nome;
                            quantidades[total] = quantidade;
                            total++;

                            System.out.println("Produto adicionado com sucesso!");
                        }
                    }
                    break;

                case 2:
                    if (total == 0) {
                        System.out.println("Nenhum produto cadastrado");
                        break;
                    }

                    int produtoEntrada = sc.nextInt();
                    int qtdEntrada = sc.nextInt();

                    if (produtoEntrada < 1 || produtoEntrada > total || qtdEntrada <= 0) {
                        System.out.println("Dados inválidos");
                    } else {
                        quantidades[produtoEntrada - 1] += qtdEntrada;
                        System.out.println("Entrada realizada com sucesso!");
                    }
                    break;

                case 3:
                    if (total == 0) {
                        System.out.println("Nenhum produto cadastrado");
                        break;
                    }

                    int produtoSaida = sc.nextInt();
                    int qtdSaida = sc.nextInt();

                    if (produtoSaida < 1 || produtoSaida > total || qtdSaida <= 0) {
                        System.out.println("Dados inválidos");
                    } else if (qtdSaida > quantidades[produtoSaida - 1]) {
                        System.out.println("Estoque insuficiente");
                    } else {
                        quantidades[produtoSaida - 1] -= qtdSaida;
                        System.out.println("Saída realizada com sucesso!");
                    }
                    break;

                case 4:
                    if (total == 0) {
                        System.out.println("Nenhum produto cadastrado");
                    } else {
                        System.out.println("Estoque atual:");

                        for (int i = 0; i < total; i++) {
                            System.out.println("Produto " + (i + 1) + ": " +
                                    produtos[i] + " - " + quantidades[i] + " unidades");
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
