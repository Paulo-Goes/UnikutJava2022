package Logica;

import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>();


    // Função para verificar credenciais de login
    public Conta login(String login, String senha) {
        Conta acc = search(login);
        if (acc == null) {
            return null;
        } else {
            if (acc.getSenha().equals(senha)) {
                return acc;
            }
        }

        return null;
    }

    // Função para procurar uma conta
    public Conta search(String login) {

        for (Conta conta : contas) {
            if (conta.getLogin().equals(login)) {
                return conta;
            }
        }
        return null;
    }

    // Metodo para inserir a conta na lista
    public void newAccount(String nome, String login, String senha) {

        Conta newACC = new Conta(nome, login, senha);
        contas.add(newACC);

    }

    // Meotodo para exibir as contas cadastradas
    public void exibirContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

}
