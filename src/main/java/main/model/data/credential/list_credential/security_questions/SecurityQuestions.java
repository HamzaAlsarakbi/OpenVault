package main.model.data.credential.list_credential.security_questions;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.list_credential.ListCredential;

import java.util.LinkedList;

public class SecurityQuestions extends ListCredential {
    private LinkedList<SecurityQuestion> questions;


    /**
     * Constructs a SecurityQuestions object.
     * @param service service that asks for the security questions (Bank, PayPal, etc.)
     * @throws CredentialInvalidException if the service is invalid.
     */
    public SecurityQuestions(String service) throws CredentialInvalidException {
        super(service);
        questions = new LinkedList<SecurityQuestion>();
    }


    /**
     * Adds a security question object to the list of security questions
     * @param question question to be added
     * @param answer answer to be added
     * @throws CredentialInvalidException if question or answer is an invalid string.
     */
    public void addSecurityQuestion(String question, String answer) throws CredentialInvalidException {
        questions.add(new SecurityQuestion(question, answer));
    }
    public LinkedList<SecurityQuestion> getSecurityQuestions() { return questions; }

    /**
     * Deletes all security questions.
     */
    public void clearSecurityQuestions() { questions = new LinkedList<SecurityQuestion>(); }

    public String toString() {
        return String.format("Security questions. Service: \"%s\". Security questions: %s", service, questions);
    }
}
