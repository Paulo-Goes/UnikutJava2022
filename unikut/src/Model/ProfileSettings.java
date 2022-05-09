package Model;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import Controller.Addons;
import Controller.User;
import View.Main;

public class ProfileSettings {
    public static void main(User editingAccount) {
        try (Scanner in = new Scanner(System.in)) {
            char op;
            // Interface de opções
            do {
                optionsUI(editingAccount); // Exibe opções de edição de perfil
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
                        System.out.println("Oops, essa opção ainda não existe :/");
                        Addons.delay(1);
                        break;
                }
            } while (op != '0');
        }
    }
    static void optionsUI(User loggedAccount) { // Menu de opções de edição
        System.out.println("\n< > unikut.com/" + loggedAccount.getLogin() + "/edit");
        System.out.println();
        System.out.println("Edição de perfil");
        System.out.println("1 - Alterar nome de exibição");
        System.out.println("2 - Alterar senha");
        System.out.println("0 - Retornar à home");
    }
    static void changeNameUI(User loggedAccount) { // Interface de mudança de nome no unikut
        try (Scanner in = new Scanner(System.in)) {
            String newName;
            int op;
            System.out.println("\nMudar nome de exibição \n Insira seu novo nome de exibição");
            newName = in.nextLine();
            System.out.println("Seu nome de exibição atual é: " + loggedAccount.getNome()
                    + "\n\nSeu novo nome de exibição será: " + newName);
            Addons.delay(3);
            System.out.println("1 - Confirmar mudança\n2 - Descatar mudança");
            
            //Tratamento de um possivel exception
            try {
                op = in.nextInt();
                if (op == 1) { // Condicionais para confirmar a alteração de nome
                    loggedAccount.setNome(newName);
                    System.out.println("Mudança efetuada, " + loggedAccount.getNome() + " :)");
                    Addons.delay(1);
                } else if (op == 2){
                    System.out.println("Nome de exibição mantido.");
                    Addons.delay(1);
                }
                else {
                    System.out.println("Opção invalida, digite uma opção válida.");
                }
                //Tratamento de um possivel exception
            } catch (InputMismatchException e){
                System.err.println("Opção inválida. Digite 1 ou 2 para validar o processo, retornando para o menu anterior.");
            }
        }
    }
    static void changePasswordUI(User loggedAccount) { // Interface de mudança de senha
        try (Scanner in = new Scanner(System.in)) {
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
            //Tratamento de um possivel exception
            try {
                op = in.nextInt();
                if (op == 1) {
                    Main.unikut.changePassword(loggedAccount, newPassword); // Metodo que muda a senha na classe contas
                    System.out.println("Senha alterada com sucesso :)");
                } else if (op == 2){
                    System.out.println("A mudança foi descartadas Mr. " + loggedAccount.getNome() + " :)");
                }
                else if (op == 0){
                    System.out.println("Retornando ao menu anterior.");
                }else {
                    System.out.println("Opção invalida, digite uma opção válida.");
                }
                //Tratamento de um possivel exception
            }catch (InputMismatchException e){
                System.err.println("Opção inválida. Digite 1 ou 2 para validar o processo, retornando para o menu anterior.");
            }
        }
        Addons.delay(2);
    }

}
