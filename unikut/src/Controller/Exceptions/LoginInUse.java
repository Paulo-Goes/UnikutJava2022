package Controller.Exceptions;

public class LoginInUse extends Exception{
    
    public LoginInUse() {
        System.out.println("Este login já está em uso.");
    }
}
