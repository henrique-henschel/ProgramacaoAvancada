import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String option = selectNotification();  // Chama o metodo para o menu e escolha da opcao desejada
        String message = getMessage();  // Armazena a mensagem a ser enviada (como String)

        try {
            Notification notification = NotificationFactory.createNotification(option);
            notification.send(message);  // Se a opcao escolhida for valida, envia a mensagem
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO ao selecionar uma opção INVÁLIDA de notificação. ERRO: " + e.getMessage());
        }
    }

    // Metodo para exibir o menu na tela e retornar a entrada (opcao escolhida) do usuario
    private static String selectNotification() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1 - E-mail");
        System.out.println("2 - SMS");
        System.out.println("3 - Push Notification");
        System.out.print("\n--> Digite o número corresponte à opção escolhida: ");

        return scanner.nextLine();
    }

    // Metodo para retornar a mensagem que o usuario deseja enviar
    private static String getMessage() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n>>> Digite a mensagem: ");

        return scanner.nextLine();
    }
}
