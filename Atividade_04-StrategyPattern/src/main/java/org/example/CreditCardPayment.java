package org.example;

import java.util.Scanner;

// Classe de estrategia para pagamento por Cartao de Credito
public class CreditCardPayment implements PaymentStrategy {

    // Implementando o metodo da interface/contrato para pagamentos via Cartao de Credito
    @Override
    public void processPayment(double amount) {
        // Chama o metodo para a entrada do numero do cartao e armazena na variavel
        String cardNumber = scanCardNumber();

        // Exibe as informacoes no terminal
        System.out.println("Pagamento de R$ " + String.format("%.2f", amount) + " realizado com o cartão " + cardNumber + " com sucesso.");
    }

    // Metodo para a entrada do numero do cartao
    private String scanCardNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--> Digite o número do cartão de crédito: ");
        return scanner.nextLine();  // Retorna a entrada do usuario (numero do cartao) - como String
    }
}
