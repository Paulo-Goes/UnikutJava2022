package Database;

import java.util.LinkedList;

import Model.User;

public class Accounts {
    private LinkedList<User> accounts = new LinkedList<>();

    private static Accounts instance;

    public static synchronized Accounts getInstance() {
        if (instance == null) {
            instance = new Accounts();
        }
        return instance;
    }

    public LinkedList<User> getAccounts() {
        return accounts;
    }
    
}
