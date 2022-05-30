package View;

import java.util.Scanner;

import java.util.Locale;
import Controller.*;

public class Main {
    public static SocialNetwork unikut = SocialNetwork.getInstance();

    public static void main(String[] args) throws Exception {
        SocialNetwork unikut = SocialNetwork.getInstance();
        Scanner input = new Scanner(System.in);
        char menuInput;
        // Interface de opções
        do {
            // Exibe opções iniciais
            menuUI();
            menuInput = input.next().charAt(0);
            input.nextLine();
            switch (menuInput) {
                case '1': // Interface de criação de conta na classe SignUp
                    Addons.delay(1);
                    signUpUI();
                    break;
                case '2': // Logica de login no método loginUI
                    Addons.delay(1);
                    loginUI(unikut);
                    break;
                case 'e': // Exibe todos os usuários cadastrados até o momento (APENAS PARA TESTES)
                    System.out.println("/Lista de usuarios cadastrados/");
                    unikut.showAccounts();
                    break;
                default: // Reiniciar menu se a opção não estiver listada
                    break;
            }
        } while (menuInput != '0');

        System.out.println("Foi bom enquanto durou :/");
        Addons.delay(2);
    }

    // Método que exibe as opções do menu
    static void menuUI() {
        System.out.println("\n< > unikut.com");
        System.out.println();
        System.out.println("| UNIKUT SOCIAL MEDIA © | ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("0 - Sair");
    }

    // Interface de login
    static void loginUI(SocialNetwork unikut) throws Exception {
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
            if (unikut.login(loginInput, senhaInput) == null) {
                System.out.println("Suas credencias não foram validadas.");
                return;
            }
        } while (unikut.login(loginInput, senhaInput) == null); // função que retorna uma conta se as credencias
        // corresponderem a uma conta cadastrada
        System.out.println("Login efetuado com sucesso!");
        Addons.delay(1);
        Home.main(unikut.login(loginInput, senhaInput)); // vai para a interface de login

    }

    // Interface de cadastro
    static void signUpUI() {
        Scanner input = new Scanner(System.in);
        SocialNetwork unikut = SocialNetwork.getInstance();
        String nome, login, senha;
        char nameOptionInput;

        System.out.println("\nCriação de conta");

        // Solicita um login ao usuario
        System.out.println("Insira um Login");
        login = input.next();
        input.nextLine();

        // Força o usuario a inserir um login que não foi utilizado
        while (unikut.search(login) != null) {
            System.out.println("O login informado já está sendo usado :/");
            Addons.delay(350);
            System.out.println("Insira um login: ");
            login = input.next();
        }

        // Solicita uma senha ao usuario como os critérios informados
        System.out.println("Criação de senha:");
        System.out.println("* Mais do que 6 caracteres");
        System.out.println("* Letras maiúsculas e minúsculas");
        System.out.println("* Números");
        System.out.println("* Caracteres especiais");
        System.out.println("Insira uma senha forte:");
        senha = input.next();
        input.nextLine();

        // Usuário é forçado à criar uma conta com os critérios informados
        while (!unikut.senhaForte(senha)) {
            System.out.println("Senha muito fraca :/");
            Addons.delay(350);
            System.out.println("Insira outra senha: ");
            senha = input.next();
        }

        // Pergunta se o usuario deseja adicionar um nome
        System.out.println("Deseja inserir o nome? \n S/N");
        nameOptionInput = input.next().toLowerCase(Locale.ROOT).charAt(0);
        input.nextLine();

        // Força o usuario a inserir apenas S ou N em nameOptionInput
        while (nameOptionInput != 's' && nameOptionInput != 'n') {
            System.out.println("Oops, o caracter inserido deve ser [S] ou [N] (not case sensetive)");
            Addons.delay(350);
            System.out.println("Deseja inserir o nome \n S/N");
            nameOptionInput = input.next().toLowerCase(Locale.ROOT).charAt(0);
            input.nextLine();
        }

        // Logica para vincular um nome a conta ou definir nome como "convidado"
        if (nameOptionInput == 's') {
            System.out.println("Insira o nome");
            nome = input.nextLine();
        } else {
            nome = "convidado";
        }

        System.out.println("Conta criada com sucesso! use suas credenciais para fazer login na proxima vez :)");
        Addons.delay(2);

        // Metodo para criar a conta
        unikut.createAccount(nome, login, senha);
    }
}