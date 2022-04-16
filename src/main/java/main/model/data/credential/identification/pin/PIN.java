package main.model.data.credential.identification.pin;

import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.identification.Identification;

public class PIN extends Identification {
    private int pin;

    /**
     * Constructs a PIN object.
     * @param type type of pin (Personal, Work, etc.). Must be at least 3 characters long
     * @param service service the pin is used in (Gmail, GitHub, etc.). Must be at least 3 characters long
     * @param pin pin. Must be a positive integer
     * @throws CredentialInvalidException if the type or service are invalid strings, or if the pin is a negative integer.
     */
    public PIN(String type, String service, int pin) throws CredentialInvalidException {
        super();
        setPIN(type, service, pin);
    }

    /**
     * Updates PIN object.
     * @param type type of pin (Personal, Work, etc.). Must be at least 3 characters long
     * @param service service the pin is used in (Gmail, GitHub, etc.). Must be at least 3 characters long
     * @param pin pin. Must be a positive integer
     * @throws CredentialInvalidException if the type or service are invalid strings, or if the pin is a negative integer.
     */
    public void setPIN(String type, String service, int pin) throws CredentialInvalidException {
        checkString(type, "Type");
        this.type = type.trim();

        checkString(service, "Service");
        this.service = service.trim();

        if(pin < 0) throw new CredentialInvalidException("PIN must be a positive integer. Received " + pin);
        this.pin = pin;
        addToLog("Updated PIN.");
    }

    public int getPin() { return pin; }

    @Override
    public String toString() {
        return String.format("PIN. Type: \"%s\". Service: \"%s\". PIN: %d", type, service, pin);
    }
}
