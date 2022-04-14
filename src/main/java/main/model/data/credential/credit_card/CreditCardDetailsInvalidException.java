package main.model.data.credential.credit_card;

public class CreditCardDetailsInvalidException extends Exception {
    public CreditCardDetailsInvalidException(String error) {
        super(error);
    }
}
