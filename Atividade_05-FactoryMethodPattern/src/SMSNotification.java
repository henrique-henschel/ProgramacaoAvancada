public class SMSNotification implements Notification {

    // Implementacao do metodo de envio de mensagem por SMS
    @Override
    public void send(String message) {
        System.out.println("Enviando a mensagem '" + message + "' por SMS...");
    }
}
