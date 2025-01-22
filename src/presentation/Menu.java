package presentation;

import java.util.Scanner;

public class Menu implements IMenu {

    private String[] menus;
    private int escolha;
   
    Scanner sc;

    public Menu(String[] opcoes, String descricao) {
        this.menus = opcoes;
        System.out.println("--" + descricao + "--");
    }

    public int getEscolha() {
        return escolha;
    }

    private void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    public void renderizarMenu() throws RuntimeException {

        int opcao = -1;

        sc = new Scanner(System.in);

        try {

            for (int i = 0; i < menus.length; i++) {
                System.out.println(i + 1 + " - " + menus[i]);
            }

            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();

            if (opcao > menus.length || opcao < 0)
                throw new RuntimeException();

            this.setEscolha(opcao);

        } catch (RuntimeException e) {

            System.out.flush();

            System.out.println("Erro na escolha da opção...");

            this.renderizarMenu();

        }
    }
}
