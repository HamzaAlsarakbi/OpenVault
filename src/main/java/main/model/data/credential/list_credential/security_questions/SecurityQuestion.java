package main.model.data.credential.list_credential.security_questions;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;

import java.util.ArrayList;
import java.util.Arrays;

public class SecurityQuestion extends Credential {
    private String question;
    private String answer;
    public static final int MIN_LENGTH = 5;

    /**
     * Constructs a SecurityQuestion object.
     * @param question the question. Must be at least 6 characters long.
     * @param answer the answer. Must be at least 6 characters long.
     * @throws CredentialInvalidException if the question or answer is null or if length is below 6
     */
    public SecurityQuestion(String question, String answer) throws CredentialInvalidException {
        super();
        setSecurityQuestion(question, answer);
    }

    /**
     * Updates the security question
     * @param question the question. must be at least 6 characters long
     * @param answer the answer. must be at least 6 characters long
     * @throws CredentialInvalidException if the question or answer is null or if length is below 6
     */
    public void setSecurityQuestion(String question, String answer) throws CredentialInvalidException {
        checkString(question, "Question", MIN_LENGTH);
        this.question = question.trim();
        checkString(answer, "Answer", MIN_LENGTH);
        this.answer = answer.trim();
    }

    public String toString() {
        return String.format("Question: \"%s\". Answer: \"%s\"", question, answer);
    }

    @Override
    public ArrayList<String> getData() {
        return new ArrayList<String>(Arrays.asList(question, answer));
    }
}
