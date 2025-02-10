package application.condominio.useCases;

import application.condominio.CondominioDTO;
import domain.condominio.Condominio;

public class CriarCondominioUseCase {

  private Condominio condominio;
  private CondominioDTO dados;

  public CriarCondominioUseCase(CondominioDTO dados) {
    this.dados = dados;
    this.condominio = new Condominio();
  }

  public Condominio getCondominio() throws RuntimeException {

    try {

      if (!(dados.despesaGeral > 0 && dados.despesaComElevador > 0))
        throw new RuntimeException("Despesas não podem ser zero ou negativas");

      this.condominio.setId(1);
      this.condominio.setMorada(dados.morada);
      this.condominio.setDataConstrucao(dados.dataConstrucao);

      this.condominio.setDespesaComElevador(dados.despesaComElevador);
      this.condominio.setDespesaGeral(dados.despesaGeral);

      return this.condominio;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
