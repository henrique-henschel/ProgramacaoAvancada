public class EmailNotification implements Notification {

    // Implementacao do metodo de envio de mensagem por e-mail
    @Override
    public void send(String message) {
        System.out.println("Enviando a mensagem '" + message + "' por e-mail...");
    }
}
