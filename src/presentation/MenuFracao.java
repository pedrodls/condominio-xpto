package presentation;

import presentation.controllers.condominio.CondominioController;

public class MenuFracao extends Menu {
    private static String[] menus = new String[] { "Criar", "Excluir", "Atualizar", "Sair" };

    public MenuFracao() {
        super(menus, "Menu Fracção");
    }

    public void validarOpcao() {

        this.renderizarMenu();

        int opcao = this.getEscolha();

        switch (opcao) {
            case 1:
                FracaoController.criar();
            // case 2:
            //     FracaoController.criar();
            case 3:
                FracaoController.u();
            case 4:
                new MenuGeral().validarOpcao();
                break;
            default:
                this.validarOpcao();
        }
    }
}
