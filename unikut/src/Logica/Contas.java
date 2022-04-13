package Logica;

import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>();

       public Conta login(String login, String senha) {
        Conta acc = search(login);
        if(acc == null){
            return null;
        }else{
            if (acc.getSenha().equals(senha)) {
                return acc;
            }
        }
        
        return null;
    }

    public Conta search(String login) {
        
        for (Conta conta : contas) {
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
