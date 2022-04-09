package Logica;
import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>();


    private boolean isEmpty(){
        return this.contas.size() == 0;
    }

    private boolean verifyLogin(Conta c){

        for (Conta conta : contas) {
            if (conta.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public Conta login(String login){
        int s = search(login);
        if(s == -1){
            return null;
        }
        return contas.get(s);
    }

    public int search(String login){
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

    public void newAccount(String nome, String login, String senha){

        Conta c;
        c = new Conta(nome, login, senha);

        if(isEmpty()){
            contas.add(c);
        }else{
            if(verifyLogin(c)){
                System.out.println("Login em uso");
            }else{
                contas.add(c);
            }

        }

    }

    public void exibirContas(){
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }
    public int getSize(){
        return contas.size();
    }
}
