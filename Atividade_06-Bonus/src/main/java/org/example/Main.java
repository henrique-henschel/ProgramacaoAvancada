package org.example;

// Classe principal que interage diretamente com o usuario
public class Main {
    public static void main(String[] args) {

        // Instancia a classe dos menus/interface e entrada do usuario
        Visual visual = new Visual();

        // Chama o metodo da classe visual para o menu de opcoes
        int option = visual.selectPaymentOption();

        // Chama o metodo da classe Factory para retornar a instancia correspondente de
        // estrategia de pagamento
        PaymentStrategy strategy = PaymentStrategyFactory.createPaymentStrategy(option);

        // Chama o metodo da classe visual para receber o valor do pagamento
        double amount = visual.getPaymentAmount();

        // Executa o pagamento de acordo com a estrategia que o usuario escolheu em tempo de execucao
        PaymentProcessor processor = new PaymentProcessor(strategy);
        processor.executePayment(amount);
    }
}
