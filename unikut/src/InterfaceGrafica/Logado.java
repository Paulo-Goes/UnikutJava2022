package InterfaceGrafica;

import java.util.Scanner;
import Logica.*;

public class Logado {
    public static void main (Conta loggedAccount) {

        Scanner input = new Scanner(System.in);

        char menuInput;

        
        // Menu de ações iniciais
        do {
            menuUI();
            menuInput = input.next().charAt(0);
            input.nextLine();

            switch(menuInput) {
                case '1':
                ProfileSettings.main(loggedAccount);
            }
            
        } while (menuInput != '0');
        // Finaliza scanner input
    
    }

    static void menuUI() {
        System.out.println("< > unikut.com/Home/");
        System.out.println();
        System.out.println();
        System.out.println("Home");
        System.out.println("1 - Edição de perfil");
        System.out.println("2 - Adicionar amigos");
        System.out.println("3 - Depoimentos");
        System.out.println("0 - Sair");
    }
}
