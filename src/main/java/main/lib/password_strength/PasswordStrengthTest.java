package main.lib.password_strength;
import org.junit.jupiter.api.Assertions;

class PasswordStrengthTest {
    @org.junit.jupiter.api.Test
    void getPasswordStrength() {
        Assertions.assertEquals(0, PasswordStrength.getPasswordStrength("password"));
        Assertions.assertEquals(1, PasswordStrength.getPasswordStrength("Password"));
        Assertions.assertEquals(2, PasswordStrength.getPasswordStrength("Passwords"));
        Assertions.assertEquals(3, PasswordStrength.getPasswordStrength("Passwords123"));
    }
}