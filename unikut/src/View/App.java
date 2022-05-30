package View;

import java.util.Scanner;

import java.util.Locale;
import Controller.*;
import Exceptions.InvalidCredentials;
import Model.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
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
                    System.out.println("oops, opção não listada.");
                    break;
            }
        } while (menuInput != '0');
    }

    // Interface de login
    static void loginUI() throws Exception {
        Scanner in = new Scanner(System.in);
        String loginInput, senhaInput;

        System.out.println("Conecte-se usando suas credenciais");
        System.out.println("Insira o login: ");
        loginInput = in.next();
        System.out.println("Insira a senha: ");
        senhaInput = in.next();

        Addons.delay(1);
        try {
            Home.main(SocialNetwork.getInstance().login(loginInput, senhaInput));
        } catch (Exception e) {
            return;
        }
    }

    // Interface de cadastro
    static void signUpUI() {
        Scanner in = new Scanner(System.in);
        String nome, login, senha;
        char nameOptionInput;

        System.out.println("\nCriação de conta");

        // Solicita um login ao usuario
        System.out.println("Insira um Login");
        login = in.next();

        // Força o usuario a inserir um login que não foi utilizado
        while (SocialNetwork.getInstance().search(login) != null) {
            System.out.println("O login informado já está sendo usado :/");
            Addons.delay(350);
            System.out.println("Insira um login: ");
            login = in.next();
        }

        // Solicita uma senha ao usuario como os critérios informados
        System.out.println("Criação de senha:");
        System.out.println("* Mais do que 6 caracteres");
        System.out.println("* Letras maiúsculas e minúsculas");
        System.out.println("* Números");
        System.out.println("* Caracteres especiais");
        System.out.println("Insira uma senha forte:");
        senha = in.next();

        // Usuário é forçado à criar uma conta com os critérios informados
        while (!SocialNetwork.getInstance().senhaForte(senha)) {
            System.out.println("Senha muito fraca :/");
            Addons.delay(350);
            System.out.println("Insira outra senha: ");
            senha = in.next();
        }

        // Pergunta se o usuario deseja adicionar um nome
        do {
            System.out.println("Deseja inserir o nome? \n S/N");
            nameOptionInput = in.next().toLowerCase(Locale.ROOT).charAt(0);
        } while (nameOptionInput != 's' && nameOptionInput != 'n');

        // Logica para vincular um nome a conta ou definir nome como "convidado"
        if (nameOptionInput == 's') {
            System.out.println("Insira o nome");
            nome = in.nextLine();
            nome = in.nextLine();
        } else {
            nome = "convidado";
        }

        System.out.println("Conta criada com sucesso! use suas credenciais para fazer login na proxima vez :)");
        Addons.delay(2);

        // Metodo para criar a conta
        SocialNetwork.getInstance().createAccount(nome, login, senha);
    }
}