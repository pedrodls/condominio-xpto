package presentation;

import java.text.ParseException;

import domain.condominio.Condominio;
import infrastructure.Persistente;
import presentation.controllers.condominio.*;
import presentation.controllers.fracao.FracaoController;
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
        // System.out.println("Dados salvos com sucesso!");
    }

    public void renderizarMenuInicial() throws RuntimeException, ParseException {

        String opcao;

        do {

            Menu opcoes = new Menu(Constantes.NOVO_CONDOMINIO_MENU, "Menu Inicial");

            opcao = opcoes.escolherOpcaoMenu();

            switch (opcao) {
                case "1":
                    this.condominio = CriarCondominioController.criar();
                    this.renderizarMenu();
                    return;
                case "2":
                    System.out.println("Até a próxima :)");
                    return; // Encerra o método de forma segura
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (true);

        // this.renderizarMenu();
    }

    public void renderizarMenu() throws RuntimeException, ParseException {

        boolean naoSair = true;
        
        String opcao;


        do {

            opcao = new Menu(Constantes.CONDOMINIO_MENU, "Menu Geral").escolherOpcaoMenu();

            switch (opcao) {
                case "1": 
                    FracaoController.visualizar(condominio);
                    break; 
                case "2": 
                    this.condominio = AtualizarCondominioController.atualizar(this.condominio);
                    break;
                case "3":  
                    VisualizarCondominioController.visualizar(this.condominio);
                    break;
                case "4":
                    VisualizarDespesasController.visualizar(condominio);
                    break;
                case "5": 
                    AtualizarDespesasController.visualizar(condominio);
                    break;
                case "6":
                    CalcularQuotasMensaisController.visualizar(condominio);
                    break;
                case "7": 
                    VerificarPercentagenFracoesController.visualizar(condominio);
                    break;
                case "8": 
                    condominio = null;
                    System.out.println("Condomínio excluído com sucesso! 9\n");
                    new MenuGeral().renderizarMenuInicial();
                    break;
                case "9":
                    salvarDados();
                    System.out.println("Até a próxima :)");
                    naoSair = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (naoSair || opcao != "8"); 
    }
}
