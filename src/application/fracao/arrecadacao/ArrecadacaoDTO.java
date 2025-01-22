package application.fracao.arrecadacao;

import application.fracao.FracaoDTO;

public class ArrecadacaoDTO extends FracaoDTO {
    
    public  boolean portaBlindada;

    public ArrecadacaoDTO() {
        super();
        this.portaBlindada = false;
    }

    public ArrecadacaoDTO(boolean portaBlindada, long area, double percentagemArea, String localizacao) {
        super(area, localizacao);
        this.portaBlindada = portaBlindada;
    }
}
