package presentation;

import domain.condominio.Condominio;
import infrastructure.Persistente;
import presentation.controllers.condominio.*;
import utils.Constantes;

public class MenuGeral {

    private Condominio condominio;

    public MenuGeral() {
        this.condominio = null;
    }

    public MenuGeral(Condominio condominio) {
        this.condominio = condominio;
    }

    private void salvarDados() {
        if (this.condominio == null) {
            System.out.println("Nenhum condomínio criado. Nada para salvar.");
            return;
        }

        Persistente<Condominio> persistente = new Persistente<>();
        persistente.set(this.condominio);
        System.out.println("Dados salvos com sucesso!");
    }

    public void renderizarMenuInicial() throws RuntimeException {

        char opcao;

        do {

            Menu opcoes = new Menu(Constantes.novoCondominioMenu, "Menu Inicial");

            opcao = opcoes.escolherOpcaoMenu();

            switch (opcao) {
                case '1':
                    this.condominio = CriarCondominioController.criar();
                    this.renderizarMenu();
                    return;
                case '2':
                    System.out.println("Até a próxima :)");
                    return; // Encerra o método de forma segura
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (true);

        // this.renderizarMenu();
    }

    public void renderizarMenu() {

        boolean naoSair = true;

        do {

            char opcao = new Menu(Constantes.condominioMenu, "Menu Geral").escolherOpcaoMenu();

            switch (opcao) {
                case '1':
                    System.out.println("Funcionalidade 1");
                    break;
                case '2':
                    System.out.println("Funcionalidade 2");
                    break;
                case '3':
                    this.condominio = AtualizarCondominioController.atualizar(this.condominio);
                    break;
                case '4':
                    VisualizarCondominioController.visualizar(this.condominio);
                    break;
                case '5':
                    VisualizarDespesasController.visualizar(condominio);
                    break;
                case '6':
                    CalcularCotasMensaisController.visualizar(condominio);
                    break;
                case '7':
                    VerificarPercentagenFracoesController.visualizar(condominio);
                    break;
                case '8':
                    salvarDados();
                    System.out.println("Até a próxima :)");
                    naoSair = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (naoSair);
    }
}
