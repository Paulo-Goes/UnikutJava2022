package View;

import java.util.Scanner;
import java.util.Locale;
import Controller.Addons;
import Controller.SocialNetwork;
import Controller.Exceptions.*;
import Model.User;

public class Home {

    static Scanner in = new Scanner(System.in);

    public static void main(User loggedAccount) throws Exception {
        char menuInput;

        // Intarface de opções
        do {
            // Exibe opções para usuarios logados
            Menus.loggedUI();
            menuInput = in.next().charAt(0);
            in.nextLine();

            switch (menuInput) {
                case '1': // Edição de perfil
                    Addons.delay(1);
                    profileSettings(loggedAccount);
                    break;
                case '2': // Adição de amigos
                    Addons.delay(1);
                    addFriendsUI(loggedAccount);
                    break;
                case '3': // Envio de recados
                    Addons.delay(1);
                    sendMessageUI(loggedAccount);
                    Addons.delay(2);
                    break;
                case '4': // Exibir Amigos
                    try {
                        SocialNetwork.getInstance().showFrieds(loggedAccount);
                    } catch (final ZeroFriends e) {
                        System.out.println("Você não possui amigos");
                    }
                    Addons.delay(2);
                    break;
                case '5': // Exibir amigos Pendentes
                    try {
                        SocialNetwork.getInstance().showFriendsRequests(loggedAccount);
                        System.out.println("Para aceitar, envie solicitação de volta para o login");
                    } catch (final EmptyInbox e) {
                        System.out.println("Não há solicitações");
                    }
                    Addons.delay(2);
                    break;
                case '6': // Exibir Menssagens
                    try {
                        SocialNetwork.getInstance().showMessages(loggedAccount);
                    } catch (final EmptyInbox e) {
                        System.out.println("Não hà novos depoimentos");
                    }
                    Addons.delay(2);
                    break;
                default:
                    break;
            }
        } while (menuInput != '0');

    }

    // Adicionar amigo
    static void addFriendsUI(User loggedAccount) throws Exception {
        String friendLogin;

        System.out.println("Adicionar amigos\nInsira o login do usuario");
        friendLogin = in.next();
        in.nextLine();

        try {
            SocialNetwork.getInstance().sendFriendRequest(loggedAccount, friendLogin);
            System.out.println("Solicitação enviada com sucesso!");
        } catch (final AlreadyFriends af) {
            System.out.println("Vocês já são amigos");
        } catch (final AlreadySend as) {
            System.out.println("A solicitação já foi enviada");
        } catch (final NotSolicitaion ns) {
            System.out.println("Solicitação aceita");
        } catch (final UserDoNotExist udne) {
            System.out.println("Usuario não encontrado");
        }

        Addons.delay(2);
        System.out.println("\nRetornando a Home");
        Addons.delay(1);

    }

    // Envio de menssagem
    static void sendMessageUI(User loggedAccount) throws Exception {
        String message, loginRecpetor;

        System.out.println("Insira o login do destinatario");
        loginRecpetor = in.next();

        System.out.println("Digite a menssagem abaixo: ");
        message = in.nextLine();
        message = in.nextLine();

        try {
            SocialNetwork.getInstance().sendMessage(message, loggedAccount, loginRecpetor);
        } catch (final UserDoNotExist e) {
            System.out.println("Usuario não encontrado");
        }
    }

    // Edição de perfil
    public static void profileSettings(User editingAccount) throws Exception {
        char op;
        // Interface de opções
        do {
            Menus.optionsUI(editingAccount); // Exibe opções de edição de perfil
            op = in.next().toLowerCase(Locale.ROOT).charAt(0);
            in.nextLine();
            switch (op) {
                case '1': // Mudarnça de nome
                    Addons.delay(1);
                    changeNameUI(editingAccount);
                    break;
                case '2': // Mudança de senha
                    Addons.delay(1);
                    changePasswordUI(editingAccount);
                    break;
                default: // Reiniciar menu se a opção não estiver listada
                    System.out.println("Oops, essa opção ainda não existe :/");
                    Addons.delay(1);
                    break;
            }
        } while (op != '0');
    }

    // Interface de mudança de nome no unikut
    static void changeNameUI(User loggedAccount) {
        String newName;

        System.out.println(
                "\n\n< > unikut.com/" + loggedAccount.getLogin() + "/edit/name \nInsira seu novo nome de exibição:");
        newName = in.nextLine();
        newName = in.nextLine();
        Addons.delay(3);
        loggedAccount.setNome(newName); // lidar com exception
    }

    // Interface de mudança de senha
    static void changePasswordUI(User loggedAccount) throws Exception {
        String newPassword;

        System.out.println("\n\n< > unikut.com/" + loggedAccount.getLogin()
                + "/edit/password \nInsira seu novo nome de exibição:");
        newPassword = in.next();

        Addons.delay(3);
        try {
            SocialNetwork.getInstance().changePassword(loggedAccount, newPassword);
        } catch (final WeakPassword e) {
            return;
        }
        System.out.println("Senha alterada com sucesso :)");
        Addons.delay(2);
    }
}
