package InterfaceGrafica;

import java.util.Locale;
import java.util.Scanner;
import Logica.*;

public class SignUp {

    // Interface de criação de conta
    public static void main(SocialNetwork unikut) {
        Scanner input = new Scanner(System.in);
        String nome, login, senha;
        char nameOptionInput;

        System.out.println("\nCriação de conta");

        // Solicita um login ao usuario
        System.out.println("Insira um Login");
        login = input.next();
        input.nextLine();

        // Força o usuario a inserir um login que não foi utilizado
        while (unikut.search(login) != null) {
            System.out.println("O login informado já está sendo usado :/");
            Addons.delay(350);
            System.out.println("Insira um login: ");
            login = input.next();
        }

        // Solicita uma senha ao usuario
        System.out.println("Insira uma Senha ");
        senha = input.next();
        input.nextLine();

        // Pergunta se o usuario deseja adicionar um nome
        System.out.println("Deseja inserir o nome? \n S/N");
        nameOptionInput = input.next().toLowerCase(Locale.ROOT).charAt(0);
        input.nextLine();

        // Força o usuario a inserir apenas S ou N em nameOptionInput
        while (nameOptionInput != 's' && nameOptionInput != 'n') {
            System.out.println("Oops, o caracter inserido deve ser [S] ou [N] (not case sensetive)");
            Addons.delay(350);
            System.out.println("Deseja inserir o nome \n S/N");
            nameOptionInput = input.next().toLowerCase(Locale.ROOT).charAt(0);
            input.nextLine();
        }

        // Logica para vincular um nome a conta ou definir nome como "convidado"
        if (nameOptionInput == 's') {
            System.out.println("Insira o nome");
            nome = input.nextLine();
        } else {
            nome = "convidado";
        }

        System.out.println("Conta criada com sucesso! use suas credenciais para fazer login na proxima vez :)");
        Addons.delay(2);

        // Metodo para criar a conta
        unikut.createAccount(nome, login, senha);
    }

}