package Controller;

import Controller.Exceptions.*;
import Model.*;

public class AccountFriends {
    // Metodo para exibir amigos
    public static void showFrieds(User user) throws ZeroFriends {
        if (user.getFriends().isEmpty()) {
            throw new ZeroFriends();
        } else {
            for (User u : user.getFriends()) {
                System.out.println(u.getNome() + " (" + u.getLogin() + ")");
            }
        }
    }

    // Metodo para exibir solicitações existentes
    public static void showFriendsRequests(User user) throws EmptyInbox {

        if (user.getFriendRequests().isEmpty()) {
            throw new EmptyInbox();
        } else {
            for (User u : user.getFriendRequests()) {
                System.out.println("Solicitação de amizade pendente de: " + u.getLogin());
            }
        }
    }

    // Metodo para enviar solicitações de amizade
    public static void sendFriendRequest(User whosends, String friendLogin) throws Exception {
        User friend = DataBaseController.search(friendLogin);

        if (friend == null) {
            throw new UserDoNotExist();
        } else if (friend == whosends) {
            throw new AlreadyFriends();
        } else if (whosends.getFriends().contains(friend)) {
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
