package domain.fracao.arrecadacao;

import domain.fracao.Fracao;
import domain.proprietario.Proprietario;

public class Arrecadacao extends Fracao {

    private boolean portaBlindada;

    //Para criar um objecto Nulo
    public Arrecadacao() {
        super();
    }

    public Arrecadacao(int area, String localizacao, Proprietario proprietario,
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

    @Override
    public String toString() {
        return super.toString() +
                "\tportaBlindada: " + this.portaBlindada + "\n" +
                "}";
    }

    @Override
    public boolean equals(Object obj) {

        boolean temp = super.equals(obj);

        if (temp && obj instanceof Arrecadacao){
            Arrecadacao other = (Arrecadacao) obj;

            if (portaBlindada != other.portaBlindada)
                return false;
            return true;
        }

        return false;  
        
    }
}
