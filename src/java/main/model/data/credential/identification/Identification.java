package main.model.data.credential.identification;


import main.model.data.credential.Credential;

public abstract class Identification extends Credential {
    protected String type, service;
    public Identification() {
        super();
    }

    public String getType() { return type; }
    public String getService() { return service; }
}
