package org.example;

// Cria a/o interface/contrato de estrategia a ser implementado
public interface PaymentStrategy {

    // Metodo do contrato para processar pagamento
    void processPayment(double amount);
}
