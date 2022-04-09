package InterfaceGrafica;

import java.util.Scanner;
import Logica.Contas;

public class SignUp {
    public static void criarContaUI(Contas contas) {

        Scanner input = new Scanner(System.in);
            String nome, login, senha;
            char nameOptionInput;

            System.out.println("Insira um Login");
            login = input.next();
            input.nextLine();
            while (!contas.checkLoginDisponibility(login)) {
                System.out.println("O login informado já está em uso, informe outro login");
                login = input.next();
            }

            System.out.println("Insira uma Senha ");
            senha = input.next();
            input.nextLine();

            System.out.println("Deseja inserir o nome? \n S/N");
            nameOptionInput = input.next().charAt(0);
            input.nextLine();
            nameOptionInput = Character.toLowerCase(nameOptionInput);
            while (nameOptionInput != 's' && nameOptionInput != 'n') {
                System.out.println("Oops, o caracter inserido deve ser [S] ou [N] (not case sensetive)");
                nameOptionInput = input.next().charAt(0);
                Character.toLowerCase(nameOptionInput);
            }

            if (nameOptionInput == 's') {
                System.out.println("Insira o nome");
                nome = input.nextLine();
            } else {
                nome = "convidado";
            }

            contas.newAccount(nome, login, senha);
        

    }

}
