package org.example;

// Classe do metodo de fabrica
// Retorna a instancia da estrategia de pagamento correspondente
public class PaymentStrategyFactory {
    public static PaymentStrategy createPaymentStrategy(int option) {
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
}
