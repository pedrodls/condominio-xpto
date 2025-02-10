package application.fracao.arrecadacao;

import domain.fracao.arrecadacao.Arrecadacao;

public class CriarArrecadacaoUseCase {

  private Arrecadacao arrecadacao;
  private ArrecadacaoDTO dados;

  public CriarArrecadacaoUseCase(ArrecadacaoDTO dados) {
    this.dados = dados;
    this.arrecadacao = new Arrecadacao();
  }

  public Arrecadacao validar() throws RuntimeException {

    try {

      if (dados.area <= 0)
        throw new RuntimeException("A área não pode ser zero ou negativa");

      if (dados.localizacao.length() < 0)
        throw new RuntimeException("A localização não pode ser vazia");

      if (dados.proprietario == null)
        throw new RuntimeException("O Proprietário não pode ser nulo");

      // this.arrecadacao = new Loja(dados.area, 0.0, dados.localizacao, );
      // linha acima comentada pq falta o ultimo parametro, o proprietario

      this.arrecadacao.setArea(dados.area);
      this.arrecadacao.setLocalizacao(dados.localizacao);
      this.arrecadacao.setProprietario(dados.proprietario);
      this.arrecadacao.setPortaBlindada(dados.portaBlindada);

      return this.arrecadacao;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
