/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.fracao.apartamento.useCases;

import application.fracao.apartamento.ApartamentoDTO;
import domain.fracao.apartamento.Apartamento;

public class AtualizarApartamentoUseCase {
    
    private Apartamento apartamento;
    private ApartamentoDTO dadosPorAtualizar;
    
    public AtualizarApartamentoUseCase (Apartamento apartamento, ApartamentoDTO dadosPorAtualizar) {
        
        this.apartamento = apartamento;
        this.dadosPorAtualizar = dadosPorAtualizar;
        
    }
    
    public Apartamento validar() throws RuntimeException {
    
        try{
            if (apartamento == null)
                throw new RuntimeException("Apartamento não encontrado!");
            if (dadosPorAtualizar.area > 0)
                this.apartamento.setArea(dadosPorAtualizar.area);
        
            if (dadosPorAtualizar.localizacao.length() > 0)
                this.apartamento.setLocalizacao(dadosPorAtualizar.localizacao);

            if (dadosPorAtualizar.proprietario != null)
                this.apartamento.setProprietario(dadosPorAtualizar.proprietario);
            
            this.apartamento.setTipo(dadosPorAtualizar.tipo);
            this.apartamento.setNumeroCasaBanhos(dadosPorAtualizar.numeroCasaBanhos);
            this.apartamento.setNumeroVarandas(dadosPorAtualizar.numeroVarandas);
            this.apartamento.setTerraco(dadosPorAtualizar.terraco);
            
            return this.apartamento;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
    }
    
}
