package Model;

import java.util.LinkedList;

public class DataBase {
    private LinkedList<User> accounts = new LinkedList<>();

    private static DataBase instance;
    // Implementação do padrão criacional Singleton
    public static synchronized DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public LinkedList<User> getAccounts() {
        return accounts;
    }
    
}
