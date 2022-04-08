package main.model.data.credential;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Credential {
    private HashMap<Date, String> changeLog;
    private Date creationDate;
    public Credential() {
        changeLog = new HashMap<Date, String>();
        creationDate = new Date();

    }
}
