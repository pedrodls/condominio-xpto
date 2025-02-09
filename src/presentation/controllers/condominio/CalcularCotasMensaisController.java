package presentation.controllers.condominio;

import domain.condominio.Condominio;
import utils.PauseToRead;

public class CalcularCotasMensaisController {

    public static void visualizar(Condominio condominio) throws RuntimeException {

        try {

            System.out.println("A soma das cotas mensais é igual a " + condominio.calculateSomaQuotas());
           
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
