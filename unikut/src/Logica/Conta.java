package Logica;

import java.util.Random;

public class Conta {
    private final String login;
    private String nome;
    private String senha;
    private int codigoRecuperacao;

    public Conta(String login, String senha){
        this.login = login;
        this.nome = "convidado";
        this.senha = senha;
        this.codigoRecuperacao = criaCodigo();
    }
    public Conta(String login, String nome, String senha){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.codigoRecuperacao = criaCodigo();
    }

    private int criaCodigo() {
        Random r = new Random();
        int codigo = r.nextInt();
        codigo = Math.abs(codigo);
        System.out.println("Seu código de recuperação: ");
        System.out.println(codigo);
        return codigo;
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

    public int getCodigoRecuperacao() {
        return codigoRecuperacao;
    }

    public void setCodigoRecuperacao(int codigoRecuperacao) {
        this.codigoRecuperacao = criaCodigo();
    }

    public boolean equals(Conta c){
        if(this.login.equals(c.getLogin())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "login: '" + login + '\'' +
                ", nome: '" + nome + '\'' +
                ", senha: '" + senha + '\'' +
                ", codigoRecuperacao: " + codigoRecuperacao +
                '}';
    }
}