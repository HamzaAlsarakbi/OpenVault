package main.model.data.credential.identification.login;


import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.identification.Identification;
import main.lib.password_strength.PasswordStrength;

public class Login extends Identification implements main.model.data.credential.PasswordStrength {
    private String alias, password;
    private String[] loginCredential;
    private static final String[] credentialColumns = {"Type", "Service", "Username/Email", "Password" };

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
        this.loginCredential = new String[]{ this.type, this.service, this.alias, this.password };
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
            System.out.println(credentialColumns[i] + " " + loginCredential[i]);
            checkString(credentialColumns[i], loginCredential[i]);
            this.loginCredential[i] = loginCredential[i].trim();
        }
        addToLog("Updated login details.");
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
