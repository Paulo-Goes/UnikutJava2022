package InterfaceGrafica;

import java.util.Scanner;
import Logica.*;

public class Logado {
    public static void main(Conta loggedAccount) {

        Scanner input = new Scanner(System.in);
        char menuInput;

        // Intarface de opções
        do {
            // Exibe opções para usuarios logados
            menuUI();
            menuInput = input.next().charAt(0);
            input.nextLine();

            switch (menuInput) {
                // Edição de perifl
                case '1':
                    Addons.delay(2);
                    ProfileSettings.main(loggedAccount);
                    break;
                default:
                    System.out.println("Oops, essa oção ainda não existe");
                    Addons.delay(2);
                    break;
            }
        } while (menuInput != '0');

    }

    static void menuUI() {
        System.out.println("\n< > unikut.com/Home/\n");
        System.out.println("Home");
        System.out.println("1 - Edição de perfil");
        System.out.println("2 - Adicionar amigos");
        System.out.println("3 - Depoimentos");
        System.out.println("0 - Sair");
    }
}
