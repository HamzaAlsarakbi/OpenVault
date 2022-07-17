package main.model.data.credential;

import main.model.data.log.LogEntry;
import main.model.data.log.LogTitle;

import java.util.ArrayList;
import java.util.Date;

/**
 * Basic building block for all the credentials (Logins, PINs, Authentication Codes, etc.)
 */
public abstract class Credential {
    private ArrayList<LogEntry> changeLog;
    private Date creationDate;
    private String notes;
    public static final int MIN_LENGTH = 2;
    private boolean favourite;

    public Credential() {
        changeLog = new ArrayList<>();
        creationDate = new Date();
        try {
            changeLog.add(new LogEntry(LogTitle.CREATED, "You created this entry."));
        } catch (Exception e) {
            e.printStackTrace();
        }
        notes = "";
        favourite = false;
    }

    /**
     * Adds an event to the log.
     * @param title title of the change (CREATED, EDITED, ADDED_TO_FAV, REMOVED_FROM_FAV, DELETED)
     * @param description a brief description of the change
     */
    protected void addToLog(LogTitle title, String description) throws Exception {
        changeLog.add(0, new LogEntry(title, description));
    }
    public ArrayList<LogEntry> getChangeLog() { return changeLog; }
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

    public void toggleFavourite() { setFavourite(!favourite); }
    public void setFavourite(Boolean newFavourite) {
        favourite = newFavourite;
        try {
            if(favourite) {
                    addToLog(LogTitle.ADDED_TO_FAV, "You added this entry to your favourites.");
            } else {
                    addToLog(LogTitle.REMOVED_FROM_FAV, "You removed this entry from your favourites.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean getFavourite() { return favourite; }

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
