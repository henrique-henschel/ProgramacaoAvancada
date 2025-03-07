package org.example;

// Cria a classe de processamento da estrategia de pagamento
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    // Injeta via construtor a estrategia de pagamento escolhida
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Executa o pagamento de acordo com a estrategia escolhida
    public void executePayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}
