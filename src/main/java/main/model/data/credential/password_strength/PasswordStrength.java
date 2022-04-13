package main.model.data.credential.password_strength;

public class PasswordStrength {
    /**
     * password strengths array.
     */
    public static final String[] STRENGTHS = {"Very Weak", "Weak", "Strong", "Very Strong"};
    public static final int MIN_LENGTH = 8;

    /**
     * Gets password strength in an integer form.
     * <li>Password length > 8</li>
     * <li>Password contains one of the special characters: "`~!@#$%^&*()_+-=,./<>?;':"[]{}\|"</li>
     * <li>Password contains a number</li>
     * <li>Password contains uppercase and lowercase letters</li>
     * @param password the password
     * @return integer from 0 to 4 representing the password strength
     */
    public static int getPasswordStrength(String password) {
        int strength = 0;
        // Test 1
        if(password.length() > MIN_LENGTH) strength++;
        // Test 2
        if(containsUpperCaseChar(password) && containsLowerCaseChar(password)) strength++;
        // Test 3
        if(containsNumber(password)) strength++;
        // Test 4
        if(containsSpecialChar(password)) strength++;
        return strength;
    }

    /**
     * Gets password strength in a string. The password strength is determined by three categories:
     * <li>Password length > 8</li>
     * <li>Password contains one of the special characters: "`~!@#$%^&*()_+-=,./<>?;':"[]{}\|"</li>
     * <li>Password contains a number</li>
     * <li>Password contains uppercase and lowercase letters</li>
     * @param password the password
     * @return a string representing the password strength. Ranges from "Very Weak" to "Very Strong"
     */
    public static String getStringifiedPasswordStrength(String password) {
        return STRENGTHS[Math.min(getPasswordStrength(password), STRENGTHS.length)];
    }



    private static boolean containsUpperCaseChar(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isUpperCase(string.charAt(i))) return true;
        }
        return false;
    }
    private static boolean containsLowerCaseChar(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isLowerCase(string.charAt(i))) return true;
        }
        return false;
    }
    private static boolean containsNumber(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isDigit(string.charAt(i))) return true;
        }
        return false;
    }
    private static boolean containsSpecialChar(String string) {
        String specialCharacters = "`~!@#$%^&*()_+-=,./<>?;':\"[]{}\\|";
        for(String character : specialCharacters.split("")) {
            if(string.contains(character)) return true;
        }
        return false;
    }
}
