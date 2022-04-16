package main.model.data.credential.list_credential.keys;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;

public class Key extends Credential {
    private String type;
    private String key;

    /**
     * Constructs a Key object
     * @param type key type (public, private, developer)
     * @param key key
     */
    public Key(String type, String key) throws CredentialInvalidException {
        super();
        setKey(type, key);
    }

    public void setKey(String type,String key) throws CredentialInvalidException {
        checkString(type, "Type");
        this.type = type.trim();

        checkString(key, "Key");
        this.key = key.trim();
    }

    @Override
    public String toString() {
        return String.format("Key. Type: \"%s\". Key: \"%s\".", type, key);
    }
}
