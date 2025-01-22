package presentation;

public class MenuGeral extends Menu {

    private static String[] menus = new String[] { "Condominio", "Frações", "Proprietários", "Sair" };

    public MenuGeral() {
        super(menus, "Menu Geral");
    }

    public void validarOpcao() {

        this.renderizarMenu();
        int opcao = this.getEscolha();

        switch (opcao) {
            case 1:
                new MenuCondominio().validarOpcao();
            case 4:
                break;
            default:
                this.validarOpcao();
        }
    }

}
