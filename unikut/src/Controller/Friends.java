package Controller;

import Controller.Exceptions.*;
import Model.*;

public class Friends {
    private static Friends instance;

    public static synchronized Friends getInstance() {
        if (instance == null) {
            instance = new Friends();
        }
        return instance;
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
        User friend = SocialNetwork.getInstance().search(friendLogin);

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

}
