package main.model.data.credential.security_questions;

public class SecurityQuestion {
    private String question;
    private String answer;
    public static final int MIN_LENGTH = 5;

    /**
     * Constructs a SecurityQuestion object.
     * @param question the question. Must be at least 6 characters long.
     * @param answer the answer. Must be at least 6 characters long.
     * @throws SecurityQuestionInvalidException if the question or answer is null or if length is below 6
     */
    public SecurityQuestion(String question, String answer) throws SecurityQuestionInvalidException {
        setSecurityQuestion(question, answer);
    }

    private void setField(String fieldName, String field, String newValue) throws SecurityQuestionInvalidException {
        if(newValue == null) {
            throw new SecurityQuestionInvalidException(fieldName + " cannot be null.", fieldName, newValue);
        }
        if(newValue.length() < MIN_LENGTH) {
            throw new SecurityQuestionInvalidException(
                    String.format("%s must be at least %d characters long.", fieldName, MIN_LENGTH+1), fieldName, newValue);
        }
        field = newValue;
    }

    /**
     * Updates the security question
     * @param question the question. must be at least 6 characters long
     * @param answer the answer. must be at least 6 characters long
     * @throws SecurityQuestionInvalidException if the question or answer is null or if length is below 6
     */
    public void setSecurityQuestion(String question, String answer) throws SecurityQuestionInvalidException{
        setField("Question", this.question, question);
        setField("Answer", this.answer, answer);
    }

    public boolean equals(SecurityQuestion securityQuestion) {
        if(securityQuestion == null) return false;
        return question.equals(securityQuestion.question) && answer.equals(securityQuestion.answer);
    }
    public String toString() {
        return String.format("Question: \"%s\". Answer: \"%s\"", question, answer);
    }
}
