package main.model.data.credential.password_protected.wifi;

import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.password_protected.PasswordProtected;
import main.model.data.credential.password_protected.password_strength.PasswordStrength;

public class WiFi extends PasswordProtected {

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

    public boolean equals(WiFi wifi) {
        if(wifi == null) return false;
        return toString().equals(wifi.toString());
    }

    public String toString() {
        return String.format("WiFi credential. Name: \"%s\". Password: \"%s\". Created: %s",
                name, password, getCreationDate().toString());
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
