package main.model.data.credential.identification.login;


import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.identification.Identification;
import main.lib.password_strength.PasswordStrength;

import java.util.ArrayList;
import java.util.Arrays;

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
        this(new String[] {type, service, alias, password });
        System.out.println(type + " " + service +  " " + alias + " " + password);
    }

    /***
     * Constructs a Credential object. All inputs are trimmed.
     * @param credential Array of credential columns {type, service, email/username, password }
     * @throws CredentialInvalidException if an element in credential array is below minimum length (3)
     */
    public Login(String[] credential) throws CredentialInvalidException {
        super();
        this.loginCredential = new String[4];
        setLoginCredential(credential);
    }

    // Getters
    public String getType() { return loginCredential[0]; }
    public String getService() { return loginCredential[1]; }
    public String getAlias() { return loginCredential[2]; }
    public String getPassword() { return loginCredential[3]; }
    public String[] getLoginCredential() { return loginCredential; }

    // Setters
    public void setLoginCredential(String[] loginCredential) throws CredentialInvalidException {
        // Loop through Type, Service, Email/Username and Password
        for(int i = 0; i < loginCredential.length; i++) {
            checkString(credentialColumns[i], loginCredential[i]);
            this.loginCredential[i] = loginCredential[i].trim();
        }
        addToLog("Updated login details.");
    }


    public String toString() {
        return String.format(
                "Login Credential. Type: \"%s\". Service: \"%s\". Email/Username: \"%s\". Password: \"%s\". Created: %s",
                getType(), getService(), getAlias(), getPassword(), getCreationDate().toString());
    }

    /**
     * Returns all the data the Login class holds.
     * @return all the data Login class holds in an ArrayList
     */
    @Override
    public ArrayList<String> getData() {

        System.out.println(this);
        return new ArrayList<>(Arrays.asList(loginCredential));
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
