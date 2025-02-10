package presentation.controllers.condominio;

import domain.condominio.Condominio;
import utils.PauseToRead;

public class VisualizarCondominioController {

    public static void visualizar(Condominio condominio) throws RuntimeException {

        try {

            System.out.println(" -- Dados do Condominio -- ");
            System.out.println(condominio);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
