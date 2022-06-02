package Controller;

import Model.*;
import java.util.LinkedList;

import Exceptions.*;

public class AccountMessages {
    // Exibir menssagens de um usuario
    private static void printMessages(LinkedList<String> texts) {
        for (String s : texts) {
            System.out.println(s);
        }
    }

    // Metodo para exibir menssagens
    public static void showMessages(User user) throws Exception {
        if (user.getMessages().size() == 0) {
            throw new EmptyInboxException();
        } else {
            for (User key : user.getMessages().keySet()) {
                System.out.println("[Menssagems de: " + key.getLogin() + "]");
                printMessages(user.getMessages().get(key));
            }
        }
    }

    // Metodo para enviar depoimentos
    public static void sendMessage(String message, User whosends, String loginFromReceptor) throws Exception {
        User receptor = DataBaseController.search(loginFromReceptor);

        if (receptor == null) {
            throw new UserDoNotExistException();
        } else {
            if (!receptor.getMessages().containsKey(whosends)) {
                receptor.getMessages().put(whosends, new LinkedList<>());
                receptor.getMessages().get(whosends).addFirst(message);
            } else {
                receptor.getMessages().get(whosends).addLast(message);
            }
        }

    }

}
