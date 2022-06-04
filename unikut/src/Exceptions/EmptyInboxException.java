package Exceptions;

public class EmptyInboxException extends Exception{
    public EmptyInboxException(){
        System.out.println("Não há solicitações");
    }
}
