package domain.fracao.arrecadacao;

import domain.fracao.Fracao;
import domain.proprietario.IProprietario;

public class Arrecadacao extends Fracao {

    private boolean portaBlindada;

    //Para criar um objecto Nulo
    public Arrecadacao() {
        super();
    }

    public Arrecadacao(int area, String localizacao, IProprietario proprietario,
            boolean portaBlindada) {

        super(area, localizacao, proprietario);
        this.portaBlindada = portaBlindada;

    }

    public boolean getPortaBlindada() {
        return portaBlindada;
    }

    public void setPortaBlindada(boolean isPortaBlindada) {
        this.portaBlindada = isPortaBlindada;
    }
}
