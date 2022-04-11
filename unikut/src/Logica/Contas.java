package Logica;

import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>();

    public int getSize() {
        return contas.size();
    }

    public boolean checkLoginDisponibility(String login) {
        Conta testingAccount = new Conta(login);

        for (Conta conta : contas) {
            if (conta.compareTo(testingAccount) == 0) {
                return false;
            }
        }
        return true;
    }

    public Conta login(String login, String senha) {
        Conta s = search(login);
        if (s.getSenha().equals(senha)) {
            return s;
        }
        return null;
    };

    public Conta search(String login) {

        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);
            if (conta.getLogin().equals(login)) {
                return conta;
            }
        }
        return null;
    }

    public void newAccount(String nome, String login, String senha) {

        Conta newACC = new Conta(nome, login, senha);
        contas.add(newACC);

    }

    public void exibirContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

}
