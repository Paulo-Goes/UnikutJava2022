package View.loginView;

import java.util.Scanner;
import Controller.*;
import java.util.Locale;
import Model.*;
import View.Menus;

public class ProfileSettings {

    static Scanner in = new Scanner(System.in);

    // Edição de perfil
    public static void main(User editingAccount) throws Exception {
        char op;
        // Interface de opções
        do {
            Menus.optionsUI(editingAccount); // Exibe opções de edição de perfil
            op = in.next().toLowerCase(Locale.ROOT).charAt(0);
            in.nextLine();
            switch (op) {
                case '1': // Mudarnça de nome
                    Addons.delay(1);
                    changeNameUI(editingAccount);
                    break;
                case '2': // Mudança de senha
                    Addons.delay(1);
                    changePasswordUI(editingAccount);
                    break;
                default: // Reiniciar menu se a opção não estiver listada
                    Addons.delay(1);
                    break;
            }
        } while (op != '0');
    }

    // Interface de mudança de nome no unikut
    static void changeNameUI(User loggedAccount) {
        String newName;

        System.out.println(
                "\n\n< > unikut.com/" + loggedAccount.getLogin() + "/edit/name \nInsira seu novo nome de exibição:");
        newName = in.nextLine();
        Addons.delay(3);
        loggedAccount.setNome(newName); // lidar com exception
    }

    // Interface de mudança de senha
    static void changePasswordUI(User loggedAccount) throws Exception {
        String newPassword;

        System.out.println("\n\n< > unikut.com/" + loggedAccount.getLogin()
                + "/edit/password \nInsira sua nova senha:");
        newPassword = in.next();

        Addons.delay(3);
        try {
            AccountController.changePassword(loggedAccount, newPassword);
        } catch (Exception e) {
            return;
        }
        System.out.println("Senha alterada com sucesso :)");
        Addons.delay(2);
    }
}
