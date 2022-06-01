package Controller;

import java.util.LinkedList;

import Controller.Exceptions.*;
import Model.*;

public class SocialNetwork {
    private static SocialNetwork instance;
    protected LinkedList<User> accounts = new LinkedList<>();

    public static synchronized SocialNetwork getInstance() {
        if (instance == null) {
            instance = new SocialNetwork();
        }
        return instance;
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

    // Meotodo para exibir as contas cadastradas
    public void showAccounts() {
        for (User conta : accounts) {
            System.out.println(conta);
        }

    }

    // Metodo para inserir a conta na lista
    public void createAccount(String nome, String login, String senha) throws Exception {

        if (search(login) != null) {
            throw new LoginInUse();
        } else if (!senhaForte(senha)) {
            throw new WeakPassword();
        }
        User newACC = new User(nome, login, senha);
        accounts.add(newACC);

    }

    // Metodo para alterar senha
    public void changePassword(User user, String password) throws Exception {
        if (!senhaForte(password)) {
            throw new WeakPassword();
        } else {
            user.setSenha(password);
        }
    }

    // lógica para a senha ser válida
    private boolean senhaForte(String senha) {

        boolean numero = false;
        boolean maiscula = false;
        boolean minuscula = false;

        if (senha.length() < 6) {
            return false;
        }
        for (char c : senha.toCharArray()) {

            if (c >= '0' && c <= '9') {
                numero = true;
            } else if (c >= 'A' && c <= 'Z') {
                maiscula = true;
            } else if (c >= 'a' && c <= 'z') {
                minuscula = true;
            }
        }
        return numero && maiscula && minuscula;
    }

    // Função para verificar credenciais de login
    public User login(String login, String senha) throws Exception {
        User acc = search(login);
        if (acc == null) {
            throw new InvalidCredentials();
        } else {
            if (acc.getSenha().equals(senha)) {
                return acc;
            } else {
                throw new InvalidCredentials();
            }
        }
    }

}
