package View;

import java.util.Scanner;
import java.util.Locale;
import Controller.Addons;
import Controller.SocialNetwork;
import Model.User;
import java.util.InputMismatchException;
import Exceptions.*;

public class Home {
    public static void main(User loggedAccount) throws Exception {
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
                    profileSettings(loggedAccount);
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
                    try{
                        Main.unikut.showFrieds(loggedAccount);
                    }catch(final ZeroFriends e){
                        System.out.println("You don't have any friends :c");
                    }
                    Addons.delay(2);
                    break;
                case '5': // Exibir amigos Pendentes
                    try{
                        Main.unikut.showFriendsRequests(loggedAccount);
                        System.out.println("Para aceitar, envie solicitação de volta para o login");
                    }catch(final EmptyInbox e){
                        System.out.println("You don't have any friends requests");
                    }
                    Addons.delay(2);
                    break;
                case '6': // Exibir Menssagens
                try{
                    unikut.showMessages(loggedAccount);
                }catch(final EmptyInbox e){
                    System.out.println("Não hà novos depoimentos");
                }
                    Addons.delay(2);
                    break;
                default:
                    break;
                }
        } while (menuInput != '0');

    }

    // Exibir opções para usuario logado
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

    // Adicionar amigo
    static void addFriendsUI(SocialNetwork unikut, User loggedAccount) throws Exception {
        Scanner in = new Scanner(System.in);
        String friendLogin;

        System.out.println("Adicionar amigos\nInsira o login do usuario");
        friendLogin = in.next();
        in.nextLine();
        
        try{
            unikut.sendFriendRequest(loggedAccount, friendLogin);
            System.out.println("Solicitação enviada com sucesso!");
        }catch(final AlreadyFriends af){
            System.out.println("Vocês já são amigos");
        }catch(final AlreadySend as){
            System.out.println("A solicitação já foi enviada");
        }catch(final NotSolicitaion ns){
            System.out.println("Solicitação aceita");
        }catch(final UserDoNotExist udne){
            System.out.println("Usuario não encontrado");
        }
        
        Addons.delay(2);
        System.out.println("\nRetornando a Home");
        Addons.delay(1);

    }

    // Envio de menssagem
    static void sendMessageUI(SocialNetwork unikut, User loggedAccount) throws Exception {
        Scanner input = new Scanner(System.in);
        String message, loginRecpetor;

        System.out.println("Insira o login do destinatario");
        loginRecpetor = input.next();

        System.out.println("Digite a menssagem abaixo: ");
        message = input.nextLine(); message = input.nextLine();
        try{
            unikut.sendMessage(message, loggedAccount, loginRecpetor);
        }catch(final UserDoNotExist e){
            System.out.println("User dosn't Exist");
        }
    }

    // Edição de perfil
    public static void profileSettings(User editingAccount) throws Exception {
        Scanner in = new Scanner(System.in);
        char op;
            // Interface de opções
        do {
            optionsUI(editingAccount); // Exibe opções de edição de perfil
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
    
    // Exibir opções de edição
    static void optionsUI(User loggedAccount) { 
        System.out.println("\n< > unikut.com/" + loggedAccount.getLogin() + "/edit");
        System.out.println();
        System.out.println("Edição de perfil");
        System.out.println("1 - Alterar nome de exibição");
        System.out.println("2 - Alterar senha");
        System.out.println("0 - Retornar à home");
    }
    
    // Interface de mudança de nome no unikut
    static void changeNameUI(User loggedAccount) { 
        try (Scanner in = new Scanner(System.in)) {
            String newName;
            int op;
            System.out.println("\nMudar nome de exibição \n Insira seu novo nome de exibição");
            newName = in.nextLine();
            System.out.println("Seu nome de exibição atual é: " + loggedAccount.getNome()
                    + "\n\nSeu novo nome de exibição será: " + newName);
            Addons.delay(3);
            System.out.println("1 - Confirmar mudança\n2 - Descatar mudança");
            
            //Tratamento de um possivel exception
            try {
                op = in.nextInt();
                if (op == 1) { // Condicionais para confirmar a alteração de nome
                    loggedAccount.setNome(newName);
                    System.out.println("Mudança efetuada, " + loggedAccount.getNome() + " :)");
                    Addons.delay(1);
                } else if (op == 2){
                    System.out.println("Nome de exibição mantido.");
                    Addons.delay(1);
                }
                else {
                    System.out.println("Opção invalida, digite uma opção válida.");
                }
                //Tratamento de um possivel exception
            } catch (InputMismatchException e){
                System.err.println("Opção inválida. Digite 1 ou 2 para validar o processo, retornando para o menu anterior.");
            }
        }
    }
    
    // Interface de mudança de senha
    static void changePasswordUI(User loggedAccount) throws Exception { 
        Scanner in = new Scanner(System.in);
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
            //Tratamento de um possivel exception
            try {
                op = in.nextInt();
                if (op == 1) {
                    try{
                        Main.unikut.changePassword(loggedAccount, newPassword); // Metodo que muda a senha na classe contas
                    }catch(final WeakPassword e){
                        System.out.println("your password must contain: \nMore than 6 characters\nAt least one Symbol\nAt least one number\nUpper and Lower cases characters");
                    }
                    
                    System.out.println("Senha alterada com sucesso :)");
                } else if (op == 2){
                    System.out.println("A mudança foi descartadas Mr. " + loggedAccount.getNome() + " :)");
                }
                else if (op == 0){
                    System.out.println("Retornando ao menu anterior.");
                }else {
                    System.out.println("Opção invalida, digite uma opção válida.");
                }
                //Tratamento de um possivel exception
            }catch (InputMismatchException e){
                System.err.println("Opção inválida. Digite 1 ou 2 para validar o processo, retornando para o menu anterior.");
            }
        Addons.delay(2);
    }
}
