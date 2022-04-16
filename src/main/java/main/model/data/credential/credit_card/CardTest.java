package main.model.data.credential.credit_card;

import main.model.data.credential.CredentialInvalidException;

public class CardTest {
    public static void main(String[] args) throws CredentialInvalidException {
        CreditCard card = new CreditCard("1234567890123456", 5, 25, "Ham", 105, "Awoga");;
        try {
            card.setCreditCardDetails("1234567890123456", 5, 25, "Ha", 105, "Awoga");
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(card);



    }
}
