package Controller;

import java.util.HashMap;
import java.util.LinkedList;
import Model.*;
import Exceptions.*;

public class SocialNetwork {
    private static SocialNetwork instance;
    private LinkedList<User> accounts = new LinkedList<>();

    private SocialNetwork() {
    }

    public static synchronized SocialNetwork getInstance(){
        if (instance == null){
            instance = new SocialNetwork();
        }
        return instance;
    }

    // Exibir menssagens de um usuario
    private void printMessages(LinkedList<String> texts) {
        for (String s : texts) {
            System.out.println(s);
        }
    }

    // Metodo para exibir menssagens
    public void showMessages(User user) throws Exception{
        HashMap<User, LinkedList<String>> userMessages = user.getMessages();

        if (userMessages.size() == 0) {
            throw new EmptyInbox();
        } else {
            for (User key : userMessages.keySet()) {
                System.out.println("[Menssagems de: " + key.getLogin() + "]");
                printMessages(userMessages.get(key));
            }
        }
    }

    // Metodo para enviar depoimentos
    public void sendMessage(String message, User whosends, String loginFromReceptor) throws Exception{
        User receptor = search(loginFromReceptor);

        if (receptor == null) {
            throw new UserDoNotExist();
        } else {
            HashMap<User, LinkedList<String>> map = receptor.getMessages();
            LinkedList<String> receptorMessages;

            if (!map.containsKey(whosends)) {
                map.put(whosends, new LinkedList<>());
                receptorMessages = receptor.getMessages().get(whosends);
                receptorMessages.addFirst(message);
            } else {
                receptorMessages = receptor.getMessages().get(whosends);
                receptorMessages.addLast(message);
            }
        }

    }

    // Metodo para alterar senha
    public void changePassword(User user, String password) throws Exception{
        if(!senhaForte(password)){
            throw new WeakPassword();
        }else{
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
            }
            else if (c >= 'A' && c <= 'Z') {
                maiscula = true;
            }
            else if (c >= 'a' && c <= 'z') {
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
            friend.friendRequests.add(whosends);
        }

    }

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

    // Meotodo para exibir as contas cadastradas
    public void showAccounts() {
        for (User conta : accounts) {
            System.out.println(conta);
        }
    }

}
