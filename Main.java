import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        boolean loggedIn = false;
        String username = "";
        String password = "";

        // Login process
        while (!loggedIn) {
            username = JOptionPane.showInputDialog("Enter Username:");
            password = JOptionPane.showInputDialog("Enter Password:");

            if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
                loggedIn = true;
                JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter both username and password.");
            }
        }

        // Main menu
        boolean running = true;
        while (running) {
            String[] options = {"Send Messages", "Show Recently Sent Messages", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "QuickChat Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    sendMessages();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Coming Soon.");
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void sendMessages() {
        String messageCountStr = JOptionPane.showInputDialog("How many messages do you want to send?");
        if (messageCountStr != null && !messageCountStr.isEmpty()) {
            try {
                int messageCount = Integer.parseInt(messageCountStr);
                for (int i = 0; i < messageCount; i++) {
                    String message = JOptionPane.showInputDialog("Enter message " + (i + 1) + ":");
                    if (message != null && !message.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Message sent: " + message);
                    } else {
                        JOptionPane.showMessageDialog(null, "Message cannot be empty.");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a number.");
        }
    }
}