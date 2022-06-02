package View.firstView;

import java.util.Scanner;
import Controller.AccountController;
import View.Menus;
import View.loginView.Home;
import Others.Addons;

public class App {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        SignUp cadastro;
        char menuInput;

        do {
            Menus.mainUI(); // Exibe opções iniciais
            menuInput = in.next().charAt(0);
            in.nextLine();
            switch (menuInput) {
                case '1': // Interface de criação de conta na classe SignUp
                    Addons.delay(1);
                    cadastro = new SignUp();
                    cadastro.start();
                    try{
                        cadastro.join();
                    }catch(InterruptedException e){
                    }
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
}