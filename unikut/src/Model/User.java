package Model;

import java.util.HashMap;
import java.util.LinkedList;

public class User implements Comparable<User> {

    private String login;
    private String nome;
    private String senha;
    private LinkedList<User> friends;
    private LinkedList<User> friendRequests;
    private HashMap<User, LinkedList<String>> messages;

    
    
    public void setFriends(LinkedList<User> friends) {
        this.friends = friends;
    }

    public void setFriendRequests(LinkedList<User> friendRequests) {
        this.friendRequests = friendRequests;
    }

    public void setMessages(HashMap<User, LinkedList<String>> messages) {
        this.messages = messages;
    }

    public HashMap<User, LinkedList<String>> getMessages() {
        return this.messages;
    }

    public LinkedList<User> getFriends() {
        return friends;
    }

    public LinkedList<User> getFriendRequests() {
        return friendRequests;
    }

    @Override
    public int compareTo(User c) {
        return c.getLogin().compareTo(this.login);
    }

    public void setLogin(String login) {
        this.login = login;
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