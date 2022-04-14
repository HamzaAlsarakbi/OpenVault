package main.model.data.credential;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Date;

public abstract class Credential {
    private ArrayList<Pair<Date, String>> changeLog;
    private Date creationDate;
    private String notes;

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
}
