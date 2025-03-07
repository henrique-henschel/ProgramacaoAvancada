package org.example;

// Classe de estrategia para pagamento por Pix
public class PixPayment implements PaymentStrategy {

    // Implementando o metodo da interface/contrato para pagamentos via Pix
    @Override
    public void processPayment(double amount) {
        String pixCode = generatePixCode();  // Variavel para a string retornada

        // Exibe as informacoes no terminal
        System.out.println("Código Pix gerado: " + pixCode);
        System.out.println("Pagamento de R$ " + String.format("%.2f", amount) + " realizado via Pix com sucesso.");
    }

    // Metodo para retornar uma string aleatoria que simula o codigo Pix
    private String generatePixCode() {
        return java.util.UUID.randomUUID().toString();
    }
}
