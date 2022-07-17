package main.model.data.credential.note;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.log.LogTitle;

import java.util.ArrayList;

public class Note extends Credential {
    private String title;
    private String body;

    /**
     * Constructs a Note object
     * @param title title of the note
     * @param body body of the note
     * @throws CredentialInvalidException if the title or body are invalid
     */
    public Note(String title, String body) throws CredentialInvalidException {
        super();
        setNote(title, body);
    }

    /**
     * Sets the title and body of the note object.
     * @param title new title of the note
     * @param body new body of the note
     * @throws CredentialInvalidException if the title or body are invalid
     */
    public void setNote(String title, String body) throws CredentialInvalidException {
        checkString(title, "Title");
        this.title = title.trim();
        checkString(body, "Body", 0);
        this.body = body.trim();

        try {
            addToLog(LogTitle.EDITED, "You edited this note.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Getters
    public String getTitle() { return title; }
    public String getBody() { return body; }

    public String toString() {
        return String.format("Note. Title: \"%s\". Body: \"%s\"", title, body);
    }

    @Override
    public ArrayList<String> getData() {
        return null;
    }

}
