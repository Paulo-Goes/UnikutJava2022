package View;

import java.util.Scanner;

import java.util.Locale;
import Controller.*;
import View.loginView.Home;

public class App {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        char menuInput;

        do {
            Menus.mainUI(); // Exibe opções iniciais
            menuInput = in.next().charAt(0);
            in.nextLine();
            switch (menuInput) {
                case '1': // Interface de criação de conta na classe SignUp
                    Addons.delay(1);
                    signUpUI();
                    break;
                case '2': // Logica de login no método loginUI
                    Addons.delay(1);
                    loginUI();
                    break;
                default: // Reiniciar menu se a opção não estiver listada
                    break;
            }
        } while (menuInput != '0');
    }

    // Interface de login
    static void loginUI() throws Exception {
        String loginInput, senhaInput;

        System.out.println("\n< > unikut.com/login \n");
        System.out.println("Insira o login: ");
        loginInput = in.next();
        System.out.println("Insira a senha: ");
        senhaInput = in.next();

        Addons.delay(1);
        try {
            Home.main(AccountController.login(loginInput, senhaInput));
        } catch (Exception e) {
            char choice;
            do {
                System.out.println("\nDeseja retornar ao menu inicial? S/N");
                choice = in.next().charAt(0);
                choice = Character.toLowerCase(choice);
                if (choice == 's') {
                    return;
                } else {
                    loginUI();
                }
            } while (choice != 's' && choice != 'n');
        }
    }

    // Interface de cadastro
    static void signUpUI() {
        String nome = "convidado", login, senha; char choice;

        System.out.println("\n< > unikut.com/signup");

        System.out.println("Insira um Login");
        login = in.next();

        System.out.println("Crie sua senha:");
        senha = in.next();

        do {
            System.out.println("Deseja inserir o nome? \n S/N");
            choice = in.next().toLowerCase(Locale.ROOT).charAt(0);
        } while (choice != 's' && choice != 'n');

        if (choice == 's') {
            System.out.println("Insira o nome");
            nome = in.nextLine(); nome = in.nextLine();
        }

        Addons.delay(2);

        try {
            SocialNetwork.createAccount(nome, login, senha);
        } catch (Exception e) {
            do {
                System.out.println("\nDeseja retornar ao menu inicial? S/N");
                choice = in.next().charAt(0);
                choice = Character.toLowerCase(choice);
                if (choice == 's') {
                    return;
                } else {
                    signUpUI();
                }
            } while (choice != 's' && choice != 'n');
        }
        System.out.println("Conta criada com sucesso! use suas credenciais para fazer login na proxima vez :)");
    }
}