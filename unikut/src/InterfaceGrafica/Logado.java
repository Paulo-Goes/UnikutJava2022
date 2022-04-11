package InterfaceGrafica;

import java.util.Locale;
import java.util.Scanner;
import Logica.Contas;

public class Logado extends Contas {
    public static void main (Contas contas) {

        Scanner input = new Scanner(System.in);

        System.out.println("/Interface quando logado/");


    }

    static void menuUI() {
        System.out.println("| UNIKUT SOCIAL MEDIA © | ");
        System.out.println("1 - Adicionar amigos");
        System.out.println("2 - Depoimentos");
        System.out.println("0 - Sair");
    }
}
