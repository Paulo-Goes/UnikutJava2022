package InterfaceGrafica;

import java.util.Scanner;
import Logica.*;

public class Home {
    public static void main(User loggedAccount) {

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
                case '2':
                Addons.delay(1);
                addFriendsUI(Main.unikut, loggedAccount);
                    break;
                case '3':
                Main.unikut.showFrieds(loggedAccount);
                Addons.delay(2);
                    break;
                case '4':
                Main.unikut.showFriendsRequests(loggedAccount);
                Addons.delay(2);
                break;
                default:
                    System.out.println("Oops, essa opção ainda não existe");
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
        System.out.println("3 - Ver lista de amigos");
        System.out.println("4 - Ver Notificações");
        System.out.println("5 - Depoimentos");
        System.out.println("0 - Sair");
    }

    static void addFriendsUI(SocialNetwork unikut, User loggedAccount) {
        Scanner in = new Scanner(System.in);
        String friendLogin;

        System.out.println("Adicionar amigos\nInsira o login do usuario");
        friendLogin = in.next();
        in.nextLine();

        unikut.sendFriendRequest(loggedAccount, friendLogin);
        Addons.delay(2);
        System.out.println("\nRetornando a Home");
        Addons.delay(1);

    }
}
