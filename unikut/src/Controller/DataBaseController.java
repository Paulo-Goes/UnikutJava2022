package Controller;

import Exceptions.*;
import Model.*;

public class DataBaseController {
    // Função para procurar uma conta
    public static User search(String login) {

        for (User conta : DataBase.getInstance().getAccounts()) {
            if (conta.getLogin().equals(login)) {
                return conta;
            }
        }
        return null;
    }

    // Meotodo para exibir as contas cadastradas
    public static void showAccounts() {
        for (User conta : DataBase.getInstance().getAccounts()) {
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
        DataBase.getInstance().getAccounts().add(newACC);

    }
}
