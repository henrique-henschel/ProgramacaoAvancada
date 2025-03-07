public class PushNotification implements Notification {

    // Implementacao do metodo de envio de mensagem por push notification
    @Override
    public void send(String message) {
        System.out.println("Enviando a mensagem '" + message + "' por push notification...");
    }
}
