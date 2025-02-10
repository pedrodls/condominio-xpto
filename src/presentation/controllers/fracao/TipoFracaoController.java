package presentation.controllers.fracao;

import java.text.ParseException;

import domain.condominio.Condominio;
import presentation.Menu;
import utils.Constantes;

public class TipoFracaoController {

    public static void visualizar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            boolean naoSair = true;

            do {

                char opcao = new Menu(Constantes.MENU_TIPO_FRACAO, "Informe o tipo de fracção a inserir")
                        .escolherOpcaoMenu();

                switch (opcao) {
                    case '1':
                        //CriarApartamentoController();
                        break;
                    case '2':
                        CriarArrecadacaoController.criar(condominio);
                        break;
                    case '3':
                        //CriarGaragemController();
                        break;
                    case '4':
                        //CriarLojaController();
                        break;
                    case '5':
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
