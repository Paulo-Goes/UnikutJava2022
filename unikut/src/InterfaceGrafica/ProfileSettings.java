package InterfaceGrafica;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import Logica.*;

public class ProfileSettings {

    public static void main(Conta editingAccount) {
        Scanner in = new Scanner(System.in);
        char op;

        optionsUI(editingAccount);
      
        do{ 

            op = in.next().charAt(0);
            in.nextLine();
            Character.toLowerCase(op);

            switch(op){
                case '1':
                changeNameUI(editingAccount);
                break;
                default:
                System.out.println("Oops, essa opção ainda não existe :/");
                case '2':
                break;
            }



        }while(op != '0');


    }

    static void optionsUI(Conta loggedAccount){
        System.out.println("< > unikut.com/"+loggedAccount.getLogin()+"/editProfile");
        System.out.println();
        System.out.println();
        System.out.println("Your Profile Settings");
        System.out.println("1 - Alterar nome de exibição");
        System.out.println("2 - Alterar senha");
        System.out.println("0 - Retornar à home");

    }

    static void changeNameUI(Conta loggedAccount){
        Scanner in = new Scanner(System.in);
        String newName;
        int op;

        System.out.println("Insira seu novo nome de exibição ");
        newName = in.nextLine();

        System.out.println("Seu nome de exibição atual é: "+loggedAccount.getNome());
        System.out.println();
        System.out.println("Seu novo nome de exibição será: "+newName);
        Addons.delay(2000);
        System.out.println("1 - Confirmar mudança");
        System.out.println("2 - Descartar mudança");
        op = in.nextInt();

        if(op == 1){
            loggedAccount.setNome(newName);
            System.out.println("Mudança efetuada, "+loggedAccount.getNome()+" :)");
            Addons.delay(1500);
            return;
        }else{
            System.out.println("Nome de exibição mantido.");
            System.out.println("Retornando ao menu...");
            Addons.delay(1500);
            return;
        }


    }

    

   


    
}
