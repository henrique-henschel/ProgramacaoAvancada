package org.example;

import java.util.Scanner;

// Classe principal que interage diretamente com o usuario
public class Main {
    public static void main(String[] args) {
        PaymentStrategy strategy = selectPaymentMethod();  // Chama metodo para o menu de opcoes
        double amount = getPaymentAmount();  // Chama metodo para receber o valor do pagamento

        // Executa o pagamento de acordo com a estrategia que o usuario escolheu em tempo de execucao
        PaymentProcessor processor = new PaymentProcessor(strategy);
        processor.executePayment(amount);
    }

    // Exibir o menu de opcoes na tela para que o usuario escolha a opcao de pagamento
    private static PaymentStrategy selectPaymentMethod() {
        Scanner scanner = new Scanner(System.in);
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

        return switch (option) {
            case 1 -> new PixPayment();
            case 2 -> new CreditCardPayment();
            case 3 -> new BoletoPayment();
            default -> {
                System.out.println("Opção INVÁLIDA, selecionando Pix por padrão.");
                yield new PixPayment();
            }
        };
    }

    // Retornar o valor do pagamento que o usuario "entrar" no prompt
    private static double getPaymentAmount() {
        Scanner scanner = new Scanner(System.in);
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
