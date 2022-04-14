package main.model.data.credential.security_questions;

public class SecurityQuestionInvalidException extends Exception {
    private String field;
    private String received;
    public SecurityQuestionInvalidException(String error, String field, String received) {
        super(error);
        this.field = field;
        this.received = received;
    }
}
