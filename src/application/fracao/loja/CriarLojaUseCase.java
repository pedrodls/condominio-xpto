package application.fracao.loja;

import domain.fracao.loja.Loja;

public class CriarLojaUseCase {

  private Loja lojaNova;
  private LojaDTO dados;

  public CriarLojaUseCase(LojaDTO dados) {
    this.dados = dados;
    this.lojaNova = new Loja();
  }

  public Loja validar() throws RuntimeException {

    try {

      if (dados.area > 0)
        this.lojaNova.setArea(dados.area);

      if (dados.localizacao.length() > 0)
        this.lojaNova.setLocalizacao(dados.localizacao);

      if (dados.proprietario != null)
        this.lojaNova.setProprietario(dados.proprietario);

      return this.lojaNova;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
