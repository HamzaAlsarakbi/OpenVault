package main.model.data.log;

import java.util.Date;

public class LogEntry {
    private LogTitle title;



    private String description;
    private Date date;


    /**
     * Constructs a log entry.
     * @param title the title of the log entry
     * @param description a brief description of the log entry.
     */
    public LogEntry(LogTitle title, String description) throws Exception {
        if(description == null) throw new Exception("Description is null.");
        if(description.equals("")) throw new Exception("Description is empty.");
        this.title = title;
        this.description = description;
        this.date = new Date();
    }

    // Getters
    public String getTitle() { return title.toString(); }
    public String getDescription() { return description; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return String.format("A log entry created on %s. Title: \"%s\". Description: \"%s\"",
                getDate(), title.toString(), description);
    }

}
