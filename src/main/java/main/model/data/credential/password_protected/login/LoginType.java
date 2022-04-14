package main.model.data.credential.password_protected.login;

import java.util.ArrayList;
import java.util.TreeSet;

public class LoginType {
    /**
     * Get credential types in a sorted ArrayList
     * @return sorted ArrayList of credential types.
     */
    public static ArrayList<String> getCredentialTypes() {
        TreeSet<String> list = new TreeSet<String>();
        list.add("Personal");
        list.add("Work");
        list.add("School");

        return new ArrayList<String>(list);
    }

    /**
     * Adds Credentials to a local save file
     * @return true if adding and saving successful
     */
    public static void addCredential(String credentialType) throws LoginTypeAlreadyExistsException, LoginlTypeFormatException {
        int minLength = 3;
        if(credentialType.length() < minLength) {
            throw new LoginlTypeFormatException(String.format("Credential Type is too short. Must be at least %d characters long.", minLength));
        }
        ArrayList<String> credentialTypes = getCredentialTypes();
        if(credentialTypes.contains(credentialType)) {
            throw new LoginTypeAlreadyExistsException("Credential Type already exists.");
        }
    }
}
