package View;

import java.util.Scanner;

import Controller.Addons;
import Controller.SocialNetwork;
import Controller.User;
import Model.ProfileSettings;

public class Home {
    public static void main(User loggedAccount) {
        SocialNetwork unikut = Main.unikut;

        Scanner input = new Scanner(System.in);
        char menuInput;

            // Intarface de opções
        do {
                // Exibe opções para usuarios logados
            menuUI();
            menuInput = input.next().charAt(0);
            input.nextLine();

            switch (menuInput) {
                case '1': // Edição de perfil
                    Addons.delay(1);
                    ProfileSettings.main(loggedAccount);
                    break;
                case '2': // Adição de amigos
                    Addons.delay(1);
                    addFriendsUI(unikut, loggedAccount);
                    break;
                case '3': // Envio de recados
                    Addons.delay(1);
                    sendMessageUI(unikut, loggedAccount);
                    Addons.delay(2);
                    break;
                case '4': // Exibir Amigos
                    Main.unikut.showFrieds(loggedAccount);
                    Addons.delay(2);
                    break;
                case '5': // Exibir amigos Pendentes
                    Main.unikut.showFriendsRequests(loggedAccount);
                    Addons.delay(2);
                    break;
                case '6': // Exibir Menssagens
                    unikut.showMessages(loggedAccount);
                    Addons.delay(2);
                    break;
                default:
                    break;
                }
        } while (menuInput != '0');

    }

    static void menuUI() {
        System.out.println("\n< > unikut.com/Home/\n");
        System.out.println("Home");
        System.out.println("1 - Edição de perfil");
        System.out.println("2 - Adicionar amigos");
        System.out.println("3 - Enviar Depoimento");
        System.out.println("4 - Ver lista de amigos");
        System.out.println("5 - Verificar solicitações de amizade");
        System.out.println("6 - Veriificar caixa de depoimentos");

        System.out.println("0 - Sair");
    }

    static void addFriendsUI(SocialNetwork unikut, User loggedAccount) {
        try (Scanner in = new Scanner(System.in)) {
            String friendLogin;

            System.out.println("Adicionar amigos\nInsira o login do usuario");
            friendLogin = in.next();
            in.nextLine();

            unikut.sendFriendRequest(loggedAccount, friendLogin);
        }
        Addons.delay(2);
        System.out.println("\nRetornando a Home");
        Addons.delay(1);

    }

    static void sendMessageUI(SocialNetwork unikut, User loggedAccount) {
        try (Scanner input = new Scanner(System.in)) {
            String message, loginRecpetor;

            System.out.println("Insira o login do destinatario");
            loginRecpetor = input.next();
            input.nextLine();

            System.out.println("Digite a menssagem abaixo: ");
            message = input.nextLine();

            unikut.sendMessage(message, loggedAccount, loginRecpetor);
        }
    }
}
