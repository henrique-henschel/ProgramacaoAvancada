package org.example;

// Classe de estrategia para pagamento por Boleto
public class BoletoPayment implements PaymentStrategy {

    // Implementando o metodo da interface/contrato para pagamentos via Boleto
    @Override
    public void processPayment(double amount) {
        String boletoCode = generateBoletoCode();  // Variavel para a string retornada

        // Exibe as informacoes no terminal
        System.out.println("Código do boleto gerado: " + boletoCode);
        System.out.println("Boleto gerado para o pagamento de R$ " + String.format("%.2f", amount) + ". Pagamento do boleto em processamento.");
    }

    // Metodo para retornar uma string aleatoria que simula o codigo do boleto
    private String generateBoletoCode() {
        return "BOL-" + java.util.UUID.randomUUID();
    }
}
