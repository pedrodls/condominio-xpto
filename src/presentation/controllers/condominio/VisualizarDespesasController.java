package presentation.controllers.condominio;

import domain.condominio.Condominio;
import presentation.Menu;
import utils.Constantes;
import utils.PauseToRead;

public class VisualizarDespesasController {

    public static void visualizar(Condominio condominio) throws RuntimeException {

        try {

            boolean naoSair = true;

            do {

                String opcao = new Menu(Constantes.despesaMenu, "Visualização das Despesas").escolherOpcaoMenu();

                switch (opcao) {
                    case "1":
                        System.out.println("Despesa Geral = " + condominio.getDespesaGeral());
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case "2":
                        System.out.println("Despesa com o elevador = " + condominio.getDespesaComElevador());
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case "3":
                        System.out.println("Despesa Geral = " + condominio.getDespesaGeral());
                        System.out.println("Despesa com o elevador = " + condominio.getDespesaComElevador());
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case "4":
                        naoSair = false;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }

            } while (naoSair);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
