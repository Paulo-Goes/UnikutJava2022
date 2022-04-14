package Logica;

import java.util.LinkedList;

public class User implements Comparable<User> {

    private final String login;
    private String nome;
    private String senha;
    protected LinkedList<User> friends = new LinkedList<>();
    protected LinkedList<User> friendRequests = new LinkedList<>();

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

    protected void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    protected String getSenha() {
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