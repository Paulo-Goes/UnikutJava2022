package Controller;

import java.util.HashMap;
import java.util.LinkedList;

public class User implements Comparable<User> {

    private final String login;
    private String nome;
    private String senha;
    protected LinkedList<User> friends = new LinkedList<>();
    public LinkedList<User> friendRequests = new LinkedList<>();
    protected HashMap<User, LinkedList<String>> messages = new HashMap<>();

    public HashMap<User, LinkedList<String>> getMessages() {
        return this.messages;
    }

    public LinkedList<User> getFriends() {
        return friends;
    }

    public LinkedList<User> getFriendRequests() {
        return friendRequests;
    }

    public User(String nome, String login, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public int compareTo(User c) {
        return c.getLogin().compareTo(this.login);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "login: '" + login + '\'' +
                ", nome: '" + nome + '\'' +
                ", senha: '" + senha + '\'' +
                '}';
    }
}