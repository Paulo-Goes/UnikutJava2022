package Controller;

import java.util.LinkedList;

import Controller.Exceptions.*;
import Model.*;

public class SocialNetwork{
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
    public void createAccount(String nome, String login, String senha) {

        User newACC = new User(nome, login, senha);
        accounts.add(newACC);

    }

    // Exibir menssagens de um usuario
    private void printMessages(LinkedList<String> texts) {
        for (String s : texts) {
            System.out.println(s);
        }
    }

    // Metodo para exibir menssagens
    public void showMessages(User user) throws Exception {
        if (user.getMessages().size() == 0) {
            throw new EmptyInbox();
        } else {
            for (User key : user.getMessages().keySet()) {
                System.out.println("[Menssagems de: " + key.getLogin() + "]");
                printMessages(user.getMessages().get(key));
            }
        }
    }

    // Metodo para enviar depoimentos
    public void sendMessage(String message, User whosends, String loginFromReceptor) throws Exception {
        User receptor = search(loginFromReceptor);

        if (receptor == null) {
            throw new UserDoNotExist();
        } else {
            if (!receptor.getMessages().containsKey(whosends)) {
                receptor.getMessages().put(whosends, new LinkedList<>());
                receptor.getMessages().get(whosends).addFirst(message);
            } else {
                receptor.getMessages().get(whosends).addLast(message);
            }
        }

    }

    // Metodo para alterar senha
    public void changePassword(User user, String password) throws Exception {
        if (!senhaForte(password)) {
            throw new WeakPassword();
        } else {
            user.setSenha(password);
        }
    }

    // Metodo para exibir amigos
    public void showFrieds(User user) throws ZeroFriends {
        if (user.getFriends().isEmpty()) {
            throw new ZeroFriends();
        } else {
            for (User u : user.getFriends()) {
                System.out.println(u.getNome() + " (" + u.getLogin() + ")");
            }
        }
    }

    // lógica para a senha ser válida
    public boolean senhaForte(String senha) {

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

    // Metodo para exibir solicitações existentes
    public void showFriendsRequests(User user) throws EmptyInbox {

        if (user.getFriendRequests().isEmpty()) {
            throw new EmptyInbox();
        } else {
            for (User u : user.getFriendRequests()) {
                System.out.println("Solicitação de amizade pendente de: " + u.getLogin());
            }
        }
    }

    // Metodo para enviar solicitações de amizade
    public void sendFriendRequest(User whosends, String friendLogin) throws Exception {
        User friend = search(friendLogin);

        if (friend == null) {
            throw new UserDoNotExist();
        } else if (friend == whosends) {
            throw new AlreadyFriends();
        } else if (whosends.getFriends().contains(friend) || friend.getFriends().contains(whosends)) {
            throw new AlreadyFriends();
        } else if (friend.getFriendRequests().contains(whosends)) {
            throw new AlreadySend();
        } else if (whosends.getFriendRequests().contains(friend)) {
            whosends.getFriends().add(friend);
            friend.getFriends().add(whosends);
            whosends.getFriendRequests().remove(friend);
            throw new NotSolicitaion();
        } else {
            friend.getFriendRequests().add(whosends);
        }

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
