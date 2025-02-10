/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.fracao.garagem;

import domain.fracao.garagem.Garagem;

public class AtualizarGaragemUseCase {
    
    private Garagem garagem;
    private GaragemDTO dadosPorAtualizar;
    
    public AtualizarGaragemUseCase (Garagem garagem, GaragemDTO dadosPorAtualizar) {
        
        this.garagem = garagem;
        this.dadosPorAtualizar = dadosPorAtualizar;
        
    }
    
    public Garagem validar() throws RuntimeException {
    
        try{
            if (garagem == null)
                throw new RuntimeException("Garagem não encontrado!");
            if (dadosPorAtualizar.area > 0)
                this.garagem.setArea(dadosPorAtualizar.area);
        
            if (dadosPorAtualizar.localizacao.length() > 0)
                this.garagem.setLocalizacao(dadosPorAtualizar.localizacao);

            if (dadosPorAtualizar.proprietario != null)
                this.garagem.setProprietario(dadosPorAtualizar.proprietario);
            
            this.garagem.setNumeroViaturas(dadosPorAtualizar.numeroViaturas);
            this.garagem.setServicoDeLavagem(dadosPorAtualizar.servicoDeLavagem);
            
            return this.garagem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
    }
}
