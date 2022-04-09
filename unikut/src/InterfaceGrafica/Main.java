package InterfaceGrafica;

import Logica.Contas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contas contas = new Contas();
        char menuInput;

        // Menu de ações iniciais
        do {
            menuUI();
            menuInput = input.next().charAt(0);
            input.nextLine();

            switch (menuInput) {
                case '1':
                    // Interface de criação de conta
                    System.out.println("/Interface de criação de conta/");
                    SignUp.main(contas);
                    break;
                case '2':
                    // Aqui será a interface de login
                    System.out.println("Indisponivel");
                    break;
                case 'e':
                    // Exibe todos os usuarios cadastrados até o momento (APENAS PARA TESTES)
                    System.out.println("/Lista de usuarios cadastrados/");
                    contas.exibirContas();
                    break;
                default:
                    // Exibição caso a opção não esteja no menu
                    System.out.println("Ocorreu um erro: Opção invalida");
                    break;
            }
        } while (menuInput != '0');

        input.close();
    }

    static void menuUI() {
        System.out.println("| UNIKUT SOCIAL MEDIA © | ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("0 - Sair");
    }

}