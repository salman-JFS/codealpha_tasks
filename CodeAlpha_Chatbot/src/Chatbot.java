
public class Chatbot {

    public String getResponse(String message) {

        message = message.toLowerCase().trim();

        if (message.contains("hello") || message.contains("hi")
                || message.contains("hey")) {
            return "Hello! How can I help you?";
        }

        if (message.contains("how are you")) {
            return "I am doing great! Thanks for asking.";
        }

        if (message.contains("your name")) {
            return "I am CodeAlpha Chatbot.";
        }

        if (message.contains("who are you")) {
            return "I am a simple rule-based chatbot developed using Java.";
        }

        if (message.contains("java")) {
            return "Java is a popular object-oriented programming language.";
        }

        if (message.contains("internship")) {
            return "This chatbot is developed as part of the CodeAlpha Java Programming Internship.";
        }

        if (message.contains("codealpha")) {
            return "CodeAlpha provides internship opportunities for students to gain practical experience.";
        }

        if (message.contains("help")) {
            return "You can ask me about Java, CodeAlpha, the internship, or general questions.";
        }

        if (message.contains("thank")) {
            return "You're welcome!";
        }

        if (message.contains("bye") || message.contains("exit")) {
            return "Goodbye! Have a nice day.";
        }

        return "Sorry, I don't understand that. Try asking something else.";
    }
}