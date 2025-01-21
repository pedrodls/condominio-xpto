package application.condominio.useCases;

import java.text.SimpleDateFormat;

import application.condominio.CondominioDTO;
import domain.condominio.Condominio;
import helpers.HelperDate;
import java.time.LocalDate;

public class CriarCondominioUseCase {

    private Condominio condominio;
    private CondominioDTO dados;

    public CriarCondominioUseCase(CondominioDTO dados) {
        this.dados = dados;
        this.condominio = new Condominio();
    }

    public Condominio getCondominio() throws Error {
        
      try {

        this.condominio.setMorada(dados.morada);
        this.condominio.setDataConstrucao(HelperDate.stringToLocalDate(dados.dataConstrucao));
        this.condominio.setDispesaComElevador(dados.dispesaComElevador);
        this.condominio.setDispesaGeral(dados.dispesaGeral);

        return this.condominio;
      } catch (Exception e) {
        throw new Error(e);
      }
    }

    public boolean validarDados() {
        // Basta verificar que um dado tem erro, faz throww
        return false;
    }
}
