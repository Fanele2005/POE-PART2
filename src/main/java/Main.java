import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Registration section



        System.out.print("username");
        String username = scanner.nextLine();

        System.out.print("password ");
        String password = scanner.nextLine();

        System.out.print("phone number");
        String phone = scanner.nextLine();

        Login newUser = new Login(username, password, phone);

        String registrationResult = newUser.register(username, password, phone);
        
        System.out.println(registrationResult);



        // Stop the program if registration failed
        if (!registrationResult.equals("User registered successfully.")) {
            System.out.println("Please fix the above errors and run the program again.");
            return;
        }

        // Step 3: Login section
        System.out.println("Login");
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        // Step 4: Check login and show result
        String loginResult = newUser.getLoginMessage(inputUsername, inputPassword);
        System.out.println(loginResult);

        scanner.close();
    }
}