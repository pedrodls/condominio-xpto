/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.fracao.apartamento;

import domain.fracao.apartamento.Apartamento;

public class CriarApartamentoUseCase {
    
    private Apartamento apartamento;
    private ApartamentoDTO dados;
    
    public CriarApartamentoUseCase (ApartamentoDTO dados) {
        
      this.apartamento = new Apartamento();
        this.dados = dados;
        
    }
    
    public Apartamento getApartamento() throws RuntimeException {

        try {

          if (dados.area <= 0)
            throw new RuntimeException("A área não pode ser zero ou negativa");

          if (dados.localizacao.length() < 0)
            throw new RuntimeException("A localização não pode ser vazia");

          if (dados.proprietario == null)
            throw new RuntimeException("O Proprietário não pode ser nulo");

          this.apartamento.setArea(dados.area);
          this.apartamento.setLocalizacao(dados.localizacao);
          this.apartamento.setProprietario(dados.proprietario);
          this.apartamento.setTipo(dados.tipo);
          this.apartamento.setNumeroCasaBanhos(dados.numeroCasaBanhos);
          this.apartamento.setNumeroVarandas(dados.numeroVarandas);
          this.apartamento.setTerraco(dados.terraco);

          return this.apartamento;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
    }
}
