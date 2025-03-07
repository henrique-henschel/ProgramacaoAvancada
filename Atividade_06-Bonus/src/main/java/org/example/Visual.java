package org.example;

import java.util.Scanner;

// Classe para exibir os menus (saidas) e ler e retornas as entradas do usuario
// Interface grafica para interacao com o usuario e entrada de dados
public class Visual {
    Scanner scanner = new Scanner(System.in);  // Novo objeto scanner

    public Visual() {
        // Construtor padrao
    }

    // Exibir o menu de opcoes na tela para que o usuario escolha a opcao de pagamento
    public int selectPaymentOption() {
        int option = -1;

        while (option < 1 || option > 3) {
            System.out.println("Escolha o método de pagamento:");
            System.out.println("1 - Pix");
            System.out.println("2 - Cartão de crédito");
            System.out.println("3 - Boleto\n");
            System.out.print("--> Digite apenas o número da opção escolhida: ");

            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
                if (option < 1 || option > 3) {
                    System.out.println("Opção INVÁLIDA! Escolha um NÚMERO ENTRE 1 E 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada INVÁLIDA! Digite um NÚMERO INTEIRO (1, 2 ou 3).");
            }
        }
        return option;
    }

    // Retornar o valor do pagamento que o usuario "entrar" no prompt
    public double getPaymentAmount() {
        double amount = -1.0;

        while (amount <= 0) {
            System.out.print("Digite o valor do pagamento: ");
            String input = scanner.nextLine();

            try {
                amount = Double.parseDouble(input);
                if (amount <= 0) {
                    System.out.println("ERRO! O valor do pagamento deve ser MAIOR do que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada INVÁLIDA. Digite um valor numérico válido.");
            }
        }
        return amount;
    }
}
