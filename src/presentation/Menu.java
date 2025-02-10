package presentation;

import java.util.Scanner;

public class Menu {

    private String[] menus;

    public Menu(String[] opcoes, String descricao) {
        this.menus = opcoes;
        System.out.println("--" + descricao + "--");
    }

    public String escolherOpcaoMenu() throws RuntimeException {

        String opcao;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < menus.length; i++) {
            System.out.println((i + 1) + " - " + menus[i]);
        }

        System.out.print("\n Escolha uma opção: ");

        opcao = sc.nextLine();

        System.out.println(" ");

        
        return opcao;
    }
}
