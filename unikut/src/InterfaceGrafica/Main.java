package InterfaceGrafica;

import Logica.*;

import java.util.Scanner;

public class Main {

    public static SocialNetwork unikut = new SocialNetwork();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char menuInput;

        // Intarface de opções
        do {
            // Exibe opções iniciais
            menuUI();
            menuInput = input.next().charAt(0);
            input.nextLine();

            switch (menuInput) {
                case '1':
                    // Interface de criação de conta na classe SignUp
                    Addons.delay(1);
                    SignUp.main(unikut);
                    break;
                case '2':
                    // Logica de login no meotodo loginUI
                    Addons.delay(1);
                    loginUI(unikut);
                    break;
                case 'e':
                    // Exibe todos os usuarios cadastrados até o momento (APENAS PARA TESTES)
                    System.out.println("/Lista de usuarios cadastrados/");
                    unikut.showAccounts();
                    break;
                default:
                    // Exibição caso a opção não esteja no menu
                    System.out.println("Oops, não temos essa opção :/");
                    Addons.delay(1);
                    break;
            }
        } while (menuInput != '0');

        System.out.println("Foi bom enquanto durou :/");
        Addons.delay(2);
    }

    // Meotodo que exibe as opções do menu
    static void menuUI() {
        System.out.println("\n< > unikut.com");
        System.out.println();
        System.out.println("| UNIKUT SOCIAL MEDIA © | ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("0 - Sair");
    }

    // Interface de login
    static void loginUI(SocialNetwork unikut) {
        String loginInput, senhaInput;
        Scanner in = new Scanner(System.in);
        System.out.println("Conecte-se usando suas credenciais");
        do {
            System.out.println("Insira o login: ");
            loginInput = in.next();
            in.nextLine();
            System.out.println("Insira a senha: ");
            senhaInput = in.next();
            in.nextLine();
        } while (unikut.login(loginInput, senhaInput) == null); // função que retorna uma conta se as credencias
                                                                // corresponderem a uma conta cadastrada

        System.out.println("Login efetuado com sucesso!");
        Addons.delay(1);
        Home.main(unikut.login(loginInput, senhaInput)); // vai para a interface de login
    }

}