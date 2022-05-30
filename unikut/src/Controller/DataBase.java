package Controller;

import java.util.LinkedList;

import Model.*;

public class DataBase {
    protected LinkedList<User> accounts = new LinkedList<>();

    // Função para procurar uma conta
    public User search(String login) {

        for (User conta : accounts) {
            if (conta.getLogin().equals(login)) {
                return conta;
            }
        }
        return null;
    }

    // Meotodo para exibir as contas cadastradas
    public void showAccounts() {
        for (User conta : accounts) {
            System.out.println(conta);
        }

    }

    // Metodo para inserir a conta na lista
    public void createAccount(String nome, String login, String senha) {

        User newACC = new User(nome, login, senha);
        accounts.add(newACC);

    }
}
