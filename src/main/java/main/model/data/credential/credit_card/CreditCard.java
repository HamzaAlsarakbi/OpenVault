package main.model.data.credential.credit_card;

import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;

public class CreditCard extends Credential {
    private String number, name, nickName;
    private int expiryMonth;
    private int expiryYear;
    private int securityCode;
    public static final int MIN_LENGTH = 3;

    /**
     * Constructs a CreditCard object.
     * @param number the number on the credit card. Must be a numeric string and of length 16
     * @param expiryMonth expiry month of the card. Must be between 1 and 12 inclusive
     * @param expiryYear expiry day of the card. Must be between 1 and 31
     * @param name name on the card
     * @param securityCode security code on the back of the card
     * @param nickName nickname for the card
     * @throws CredentialInvalidException if the credit card details are not valid
     */
    public CreditCard(String number, int expiryMonth, int expiryYear, String name, int securityCode, String nickName)throws CredentialInvalidException {
        super();
        setCreditCardDetails(number, expiryMonth, expiryYear, name, securityCode, nickName);
    }

    // Getters
    public String getNumber() { return number; }
    public int getExpiryMonth() { return expiryMonth; }
    public int getExpiryYear() { return expiryYear; }
    public String getName() { return name; }
    public int getSecurityCode() { return securityCode; }


    private void setNumber(String number) throws CredentialInvalidException {
        if(number == null) throw new CredentialInvalidException("Number cannot be a null value");
        number = number.trim();
        // Check if the number is numeric
        try {
            Long.parseLong(number);
        } catch(NumberFormatException e) {
            e.printStackTrace();
            throw new CredentialInvalidException("Number contains non-numeric characters.");
        }
        // Check number length
        if(number.length() != 16) throw new CredentialInvalidException("Number must be of length 16.");
        this.number = number;
    }

    private void setExpiryMonth(int expiryMonth) throws CredentialInvalidException {
        if(expiryMonth < 1 || expiryMonth > 12) {
            throw new CredentialInvalidException(
                    String.format("Expiry month must be between 1 and 12 inclusive. Received: %d", expiryMonth));
        }
        this.expiryMonth = expiryMonth;
    }
    private void setExpiryYear(int expiryYear) throws CredentialInvalidException {
        if(expiryYear > 99 || expiryYear < 0) {
            throw new CredentialInvalidException(
                    String.format("Expiry year must be a positive 2 digit integer. Received: %d", expiryYear));
        }
        this.expiryYear = expiryYear;
    }

    private void setSecurityCode(int securityCode) throws CredentialInvalidException {
        if(securityCode < 100 || securityCode > 999) {
            throw new CredentialInvalidException(
                    String.format("Security code is must be between 100 and 999 inclusive. Received: %s", securityCode));
        }
        this.securityCode = securityCode;
    }


    /***
     * Sets the credit card details.
     * @param number new number on the credit card. Must be a numerical string of length 16
     * @param expiryMonth new expiry month on the credit card. Must be between 1 and 12
     * @param expiryYear new expiry year on the credit card. Must be between 00 and 99
     * @param name new name on the credit card. Must be at least 4 characters long
     * @param securityCode new security code on credit card. Must be between 000 and 999
     * @param nickName new nickname on card
     * @throws CredentialInvalidException
     */
    public void setCreditCardDetails(String number, int expiryMonth, int expiryYear, String name, int securityCode, String nickName) throws CredentialInvalidException {
        setNumber(number);
        setExpiryMonth(expiryMonth);
        setExpiryYear(expiryYear);
        checkString("Name", name, MIN_LENGTH);
        this.name = name;
        checkString("Nickname", nickName, MIN_LENGTH);
        this.nickName = nickName;
        setSecurityCode(securityCode);
    }


    public String toString() {
        return String.format("Credit Card. Number: %s. Expiry date: %d/%d. Name: \"%s\". Security code: %d. Nickname: \"%s\""
                , number, expiryMonth, expiryYear, name, securityCode, nickName);
    }
}
