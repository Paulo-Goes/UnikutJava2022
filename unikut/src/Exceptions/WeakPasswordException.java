package Exceptions;

public class WeakPasswordException extends Exception{
    
    public WeakPasswordException() {
        System.out.println("\nA senha inseria não é forte o suficiente, uma senha forte deve conter: ");
        System.out.println("* Mais do que 6 caracteres");
        System.out.println("* Letras maiúsculas e minúsculas");
        System.out.println("* Números");
        System.out.println("* Caracteres especiais");
        System.out.println("Insira uma senha forte:");
    }
}
