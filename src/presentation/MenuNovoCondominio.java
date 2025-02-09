package presentation;

import domain.condominio.Condominio;
import presentation.controllers.CondominioController;
import utils.Constantes;

public class MenuNovoCondominio {

    Condominio condominio;

    public MenuNovoCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Condominio validarOpcao() {
        Menu menu = new Menu(Constantes.novoCondominioMenu, "Menu novo Condominio");

        int opcao = menu.escolherOpcaoMenu();

        switch (opcao) {
            case 1:
                this.condominio = CondominioController.criar();
                return this.condominio;
            case 2:
                return this.condominio;
            default:
                return this.validarOpcao();
        }
    }

}
