package InterfaceGrafica;

import java.util.Scanner;
import Logica.*;

public class ProfileSettings {

    public static void main(User editingAccount) {
        Scanner in = new Scanner(System.in);
        char op;

        // Intarface de opções
        do {
            // Exibe opções de edição de perfil
            optionsUI(editingAccount);

            op = in.next().charAt(0);
            in.nextLine();
            Character.toLowerCase(op);

            switch (op) {
                // Mudarnça de nome
                case '1':
                    Addons.delay(1);
                    changeNameUI(editingAccount);
                    break;
                // Mudança de senha
                case '2':
                    Addons.delay(1);
                    changePasswordUI(editingAccount);
                    break;
                default:
                    System.out.println("Oops, essa opção ainda não existe :/");
                    Addons.delay(1);
                    break;
            }

        } while (op != '0');

    }

    // Menu de opções de edição
    static void optionsUI(User loggedAccount) {
        System.out.println("\n< > unikut.com/" + loggedAccount.getLogin() + "/edit");
        System.out.println();
        System.out.println("Edição de perfil");
        System.out.println("1 - Alterar nome de exibição");
        System.out.println("2 - Alterar senha");
        System.out.println("0 - Retornar à home");

    }

    // Interface de mudança de nome no unikut
    static void changeNameUI(User loggedAccount) {
        Scanner in = new Scanner(System.in);
        String newName;
        int op;

        System.out.println("\nMudar nome de exibição \n Insira seu novo nome de exibição");
        newName = in.nextLine();

        System.out.println("Seu nome de exibição atual é: " + loggedAccount.getNome()
                + "\n\nSeu novo nome de exibição será: " + newName);
        Addons.delay(3);
        System.out.println("1 - Confirmar mudança\n2 - Descatar mudança");
        op = in.nextInt();

        // Condicionais para confirmar a alteração de nome
        if (op == 1) {
            loggedAccount.setNome(newName);
            System.out.println("Mudança efetuada, " + loggedAccount.getNome() + " :)");
            Addons.delay(1);
            return;
        } else {
            System.out.println("Nome de exibição mantido.");
            Addons.delay(1);
            return;
        }

    }

    // Interface de mudança de senha
    static void changePasswordUI(User loggedAccount) {
        Scanner in = new Scanner(System.in);
        String newPassword, newPasswordCheckout;
        int op;

        do {

            System.out.println("Insira sua nova senha");
            newPassword = in.next();
            in.nextLine();

            System.out.println("Insira sua nova senha novamente");
            newPasswordCheckout = in.next();
            in.nextLine();

        } while (!newPassword.equals(newPasswordCheckout)); // Força a igualdade entre as duas senhas iseridas acinma

        System.out.println("Tem certeza que deseja alterar a senha, " + loggedAccount.getNome() + " ?");
        Addons.delay(3);
        System.out.println("1 - Sim c:\n2 - Não :c");

        op = in.nextInt();

        if (op == 1) {
            loggedAccount.setSenha(newPassword); // Metodo que muda a senha na classe contas
            System.out.println("Senha alterada com sucesso :)");

        } else {
            System.out.println("A mudança foi descartadas Mr. " + loggedAccount.getNome() + " :)");

        }

        Addons.delay(2);

    }

}
