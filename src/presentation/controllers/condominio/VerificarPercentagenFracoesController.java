package presentation.controllers.condominio;

import domain.condominio.Condominio;
import utils.PauseToRead;

public class VerificarPercentagenFracoesController {

    public static void visualizar(Condominio condominio) throws RuntimeException {

        try {

            if (condominio.verificarPercentagensFracoes()) {
                System.out.println("A soma das percentagens das fracções é igual a 100%.");
                return;
            }

            System.out.println("A soma das percentagens das fracções é igual a "
                    + condominio.calculateSomaPercentagensFracoes() + "%.");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
