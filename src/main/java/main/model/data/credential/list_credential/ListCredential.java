package main.model.data.credential.list_credential;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;

public abstract class ListCredential extends Credential {
    protected String service;

    public ListCredential(String service) throws CredentialInvalidException {
        super();
        setService(service);
    }



    /**
     * updates service if new service is a valid string
     * @param service new service
     * @throws CredentialInvalidException if new service string is invalid.
     */
    public void setService(String service) throws CredentialInvalidException {
        checkString(service, "Service");
        this.service = service;
    }
    public String getService() { return service; }
}
