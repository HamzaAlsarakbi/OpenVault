package main.model.data.credential.identification;

import main.model.data.credential.CredentialInvalidException;

import java.util.ArrayList;
import java.util.TreeSet;

public class IdentificationType {
    /**
     * Get identification types in a sorted ArrayList
     * @return sorted ArrayList of credential types.
     */
    public static ArrayList<String> getIdentificationTypes() {
        TreeSet<String> list = new TreeSet<String>();
        list.add("Personal");
        list.add("Work");
        list.add("School");

        return new ArrayList<String>(list);
    }



    public static void addIdentificationType(String credentialType) throws CredentialInvalidException {
        int minLength = 3;
        if(credentialType.length() < minLength) {
            throw new CredentialInvalidException(String.format("Credential Type is too short. Must be at least %d characters long.", minLength));
        }
        ArrayList<String> credentialTypes = getIdentificationTypes();
        if(credentialTypes.contains(credentialType)) {
            throw new CredentialInvalidException("Credential Type already exists.");
        }
    }
}
