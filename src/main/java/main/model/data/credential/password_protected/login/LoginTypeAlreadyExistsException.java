package main.model.data.credential.password_protected.login;

public class LoginTypeAlreadyExistsException extends Exception {
    public LoginTypeAlreadyExistsException(String error) { super(error); }
}
