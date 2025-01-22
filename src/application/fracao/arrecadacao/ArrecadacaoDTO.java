package application.fracao.arrecadacao;

import application.fracao.FracaoDTO;
import domain.proprietario.IProprietario;

public class ArrecadacaoDTO extends FracaoDTO {
    
    public  boolean portaBlindada;

    public ArrecadacaoDTO(boolean portaBlindada, int area, String localizacao, IProprietario proprietario){
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
        this.portaBlindada = portaBlindada;
    }
}
