package presentation;

import presentation.controllers.condominio.CondominioController;
import utils.Limpatela;

public class MenuCondominio extends Menu {

    private static String[] menus = new String[] { "Criar", "Ver", "Atualizar", "Sair" };

    public MenuCondominio() {
        super(menus, "Menu Condominio");
    }

    public void validarOpcao() {

        this.renderizarMenu();

        int opcao = this.getEscolha();

        switch (opcao) {
            case 1:
                CondominioController.criar();
            case 4:
                new MenuGeral().validarOpcao();
                break;
            default:
                this.validarOpcao();
        }
    }

}
