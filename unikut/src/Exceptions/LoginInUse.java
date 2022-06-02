package Exceptions;

public class LoginInUse extends Exception{
    
    public LoginInUse() {
        System.out.println("\nEste login já está em uso.");
    }
}
