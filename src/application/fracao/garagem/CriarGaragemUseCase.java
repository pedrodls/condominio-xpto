/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.fracao.garagem;

import domain.fracao.garagem.Garagem;

public class CriarGaragemUseCase {

  private Garagem garagem;
  private GaragemDTO dados;

  public CriarGaragemUseCase(GaragemDTO dados) {

    this.garagem = new Garagem();
    this.dados = dados;

  }

  public Garagem getGaragem() throws RuntimeException {

    try {

      if (dados.area <= 0)
        throw new RuntimeException("A área não pode ser zero ou negativa");

      if (dados.localizacao.length() < 0)
        throw new RuntimeException("A localização não pode ser vazia");

      if (dados.proprietario == null)
        throw new RuntimeException("O Proprietário não pode ser nulo");

      this.garagem.setArea(dados.area);
      this.garagem.setLocalizacao(dados.localizacao);
      this.garagem.setProprietario(dados.proprietario);
      this.garagem.setNumeroViaturas(dados.numeroViaturas);
      this.garagem.setServicoDeLavagem(dados.servicoDeLavagem);

      return this.garagem;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
