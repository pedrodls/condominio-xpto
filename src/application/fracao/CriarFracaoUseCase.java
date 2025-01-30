package application.fracao;

import domain.fracao.Fracao;

public class CriarFracaoUseCase {

  private Fracao fracaoNova;
  private FracaoDTO dadosNovos;

  public CriarFracaoUseCase(FracaoDTO dadosNovos) {
    this.dadosNovos = dadosNovos;
    this.fracaoNova = new Fracao();

  }

  public Fracao validar() throws RuntimeException {

    try {

      if (dadosNovos.area > 0)
        this.fracaoNova.setArea(dadosNovos.area);

      if (dadosNovos.localizacao.length() > 0)
        this.fracaoNova.setLocalizacao(dadosNovos.localizacao);

      if (dadosNovos.proprietario != null)
        this.fracaoNova.setProprietario(dadosNovos.proprietario);

      return this.fracaoNova;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
