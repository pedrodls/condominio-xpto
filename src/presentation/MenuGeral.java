package presentation;

import domain.condominio.Condominio;
import infrastructure.Persistente;
import presentation.controllers.CondominioController;
import utils.Constantes;
import utils.PauseToRead;

public class MenuGeral {

    private Condominio condominio;

    public MenuGeral() {
        this.condominio = null;
    }

    public MenuGeral(Condominio condominio) {
        this.condominio = condominio;
    }

    private void salvarDados() {
        // SALVAR COISAS NO DOCUMENTO AQUI
        new Persistente<Condominio>().set(this.condominio);
    }

    public void renderizarMenuInicial() throws RuntimeException {

        Menu opcoes = new Menu(Constantes.novoCondominioMenu, "Menu Geral");

        int opcao = opcoes.escolherOpcaoMenu();

        switch (opcao) {
            case 1:
                this.condominio = CondominioController.criar();
                // this.salvarDados();
                System.out.flush();
                PauseToRead.pause();
                new MenuGeral(condominio).renderizarMenu();
            case 2:

                if (this.condominio != null)
                    this.salvarDados();

                System.out.println("Até a próxima :)");

                System.exit(0);
                break;
            default:
                opcao = opcoes.escolherOpcaoMenu();
        }
    }

    public void renderizarMenu() {

        Menu opcoes = new Menu(Constantes.condominioMenu, "Menu Geral");

        int opcao = opcoes.escolherOpcaoMenu();

        switch (opcao) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:
                System.out.println("Até a próxima :)");

                // this.salvarDados();

                System.exit(0);
                break;
            default:
                opcao = opcoes.escolherOpcaoMenu();
        }
    }

}
