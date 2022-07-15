package main.model.data.credential;

import java.util.LinkedList;

/**
 * List of credentials that can be used
 * @param <T>
 */
public class Credentials<T extends Credential> {
    private LinkedList<T> list;

    public Credentials() {
        list = new LinkedList<T>();
    }

    public LinkedList<T> getList() { return list; }


    /**
     * Adds a credential to the list of credentials
     * @param credential a credential object
     */
    public void addCredential(T credential) { list.add(credential); }



    public String toString() {
        return String.format("List of credentials: %s", list.toString());
    }
}
