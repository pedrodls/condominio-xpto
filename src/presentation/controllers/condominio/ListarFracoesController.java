package presentation.controllers.condominio;

import domain.condominio.Condominio;
import utils.PauseToRead;

public class ListarFracoesController {

    public static void visualizar(Condominio condominio) throws RuntimeException {

        try {

            if (!(condominio.getAreaTotal() > 0)) {
                System.out.println("Não existem frações disponíveis!");
                return;
            }
            
            condominio.listFracoes();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
