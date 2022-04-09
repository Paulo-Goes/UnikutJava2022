package InterfaceGrafica;

import Logica.Conta;
import Logica.Contas;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Character.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contas contas = new Contas();
        char menuInput;

        System.out.println("Starting....");

        do {
            menu();
            menuInput = input.next().charAt(0);
            while (!isDigit(menuInput)) {
                menuInput = input.next().charAt(0);
            }
            
            switch (menuInput) {
                case '1':
                    criarContaUI(contas);
                    break;
                case '2':
                    // Aqui será a interface de login
                    System.out.println("Indisponivel");
                    break;
                case '3':
                    recuperarSenha(contas);
                    break;
                case '4':
                    System.out.println("Exibindo contas...");
                    contas.exibirContas();
                    break;
                default:
                    break;
            }
        } while (menuInput != '0');
    }

    static void criarContaUI(Contas contas){
        Scanner input = new Scanner(System.in);
        String nome, login, senha;
        Conta c;

        System.out.println("/Interface de criação de conta/");
        System.out.println("Insira o nome");
        nome = input.nextLine();

        System.out.println("Insira o Login");
        login = input.nextLine();

        System.out.println("Insira a Senha");
        senha = input.nextLine();

        contas.newAccount(login, nome, senha);
    }

    static void menu() {
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("3 - Recuperar senha)");
        System.out.println("4 - Exibir usuarios cadastrados");
        System.out.println("5 - Sair");
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
    }
}