package InterfaceGrafica;

import Logica.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static SocialNetwork unikut = new SocialNetwork();
    public static void main(String[] args) {
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
                    SignUp.main(unikut);
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
    static void loginUI(SocialNetwork unikut) {
        String loginInput, senhaInput;
        char op;
        Scanner in = new Scanner(System.in);
        System.out.println("Voltar para o menu principal?");
        System.out.println("S/N");
        op = in.next().toLowerCase(Locale.ROOT).charAt(0);
        while (op != 's' && op != 'n') {
            System.out.println("Erro, digite uma opção válida!");
            System.out.println("Voltar para o menu principal?");
            System.out.println("S/N");
            op = in.next().toLowerCase(Locale.ROOT).charAt(0);
        }
        if(op == 'n'){
        System.out.println("Conecte-se usando suas credenciais");
        do {
                System.out.println("Insira o login: ");
                loginInput = in.next();
                in.nextLine();
                System.out.println("Insira a senha: ");
                senhaInput = in.next();
                in.nextLine();
                if (unikut.login(loginInput, senhaInput) == null){
                    System.out.println("Suas credencias não foram validadas.");
                }
        } while (unikut.login(loginInput, senhaInput) == null); // função que retorna uma conta se as credencias
                                                                // corresponderem a uma conta cadastrada
            System.out.println("Login efetuado com sucesso!");
            Addons.delay(1);
            Home.main(unikut.login(loginInput, senhaInput)); // vai para a interface de login
        }
    }
}