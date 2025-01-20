package domain.fracao.arrecadacao;

import domain.fracao.Fracao;
import domain.proprietario.IProprietario;

public class Arrecadacao extends Fracao {

    private boolean portaBlindada;

    public Arrecadacao(int area, float percentagemArea, String localizacao, IProprietario proprietario,
            boolean portaBlindada) {

        super(area, percentagemArea, localizacao, proprietario);
        this.portaBlindada = portaBlindada;

    }

    public boolean getPortaBlindada() {
        return portaBlindada;
    }

    public void setPortaBlindada(boolean isPortaBlindada) {
        this.portaBlindada = isPortaBlindada;
    }
}
