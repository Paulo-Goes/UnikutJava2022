package Logica;

public class Conta implements Comparable<Conta> {

    private final String login;
    private String nome;
    private String senha;

    public Conta(String login) {
        this.login = login;
    }

    public Conta(String nome, String login, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public int compareTo(Conta c) {
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