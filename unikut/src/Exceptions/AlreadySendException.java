package Exceptions;

public class AlreadySendException extends Exception{

    public AlreadySendException() {
        System.out.println("A solicitação já foi enviada");
    }
    
}
