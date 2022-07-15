package main.model.data.credential;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Date;

/**
 * Basic building block for all the credentials (Logins, PINs, Authentication Codes, etc.)
 */
public abstract class Credential {
    private ArrayList<Pair<Date, String>> changeLog;
    private Date creationDate;
    private String notes;
    public static final int MIN_LENGTH = 2;

    public Credential() {
        changeLog = new ArrayList<Pair<Date, String>>();
        creationDate = new Date();
        changeLog.add(new Pair<Date, String>(new Date(), "Credential created"));
        notes = "";
    }

    /**
     * Adds an event to the log.
     * @param event event message
     */
    protected void addToLog(String event) {
        if(event == null) return;
        if(event.equals("")) return;
        changeLog.add(new Pair<Date, String>(new Date(), event));
    }
    public ArrayList<Pair<Date, String>> getChangeLog() { return changeLog; }
    public Date getCreationDate() { return creationDate; }

    public void setNotes(String notes) throws CredentialInvalidException {
        if(notes == null) throw new CredentialInvalidException("Notes cannot be null.");
        this.notes = notes;
    }
    public String getNotes() { return notes; }
    public abstract String toString();
    public abstract ArrayList<String> getData();

    /**
     * Checks string if it is valid.
     * @param type type of string (Key, Service, Type, Name, etc.)
     * @param string string to be checked
     * @param minLength minimum length of string to be checked
     * @throws CredentialInvalidException if the string is invalid.
     */
    protected void checkString(String type, String string, int minLength) throws CredentialInvalidException {
        if(string == null) {
            throw new CredentialInvalidException(type + " cannot be null.");
        }
        if(string.length() < minLength) {
            throw new CredentialInvalidException(
                    String.format("%s is too short. Must be at least %d characters long", type, minLength));
        }
    }

    /**
     * Checks string if it is valid.
     * @param type type of string (Key, Service, Type, Name, etc.)
     * @param string string to be checked
     * @throws CredentialInvalidException if the string is invalid.
     */
    protected void checkString(String type, String string) throws CredentialInvalidException { checkString(type, string, MIN_LENGTH); }



    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Credential)) return false;
        return toString().equals(obj.toString());
    }
}
