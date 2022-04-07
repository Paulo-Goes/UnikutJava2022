package Logica;
import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>();
    Conta c;

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

    public Conta search(String login, int codigo){
        for(int i = 0;i < contas.size();i++){
            if(contas.get(i).getLogin().equals(login)){
                return
            }
        }
    }

    public void newAccount(Conta c){

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
}
