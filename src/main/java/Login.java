public class Login {

    // Instance variables

    private static String savedUsername;
    private String savedPassword;
    private String savedPhone;

    // Constructor
    public Login(String username, String password, String phone) {

        savedUsername = username;
        this.savedPassword = password;
        this.savedPhone = phone;
    }

    // Check if the username is valid (contains "_" and max 5 characters)
    public static boolean isUsernameValid(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Check if the password is strong (min 8 chars, 1 capital, 1 digit, 1 special)
    public static boolean isPasswordStrong(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#_$%^&*()].*");
    }

    // Check if the phone number is valid (starts with +27 and has 10 digits after)
    public static boolean isPhoneValid(String phone) {
        return phone.matches("^\\+27\\d{10}$");
    }

    // Attempt to register the user
    public String register(String username, String password, String phone) {
        if (!isUsernameValid(username)) {
            return "Username is invalid. It must contain an underscore and be no more than 5 characters.";
        }

        if (!isPasswordStrong(password)) {
            return "Password is weak. It must be at least 8 characters, with a capital letter, a number, and a special character.";
        }

        if (!isPhoneValid(phone)) {
            return "Phone number format is incorrect. It should start with +27 followed by 10 digits.";
        }

        savedUsername = username;
        savedPassword = password;
        savedPhone = phone;

        return "User registered successfully.";
    }

    // Validate login credentials
    public boolean authenticate(String inputUsername, String inputPassword) {
        return inputUsername.equals(savedUsername) && inputPassword.equals(savedPassword);
    }

    // Return a login message
    public String getLoginMessage(String inputUsername, String inputPassword) {
        if (authenticate(inputUsername, inputPassword)) {
            return "Welcome , it's great to see you again!";
        } else {
            return "Incorrect username or password. Please try again.";
        }
    }
}