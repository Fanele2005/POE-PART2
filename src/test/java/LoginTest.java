import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testIsUsernameValid() {
        assertTrue(Login.isUsernameValid("abc_"));
        assertFalse(Login.isUsernameValid("abcdef"));
        assertFalse(Login.isUsernameValid("abcde"));
    }

    @Test
    public void testIsPasswordStrong() {
        assertTrue(Login.isPasswordStrong("Password1!"));
        assertFalse(Login.isPasswordStrong("password")); // no capital, digit, or special
        assertFalse(Login.isPasswordStrong("Password")); // no digit or special
        assertFalse(Login.isPasswordStrong("Pass1")); // too short
    }

    @Test
    public void testIsPhoneValid() {
        assertTrue(Login.isPhoneValid("+271234567890"));
        assertFalse(Login.isPhoneValid("0123456789")); // missing +27
        assertFalse(Login.isPhoneValid("+27123456")); // too short
    }

    @Test
    public void testRegisterSuccess() {
        Login login = new Login("jd_1", "Password1!", "+271234567890");
        String result = login.register("jd_1", "Password1!", "+271234567890");
        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testRegisterInvalidUsername() {
        Login login = new Login("jd_1", "Password1!", "+271234567890");
        String result = login.register("johnny", "Password1!", "+271234567890");
        assertEquals("Username is invalid. It must contain an underscore and be no more than 5 characters.", result);
    }

    @Test
    public void testRegisterWeakPassword() {
        Login login = new Login("jd_1", "Password1!", "+271234567890");
        String result = login.register("jd_1", "weakpass", "+271234567890");
        assertEquals("Password is weak. It must be at least 8 characters, with a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testRegisterInvalidPhone() {
        Login login = new Login("jd_1", "Password1!", "+271234567890");
        String result = login.register("jd_1", "Password1!", "1234567890");
        assertEquals("Phone number format is incorrect. It should start with +27 followed by 10 digits.", result);
    }

    @Test
    public void testAuthenticateSuccess() {
        Login login = new Login("jd_1", "Password1!", "+271234567890");
        login.register("jd_1", "Password1!", "+271234567890");
        assertTrue(login.authenticate("jd_1", "Password1!"));
    }

    @Test
    public void testAuthenticateFailure() {
        Login login = new Login( "jd_1", "Password1!", "+271234567890");
        login.register("jd_1", "Password1!", "+271234567890");
        assertFalse(login.authenticate("wrong", "Password1!"));
        assertFalse(login.authenticate("jd_1", "WrongPass"));
    }

    @Test
    public void testGetLoginMessageSuccess() {
        Login login = new Login("jd_1", "Password1!", "+271234567890");
        login.register("jd_1", "Password1!", "+271234567890");
        String message = login.getLoginMessage("jd_1", "Password1!");
        assertEquals("Welcome John Doe, it's great to see you again!", message);
    }

    @Test
    public void testGetLoginMessageFailure() {
        Login login = new Login("jd_1", "Password1!", "+271234567890");
        login.register("jd_1", "Password1!", "+271234567890");
        String message = login.getLoginMessage("jd_1", "WrongPass");
        assertEquals("Incorrect username or password. Please try again.", message);
    }
}