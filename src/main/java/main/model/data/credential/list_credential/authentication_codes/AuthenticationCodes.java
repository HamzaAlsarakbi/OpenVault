package main.model.data.credential.list_credential.authentication_codes;

import javafx.util.Pair;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.list_credential.ListCredential;

import java.util.ArrayList;
import java.util.LinkedList;

public class AuthenticationCodes extends ListCredential {

    LinkedList<Pair<String, Boolean>> authenticationCodes;

    /**
     * Constructs AuthenticationCodes object.
     * @param service service that provides authentication codes
     * @throws CredentialInvalidException if the service string is invalid.
     */
    public AuthenticationCodes(String service) throws CredentialInvalidException {
        super(service);
        authenticationCodes = new LinkedList<Pair<String, Boolean>>();
    }

    public void addAuthenticationCode(String code) throws CredentialInvalidException {
        checkString(code, "Code");
        authenticationCodes.add(new Pair<String, Boolean>(code.trim(), false));
    }

    // Getters
    public LinkedList<Pair<String, Boolean>> getAuthenticationCodes() { return authenticationCodes; }
    public Pair<String, Boolean> getCodePair(String code) {
        for(Pair<String, Boolean> codePair : authenticationCodes) {
            if(codePair.getKey().equals(code)) return codePair;
        }
        return null;
    }
    public boolean contains(String code) { return getCodePair(code) != null; }

    /**
     * Toggles the authentication code state (true if used. false if unused)
     * @param code authentication code to have its state updated
     * @throws CredentialInvalidException if teh code string isn't in the list
     */
    public void toggleCode(String code) throws CredentialInvalidException {
        Pair<String, Boolean> codePair = getCodePair(code);
        if(codePair == null) throw new CredentialInvalidException("Code provided isn't in the authentication code list.");

        int index = authenticationCodes.indexOf(codePair);
        authenticationCodes.remove(codePair);
        authenticationCodes.set(index, new Pair<String, Boolean>(code, !codePair.getValue()));
    }

    @Override
    public String toString() {
        return String.format("Authentication Codes. Service: \"%s\". Authentication codes: %s", service, authenticationCodes);
    }

    @Override
    public ArrayList<String> getData() {
        return null;
    }
}
