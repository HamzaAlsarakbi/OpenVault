package main.model.data.credential.login;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;

public class Login extends Credential {
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
        for(int i = 0; i < loginCredential.length; i++) {
            if(loginCredential[i] != null) {
                loginCredential[i] = loginCredential[i].trim();
                // If credential is below min length
                if(loginCredential[i].length() < MIN_LENGTH) {
                    throw new CredentialInvalidException(String.format("%s must be at least at least %d characters long. \"%s\" provided.",
                            credentialColumns[i], MIN_LENGTH, loginCredential[i]));
                }
                // Add credential.
                this.loginCredential[i] = loginCredential[i];
            }
        }
    }



}
