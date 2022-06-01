package Controller;

import Controller.Exceptions.*;
import Database.Accounts;
import Model.*;

public class SocialNetwork {
    // Função para procurar uma conta
    public static User search(String login) {

        for (User conta : Accounts.getInstance().getAccounts()) {
            if (conta.getLogin().equals(login)) {
                return conta;
            }
        }
        return null;
    }

    // Meotodo para exibir as contas cadastradas
    public static void showAccounts() {
        for (User conta : Accounts.getInstance().getAccounts()) {
            System.out.println(conta);
        }

    }

    // Metodo para inserir a conta na lista
    public static void createAccount(String nome, String login, String senha) throws Exception {

        if (search(login) != null) {
            throw new LoginInUse();
        } else if (!AccountController.senhaForte(senha)) {
            throw new WeakPassword();
        }
        User newACC = new User(nome, login, senha);
        Accounts.getInstance().getAccounts().add(newACC);

    }
}
