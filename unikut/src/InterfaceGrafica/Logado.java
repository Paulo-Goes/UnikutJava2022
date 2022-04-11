package InterfaceGrafica;

import java.util.Locale;
import java.util.Scanner;
import Logica.Contas;

public class Logado {
    public static void main (Contas contas) {

        Scanner input = new Scanner(System.in);

        char menuInput;

        System.out.println("/Interface quando logado/");
        // Menu de ações iniciais
        do {
            menuUI();
            menuInput = input.next().charAt(0);
            input.nextLine();

            if (menuInput == '2') {
                if (contas.checkLoginDisponibility(String login) == false) {
                    //Lógica adicionar amigos
                }
                else {

                }
            }
            // Exibição caso a opção não esteja no menu
            System.out.println("Ocorreu um erro: Opção invalida");
        } while (menuInput != '0');
        // Finaliza scanner input
        input.close();
    }

    static void menuUI() {
        System.out.println("| UNIKUT SOCIAL MEDIA © | ");
        System.out.println("1 - Edição de perfil");
        System.out.println("2 - Adicionar amigos");
        System.out.println("3 - Depoimentos");
        System.out.println("0 - Sair");
    }
}
