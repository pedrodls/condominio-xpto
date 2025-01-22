package application.fracao.useCases;

import application.fracao.FracaoDTO;
import domain.fracao.Fracao;

public class CriarFracaoUseCase {

  private Fracao fracao;
  private FracaoDTO dados;

  public CriarFracaoUseCase(FracaoDTO dados) {
    this.dados = dados;
  }

  public Fracao getFracao() throws RuntimeException {

    try {

      if (dados.area <= 0)
        throw new RuntimeException("A área não pode ser zero ou negativa");

      if (dados.localizacao.length() < 0)
        throw new RuntimeException("A localização não pode ser vazia");

      if (dados.proprietario == null)
        throw new RuntimeException("O Proprietário não pode ser nulo");

      // this.arrecadacao = new Loja(dados.area, 0.0, dados.localizacao, );
      // linha acima comentada pq falta o ultimo parametro, o proprietario

      this.fracao.setArea(dados.area);
      this.fracao.setLocalizacao(dados.localizacao);
      this.fracao.setProprietario(dados.proprietario);

      return this.fracao;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
