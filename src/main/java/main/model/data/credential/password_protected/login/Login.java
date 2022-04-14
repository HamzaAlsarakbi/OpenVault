package main.model.data.credential.password_protected.login;

import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.password_protected.PasswordProtected;
import main.model.data.credential.password_protected.password_strength.PasswordStrength;

public class Login extends PasswordProtected {
    private String type, service, alias, password;
    private String[] loginCredential;
    private static final String[] credentialColumns = {"Type", "Service", "Email/Username", "Password" };
    public static final int MIN_LENGTH = 3;

    /**
     * Constructs a Credential object. All inputs are trimed.
     * @param type the type of credential (Personal, Work, School, etc.)
     * @param service (Google, Microsoft, Atlassian, etc.)
     * @param alias (Username/email)
     * @param password the password
     * @throws CredentialInvalidException if an argument is below minimum length (3)
     */
    public Login(String type, String service, String alias, String password) throws CredentialInvalidException {
        this(new String[]{type, service, alias, password});
    }

    /***
     * Constructs a Credential object. All inputs are trimmed.
     * @param credential Array of credential columns {type, service, email/username, password }
     * @throws CredentialInvalidException if an element in credential array is below minimum length (3)
     */
    public Login(String[] credential) throws CredentialInvalidException {
        super();
        credential = new String[]{ this.type, this.service, this.alias, this.password };
        setLoginCredential(credential);
    }

    // Getters
    public String getType() { return type; }
    public String getService() { return service; }
    public String getAlias() { return alias; }
    public String getPassword() { return password; }
    public String[] getLoginCredential() { return loginCredential; }

    // Setters
    public void setLoginCredential(String[] loginCredential) throws CredentialInvalidException {
        // Loop through Type, Service, Email/Username and Password
        for(int i = 0; i < loginCredential.length; i++) {
            if(loginCredential[i] == null) throw new CredentialInvalidException(String.format("%s is null. Expected: String.", credentialColumns[i]));
            loginCredential[i] = loginCredential[i].trim();
            // If credential is below min length
            if(loginCredential[i].length() < MIN_LENGTH) {
                throw new CredentialInvalidException(String.format("%s must be at least at least %d characters long. \"%s\" provided.",
                        credentialColumns[i], MIN_LENGTH, loginCredential[i]));
            }

            // Add credential.
            this.loginCredential[i] = loginCredential[i];
        }
        addToLog("Updated login details.");
    }

    public boolean equals(Login login) {
        if(login == null) return false;
        return toString().equals(login.toString());
    }

    public String toString() {
        return String.format(
                "Login Credential. Type: \"%s\". Service: \"%s\". Email/Username: \"%s\". Password: \"%s\". Created: %s",
                type, service, alias, password, getCreationDate().toString());
    }


    @Override
    public int getPasswordStrength() {
        return PasswordStrength.getPasswordStrength(password);
    }

    @Override
    public String getStringifiedPasswordStrength() {
        return PasswordStrength.getStringifiedPasswordStrength(password);
    }
}
