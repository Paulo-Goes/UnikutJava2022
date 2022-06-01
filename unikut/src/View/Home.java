package View;

import java.util.Scanner;
import java.util.Locale;
import Controller.Addons;
import Controller.SocialNetwork;
import Controller.Exceptions.*;
import Model.User;
import java.util.InputMismatchException;

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
        int op;
        System.out.println("\nMudar nome de exibição \n Insira seu novo nome de exibição");
        newName = in.nextLine();
        System.out.println("Seu nome de exibição atual é: " + loggedAccount.getNome()
                + "\n\nSeu novo nome de exibição será: " + newName);
        Addons.delay(3);
        System.out.println("1 - Confirmar mudança\n2 - Descatar mudança");

        // Tratamento de um possivel exception
        try {
            op = in.nextInt();
            if (op == 1) { // Condicionais para confirmar a alteração de nome
                loggedAccount.setNome(newName);
                System.out.println("Mudança efetuada, " + loggedAccount.getNome() + " :)");
                Addons.delay(1);
            } else if (op == 2) {
                System.out.println("Nome de exibição mantido.");
                Addons.delay(1);
            } else {
                System.out.println("Opção invalida, digite uma opção válida.");
            }
            // Tratamento de um possivel exception
        } catch (InputMismatchException e) {
            System.err
                    .println("Opção inválida. Digite 1 ou 2 para validar o processo, retornando para o menu anterior.");
        }
    }

    // Interface de mudança de senha
    static void changePasswordUI(User loggedAccount) throws Exception {
        String newPassword, newPasswordCheckout;
        int op;
        do {
            System.out.println("Insira sua nova senha");
            newPassword = in.next();
            in.nextLine();
            System.out.println("Insira sua nova senha novamente");
            newPasswordCheckout = in.next();
            in.nextLine();
        } while (!newPassword.equals(newPasswordCheckout)); // Força a igualdade entre as duas senhas iseridas acinma
        System.out.println("Tem certeza que deseja alterar a senha, " + loggedAccount.getNome() + " ?");
        Addons.delay(3);
        System.out.println("1 - Sim c:\n2 - Não :c");
        // Tratamento de um possivel exception
        try {
            op = in.nextInt();
            if (op == 1) {
                try {
                    SocialNetwork.getInstance().changePassword(loggedAccount, newPassword); // Metodo que muda a senha
                                                                                            // na classe contas
                } catch (final WeakPassword e) {
                    System.out.println(
                            "your password must contain: \nMore than 6 characters\nAt least one Symbol\nAt least one number\nUpper and Lower cases characters");
                    return;
                }
                System.out.println("Senha alterada com sucesso :)");
            } else if (op == 2) {
                System.out.println("A mudança foi descartadas Mr. " + loggedAccount.getNome() + " :)");
            } else if (op == 0) {
                System.out.println("Retornando ao menu anterior.");
            } else {
                System.out.println("Opção invalida, digite uma opção válida.");
            }
            // Tratamento de um possivel exception
        } catch (InputMismatchException e) {
            System.err
                    .println("Opção inválida. Digite 1 ou 2 para validar o processo, retornando para o menu anterior.");
        }
        Addons.delay(2);
    }
}
