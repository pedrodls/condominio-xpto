package presentation;

import java.util.Scanner;

public class Menu {

    private String[] menus;

    public Menu(String[] opcoes, String descricao) {
        this.menus = opcoes;
        System.out.println("--" + descricao + "--");
    }

    public int escolherOpcaoMenu() throws RuntimeException {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.flush();

            int opcao = -1;

            for (int i = 0; i < menus.length; i++) {
                System.out.println((i + 1) + " - " + menus[i]);
            }

            System.out.printf("Escolha uma opção: ");

            opcao = sc.nextInt();

            System.out.flush();
            
            return opcao;

        } catch (RuntimeException e) {

            return -1;

        }
    }
}
