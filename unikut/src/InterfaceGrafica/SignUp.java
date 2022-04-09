package InterfaceGrafica;

import java.util.Scanner;
import Logica.Contas;

public class SignUp {
    public static void main(Contas contas) {

        Scanner input = new Scanner(System.in);
        String nome, login, senha;
        char nameOptionInput;

        System.out.println("/Interface de criação de conta/");

        // Solicita um login ao usuario
        System.out.println("Insira um Login");
        login = input.next();
        input.nextLine();

        // Força o usuario a inserir um login disponivel do sistema
        while (!contas.checkLoginDisponibility(login)) {
            System.out.println("O login informado já está em uso, informe outro login");
            login = input.next();
        }

        // Solicita uma senha ao usuario
        System.out.println("Insira uma Senha ");
        senha = input.next();
        input.nextLine();

        // Pergunta se o usuario deseja adicionar um nome
        System.out.println("Deseja inserir o nome? \n S/N");
        nameOptionInput = input.next().charAt(0);
        input.nextLine();
        nameOptionInput = Character.toLowerCase(nameOptionInput);

        // Força o usuario a inserir apenas S ou N em nameOptionInput
        while (nameOptionInput != 's' && nameOptionInput != 'n') {
            System.out.println("Oops, o caracter inserido deve ser [S] ou [N] (not case sensetive)");
            nameOptionInput = input.next().charAt(0);
            Character.toLowerCase(nameOptionInput);
        }

        // Logica para vincular um nome a conta ou definir nome como "convidado"
        if (nameOptionInput == 's') {
            System.out.println("Insira o nome");
            nome = input.nextLine();
        } else {
            nome = "convidado";
        }

        // Metodo para criar a conta
        contas.newAccount(nome, login, senha);
    }

}
