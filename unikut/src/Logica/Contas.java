package Logica;
import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>(); //"Field Contas may be final"????

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
