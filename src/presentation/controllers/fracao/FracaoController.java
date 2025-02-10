package presentation.controllers.fracao;

import java.text.ParseException;

import domain.condominio.Condominio;
import presentation.Menu;
import utils.Constantes;

public class FracaoController {

    public static void visualizar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            boolean naoSair = true;

            do {

                char opcao = new Menu(Constantes.MENU_FRACAO, "Menu Fração").escolherOpcaoMenu();

                switch (opcao) {
                    case '1':
                        VerFracaoController.visualizar(condominio);
                        break;
                    case '2':
                        TipoFracaoController.visualizar(condominio);
                        break;
                    case '3':

                        break;
                    case '6':
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
