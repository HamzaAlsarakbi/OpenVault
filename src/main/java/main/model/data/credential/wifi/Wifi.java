package main.model.data.credential.wifi;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;

public class Wifi extends Credential {

    private static final int MIN_LENGTH = 3;
    private String name;
    private String password;
    private String[] wifiCredential;
    private final String[] credentialType = { "Access Point name", "Password" };

    public Wifi(String name, String password) throws CredentialInvalidException {
        this(new String[]{ name, password });
    }

    public Wifi(String[] credential) throws CredentialInvalidException {
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
    }



}
