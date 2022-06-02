package Exceptions;

public class LoginInUseException extends Exception{
    
    public LoginInUseException() {
        System.out.println("\nEste login já está em uso.");
    }
}
