package main.model.data.credential.security_questions;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;

import java.util.LinkedList;

public class SecurityQuestions extends Credential {
    private LinkedList<SecurityQuestion> questions;
    private String service;


    public SecurityQuestions(String service) throws CredentialInvalidException {
        super();
        setService(service);
        questions = new LinkedList<SecurityQuestion>();
    }

    private void setService(String service) throws CredentialInvalidException {
        if(service == null) throw new CredentialInvalidException("service cannot be null.");
        this.service = service;
    }
    public String getService() { return service; }

    public void addSecurityQuestion(String question, String answer) throws SecurityQuestionInvalidException {
        questions.add(new SecurityQuestion(question, answer));
    }
    public LinkedList<SecurityQuestion> getSecurityQuestions() { return questions; }
    public void clearSecurityQuestions() { questions = new LinkedList<SecurityQuestion>(); }

    public boolean equals(SecurityQuestions securityQuestions) {
        if(securityQuestions == null) return false;
        return service.equals(securityQuestions.getService()) && questions.equals(securityQuestions.getSecurityQuestions());
    }
    public String toString() {
        return String.format("Security questions for: \"%s\"", service);
    }
}
