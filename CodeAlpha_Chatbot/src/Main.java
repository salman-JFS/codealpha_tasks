import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Chatbot chatbot = new Chatbot();

        System.out.println("==================================");
        System.out.println("          CODEALPHA CHATBOT");
        System.out.println("==================================");
        System.out.println("Type 'help' to see what you can ask.");
        System.out.println("Type 'bye' or 'exit' to end the chat.");

        while (true) {

            System.out.print("\nYou: ");
            String message = scanner.nextLine();

            String response = chatbot.getResponse(message);

            System.out.println("Bot: " + response);

            if (message.equalsIgnoreCase("bye")
                    || message.equalsIgnoreCase("exit")) {
                break;
            }
        }

        scanner.close();
    }
}
