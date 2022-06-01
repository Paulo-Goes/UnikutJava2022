package View;

import Model.User;

public class Menus {

    public static void optionsUI(User loggedAccount) {
        System.out.println("\n< > unikut.com/" + loggedAccount.getLogin() + "/edit");
        System.out.println();
        System.out.println("Edição de perfil");
        System.out.println("1 - Alterar nome de exibição");
        System.out.println("2 - Alterar senha");
        System.out.println("0 - Retornar à home");
    }

    public static void mainUI() {
        System.out.println("\n< > unikut.com");
        System.out.println();
        System.out.println("| UNIKUT SOCIAL MEDIA © | ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("0 - Sair");
    }

    // Exibir opções para usuario logado
    public static void loggedUI(User loggedAccount) {
        System.out.println("\n< > unikut.com/Home/\n");
        System.out.println("Ola "+loggedAccount.getNome()+" :)");
        System.out.println("1 - Edição de perfil");
        System.out.println("2 - Adicionar amigos");
        System.out.println("3 - Enviar Depoimento");
        System.out.println("4 - Ver lista de amigos");
        System.out.println("5 - Verificar solicitações de amizade");
        System.out.println("6 - Veriificar caixa de depoimentos");

        System.out.println("0 - Sair");
    }
}
