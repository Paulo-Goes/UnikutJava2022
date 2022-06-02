package Controller;

import java.util.HashMap;
import java.util.LinkedList;

import Exceptions.*;
import Model.*;

public class AccountController {
    // Metodo para alterar senha
    public static void changePassword(User user, String password) throws Exception {
        if (!senhaForte(password)) {
            throw new WeakPasswordException();
        } else {
            user.setSenha(password);
        }
    }

    // lógica para a senha ser válida
    protected static boolean senhaForte(String senha) {

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
    public static User login(String login, String senha) throws Exception {
        User acc = DataBaseController.search(login);
        if (acc == null) {
            throw new InvalidCredentialsException();
        } else {
            if (acc.getSenha().equals(senha)) {
                return acc;
            } else {
                throw new InvalidCredentialsException();
            }
        }
    }

    //Factory method
    protected static User factoryUser(String login, String password, String name){
        LinkedList<User> friends = new LinkedList<>();
        LinkedList<User> friendRequests = new LinkedList<>();
        HashMap<User, LinkedList<String>> messages = new HashMap<>();

        User user = new User();
        user.setLogin(login);
        user.setSenha(password);
        user.setNome(name);
        user.setFriends(friends);
        user.setFriendRequests(friendRequests);
        user.setMessages(messages);

        return user;
    }
}
