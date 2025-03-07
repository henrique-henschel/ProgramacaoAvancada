public class NotificationFactory {

    // Metodo para retornar uma instancia da forma escolhida para o envio da notificacao
    public static Notification createNotification(String type) {
        return switch (type) {
            case "1" -> new EmailNotification();
            case "2" -> new SMSNotification();
            case "3" -> new PushNotification();
            default -> throw new IllegalArgumentException("A OPÇÃO '" + type + "' É INVÁLIDA.");
        };
    }
}
