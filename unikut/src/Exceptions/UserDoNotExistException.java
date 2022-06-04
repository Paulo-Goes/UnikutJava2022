package Exceptions;

public class UserDoNotExistException extends Exception{

    public UserDoNotExistException() {
        System.out.println("Usuario não encontrado");
    }
    
}
