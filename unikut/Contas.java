package p3_UNIKUT.unikut;

import java.util.ArrayList;

public class Contas {
    private ArrayList<Conta> contas = new ArrayList<>();

    private boolean isEmpty(){
        if(this.contas.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    private boolean verifyLogin(Conta c){

        for(int i = 0; i < contas.size() - 1; i++){
            if(contas.get(i).equals(c)){
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
        for(int i = 0; i < contas.size() - 1; i++){
            System.out.println(contas.get(i));
        }
    }
}
