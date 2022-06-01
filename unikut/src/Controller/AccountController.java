package Controller;

import Controller.Exceptions.*;
import Model.*;

public class AccountController {
    // Metodo para alterar senha
    public static void changePassword(User user, String password) throws Exception {
        if (!senhaForte(password)) {
            throw new WeakPassword();
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
