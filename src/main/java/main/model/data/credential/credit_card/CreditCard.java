package main.model.data.credential.credit_card;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.password_protected.PasswordStrength;

public class CreditCard extends Credential {
    private String number;
    private int expiryMonth;
    private int expiryYear;
    private String name;
    private int securityCode;
    public static final int MIN_LENGTH = 3;

    /**
     * Constructs a CreditCard object.
     * @param number the number on the credit card. Must be a numeric string and of length 16
     * @param expiryMonth expiry month of the card. Must be between 1 and 12 inclusive
     * @param expiryYear expiry day of the card. Must be between 1 and 31
     * @param name name on the card
     * @param securityCode security code on the back of the card
     * @throws CreditCardDetailsInvalidException if the credit card details are not valid
     */
    public CreditCard(String number, int expiryMonth, int expiryYear, String name, int securityCode)throws CreditCardDetailsInvalidException {
        super();
        setCreditCardDetails(number, expiryMonth, expiryYear, name, securityCode);
    }


    private void setNumber(String number) throws CreditCardDetailsInvalidException {
        if(number == null) throw new CreditCardDetailsInvalidException("Number cannot be a null value");
        number = number.trim();
        // Check if the number is numeric
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new CreditCardDetailsInvalidException("Number contains non-numeric characters.");
        }
        // Check number length
        if(number.length() != 8) throw new CreditCardDetailsInvalidException("Number must be of length 16.");
        this.number = number;
    }

    private void setExpiryMonth(int expiryMonth) throws CreditCardDetailsInvalidException {
        if(expiryMonth < 1 || expiryMonth > 12) {
            throw new CreditCardDetailsInvalidException(
                    String.format("Expiry month must be between 1 and 12 inclusive. Received: %d", expiryMonth));
        }
        this.expiryMonth = expiryMonth;
    }
    private void setExpiryYear(int expiryYear) throws CreditCardDetailsInvalidException {
        if(expiryYear > 99 || expiryYear < 0) {
            throw new CreditCardDetailsInvalidException(
                    String.format("Expiry year must be a positive 2 digit integer. Received: %d", expiryYear));
        }
        this.expiryMonth = expiryYear;
    }
    private void setName(String name) throws CreditCardDetailsInvalidException {
        if(name == null) {
            throw new CreditCardDetailsInvalidException("Name cannot be null.");
        }
        if(name.length() > MIN_LENGTH) {
            throw new CreditCardDetailsInvalidException(
                    String.format("Name is too short. Must be at least %d characters long", MIN_LENGTH+1));
        }
    }
    private void setSecurityCode(int securityCode) throws CreditCardDetailsInvalidException {
        if(securityCode < 100 || securityCode > 999) {
            throw new CreditCardDetailsInvalidException(
                    String.format("Security code is must be between 100 and 999 inclusive. Received: %s", securityCode));
        }
        this.securityCode = securityCode;
    }




    public void setCreditCardDetails(String number, int expiryMonth, int expiryYear, String name, int securityCode) throws CreditCardDetailsInvalidException {
        setNumber(number);
        setExpiryMonth(expiryMonth);
        setExpiryYear(expiryYear);
        setName(name);
        setSecurityCode(securityCode);
    }




    // Getters
    public String getNumber() { return number; }
    public int getExpiryMonth() { return expiryMonth; }
    public int getExpiryYear() { return expiryYear; }
    public String getName() { return name; }
    public int getSecurityCode() { return securityCode; }
}
