package InterfaceGrafica;

import java.util.Scanner;
import Logica.*;

public class Home {
    public static void main(User loggedAccount, SocialNetwork unikut) {

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

    static void addFriendsUI(SocialNetwork contas){
        Scanner in = new Scanner(System.in);
        String friendLogin;
        User friend;

        System.out.println("Adicionar amigos\nInsira o login do usuario");
        friendLogin = in.next();
        in.nextLine();

        friend = contas.search(friendLogin);

        if(friend == null){
            System.out.println("Usuario não encontrado\n");
        }else{
            int op;
            System.out.println("Correspondente encontrado\nDeseja enviar soliciação de amizade para "+friend.getNome()+" ?");
            System.out.println("1 - Enviar solicitação\n2- Voltar");
            op = in.nextInt();
            if(op == 1){

            }else{
                System.out.println("Retornando a Home");
            }
        }


    }
}
