package Logica;

import java.util.HashMap;
import java.util.LinkedList;

public class SocialNetwork {
    private LinkedList<User> accounts = new LinkedList<>();

    // Exibir menssagens de um usuario
    public void printMessages(LinkedList<String> texts) {
        if (texts == null) {
            System.out.println("Não há novas messagens deste usuario");
        } else {
            for (String s : texts) {
                System.out.println(s);
            }
        }
    }

    // Metodo para exibir menssagens
    public void showMessages(User user) {
        HashMap<User, LinkedList<String>> userMessages = user.getMessages();

        if (userMessages == null) {
            System.out.println("Não hà novos depoimentos para você");
        } else {
            for (User key : userMessages.keySet()) {
                System.out.println("[Menssagems de: " + key.getLogin() + "]");
                printMessages(userMessages.get(key));
            }
        }
    }

    // Metodo para enviar depoimentos
    public void sendMessage(String message, User whosends, String loginFromReceptor) {
        User receptor = search(loginFromReceptor);

        if (receptor == null) {
            System.out.println("Destinatário não existe");
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
    public void changePassword(User user, String password) {
        user.setSenha(password);
    }

    // Metodo para exibir amigos
    public void showFrieds(User user) {
        if (user.getFriends().isEmpty()) {
            System.out.println("Você não tem amigos :c");
        } else {
            for (User u : user.getFriends()) {
                System.out.println(u.getNome() + " (" + u.getLogin() + ")");
            }
        }
    }

    // Metodo para exibir solicitações existentes
    public void showFriendsRequests(User user) {

        if (user.getFriendRequests().isEmpty()) {
            System.out.println("Você não possui solicitações no momento");
        } else {
            for (User u : user.getFriendRequests()) {
                System.out.println("Solicitação de amizade pendente de: " + u.getLogin());
            }
            System.out.println("Para aceitar, envie solicitação para o login");
        }
    }

    // Metodo para enviar solicitações de amizade
    public void sendFriendRequest(User whosends, String friendLogin) {
        User friend = search(friendLogin);

        if (friend == null) {
            System.out.println("Usuario não encontrado");
        } else if (friend == whosends) {
            System.out.println("Não é possivel enviar uma solicitação para si mesmo");
        } else if (whosends.getFriends().contains(friend) || friend.getFriends().contains(whosends)) {
            System.out.println("Vocês já são amigos");
        } else if (friend.getFriendRequests().contains(whosends)) {
            System.out.println("Você já enviou a solicitação uma vez");
        } else if (whosends.getFriendRequests().contains(friend)) {
            whosends.getFriends().add(friend);
            friend.getFriends().add(whosends);
            whosends.getFriendRequests().remove(friend);
            System.out.println("Solicitação aceita");
        } else {
            friend.friendRequests.add(whosends);
            System.out.println("Solicitação de amizade enviada");
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

    // Meotodo para exibir as accounts cadastradas
    public void showAccounts() {
        for (User conta : accounts) {
            System.out.println(conta);
        }
    }

}
