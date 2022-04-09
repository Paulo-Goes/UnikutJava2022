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

    public Conta login(String login) {
        int s = search(login);
        if (s == -1) {
            return null;
        }
        return contas.get(s);
    }

    public int search(String login) {
        System.out.println("Procurando conta...");
        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);
            if (conta.getLogin().equals(login)) {
                return i;
            }
        }
        System.out.println("Conta não encontrada!");
        return -1;
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
