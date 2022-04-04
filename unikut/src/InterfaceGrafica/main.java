package InterfaceGrafica;
import Logica.Conta;
import Logica.Contas;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Character.*;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contas contas = new Contas();
        char op;
        String nome, login, senha;

        do {
            menu();
            op = input.next().toLowerCase(Locale.ROOT).charAt(0);
            while(!isDigit(op)){
                op = input.next().toLowerCase(Locale.ROOT).charAt(0);
            }
            switch(op){
                case '1':
                    System.out.println("/Interface de criação de conta/");
                    System.out.println("Insira o nome");
                    nome = input.nextLine();
                    System.out.println("Insira o Login");
                    login = input.nextLine();
                    System.out.println("Insira a Senha");
                    senha = input.nextLine();

                    System.out.println("Criando conta...");

                    Conta c = new Conta(login, nome, senha);
                    contas.newAccount(c);
                    break;
                case '2':
                    System.out.println("O login será aqui!");
                case '3':
                    System.out.println("Exibindo contas...");

                    contas.exibirContas();
            }
        } while (op != 5);
    }

    public static void menu() {
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("3 - Login (Exibir contas temporario)");
        System.out.println("4 - Recuperar senha");
        System.out.println("5 - Sair");
    }
}