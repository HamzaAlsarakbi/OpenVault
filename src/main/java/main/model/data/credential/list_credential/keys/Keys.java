package main.model.data.credential.list_credential.keys;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.list_credential.ListCredential;

import java.util.ArrayList;
import java.util.LinkedList;

public class Keys extends ListCredential {
    private LinkedList<Key> keys;

    /**
     * Constructs a Keys object
     * @param service service that hosts the keys (GitHub, Spotify, etc.)
     */
    public Keys(String service) throws CredentialInvalidException {
        super(service);
        keys = new LinkedList<Key>();
    }

    /**
     * Adds a new key to the set of keys
     * @param type the type of key (Public, Private, Developer, etc.)
     * @param key the key
     * @throws CredentialInvalidException if the type or key are invalid strings.
     */
    public void addKey(String type, String key) throws CredentialInvalidException { keys.add(new Key(type, key)); }


    public LinkedList<Key> getKeys() { return keys; }

    @Override
    public String toString() {
        return String.format("Keys. Service: \"%s\". Keys: %s", service, keys);
    }

    @Override
    public ArrayList<String> getData() {
        return null;
    }
}
