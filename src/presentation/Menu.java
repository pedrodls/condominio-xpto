package presentation;

import java.util.Scanner;

public class Menu {

    private String[] menus;

    public Menu(String[] opcoes, String descricao) {
        this.menus = opcoes;
        System.out.println("--" + descricao + "--");
    }

    public char escolherOpcaoMenu() throws RuntimeException {

        char opcao;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < menus.length; i++) {
            System.out.println((i + 1) + " - " + menus[i]);
        }

        System.out.print("Escolha uma opção: ");

        opcao = sc.next().charAt(0);

        
        return opcao;
    }
}
