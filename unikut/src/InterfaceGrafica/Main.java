package InterfaceGrafica;

import Logica.Conta;
import Logica.Contas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contas contas = new Contas();
        char menuInput;

        System.out.println("Starting....");

        do {
            menuUI();
            menuInput = input.next().charAt(0);

            switch (menuInput) {
                case '1':
                    // Interface de criação de conta
                    System.out.println("/Interface de criação de conta/");
                    criarContaUI(contas);
                    break;
                case '2':
                    // Aqui será a interface de login
                    System.out.println("Indisponivel");
                    break;
                case '3':
                    // Interface de recuperação de senha
                    recuperarSenha(contas);
                    break;
                case '4':
                    // Exibe todos os usuarios cadastrados até o momento
                    System.out.println("Exibindo contas...");
                    contas.exibirContas();
                    break;
                default:
                    // Exibição caso a opção não esteja no menu
                    System.out.println("Ocorreu um erro: Opção invalida");
                    break;
            }
        } while (menuInput != '0');
    }

    static void menuUI() {
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("3 - Recuperar senha)");
        System.out.println("4 - Exibir usuarios cadastrados");
        System.out.println("5 - Sair");
    }

    static void criarContaUI(Contas contas) {
        Scanner input = new Scanner(System.in);
        String nome, login, senha;
        char nameOptionInput;

        System.out.println("Insira o Login");
        login = input.nextLine();

        System.out.println("Insira a Senha");
        senha = input.nextLine();

        System.out.println("Deseja inserir o nome? \n S/N");
        nameOptionInput = input.next().charAt(0);
        Character.toLowerCase(nameOptionInput);
        while (nameOptionInput != 's' && nameOptionInput != 'n') {
            System.out.println("Oops, o caracter inserido deve ser [S] ou [N] (not case sensetive)");
            nameOptionInput = input.next().charAt(0);
            Character.toLowerCase(nameOptionInput);
        }

        if (nameOptionInput == 's') {
            System.out.println("Insira o nome");
            nome = input.nextLine();
        } else {
            nome = "convidado";
        }

        contas.newAccount(login, nome, senha);

        input.close();
    }

    static void recuperarSenha(Contas contas) {
        Scanner input = new Scanner(System.in);
        String login;
        int codigo;
        System.out.println("/Interface de recuperação de conta/");
        System.out.println("Digite o login: ");
        login = input.nextLine();
        Conta c = contas.login(login);
        if (c != null) {
            System.out.println("Digite o codigo de recuperação: ");
            codigo = input.nextInt();
            c.recuperarSenha(login, codigo);
        }
        input.close();
    }
}