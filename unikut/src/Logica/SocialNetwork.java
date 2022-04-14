package Logica;

import java.util.ArrayList;

public class SocialNetwork {
    private ArrayList<User> accounts = new ArrayList<>();

    // Função para verificar credenciais de login
    public User login(String login, String senha) {
        User acc = search(login);
        if (acc == null) {
            return null;
        } else {
            if (acc.getSenha().equals(senha)) {
                return acc;
            }
        }

        return null;
    }

    // Função para procurar uma conta
    public User search(String login) {

        for (User conta : accounts) {
            if (conta.getLogin().equals(login)) {
                return conta;
            }
        }
        return null;
    }

    // Metodo para inserir a conta na lista
    public void createAccount(String nome, String login, String senha) {

        User newACC = new User(nome, login, senha);
        accounts.add(newACC);

    }

    // Meotodo para exibir as accounts cadastradas
    public void showAccounts() {
        for (User conta : accounts) {
            System.out.println(conta);
        }
    }

}
