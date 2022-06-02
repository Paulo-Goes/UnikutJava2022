package View.firstView;

import java.util.Locale;
import java.util.Scanner;
import Others.Addons;

import Controller.DataBaseController;

public class SignUp extends Thread{

    private Scanner in = new Scanner(System.in);

    public void run() {
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
            DataBaseController.createAccount(nome, login, senha);
        } catch (Exception e) {
            do {
                System.out.println("\nDeseja retornar ao menu inicial? S/N");
                choice = in.next().charAt(0);
                choice = Character.toLowerCase(choice);
                if (choice == 's') {
                    return;
                } else {
                    run();
                }
            } while (choice != 's' && choice != 'n');
        }
        System.out.println("Conta criada com sucesso! use suas credenciais para fazer login na proxima vez :)");
    }
}
