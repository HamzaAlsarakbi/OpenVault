package main.model.data.credential.wifi;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;
import main.lib.password_strength.PasswordStrength;

import java.util.ArrayList;
import java.util.Arrays;

public class WiFi extends Credential implements main.model.data.credential.PasswordStrength {

    private static final int MIN_LENGTH = 3;
    private String name;
    private String password;
    private String[] wifiCredential;
    private final String[] credentialType = { "Access Point name", "Password" };

    public WiFi(String name, String password) throws CredentialInvalidException {
        this(new String[]{ name, password });
    }

    public WiFi(String[] credential) throws CredentialInvalidException {
        super();
        this.wifiCredential = new String[] { name, password };
        setWifiCredential(credential);
    }

    public void setWifiCredential(String[] credential) throws CredentialInvalidException {
        for(int i = 0; i < wifiCredential.length; i++) {
            credential[i] = credential[i].trim();
            // If credential is below min length
            if(credential[i].length() < MIN_LENGTH) {
                throw new CredentialInvalidException(String.format("%s must be at least at least %d characters long. \"%s\" provided.",
                        credential[i], MIN_LENGTH, credential[i]));
            }
            // Add credential.
            this.wifiCredential[i] = credential[i];
        }
        addToLog("Updated wifi details.");
    }


    public String toString() {
        return String.format("WiFi credential. Name: \"%s\". Password: \"%s\". Created: %s",
                name, password, getCreationDate().toString());
    }

    @Override
    public ArrayList<String> getData() {
        return new ArrayList<String>(Arrays.asList(name, password));
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
