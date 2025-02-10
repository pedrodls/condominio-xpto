package domain.fracao.arrecadacao;

import domain.fracao.Fracao;
import domain.proprietario.Proprietario;

public class Arrecadacao extends Fracao {

    private boolean portaBlindada;
    final static String tipoFracao = "Arrecadação";

    //Para criar um objecto Nulo
    public Arrecadacao() {
        super();
    }

    public Arrecadacao(int area, String localizacao, Proprietario proprietario,
            boolean portaBlindada) {

        super(area, localizacao, proprietario);
        this.portaBlindada = portaBlindada;

    }

    public boolean hasPortaBlindada() {
        return portaBlindada;
    }

    public void setPortaBlindada(boolean isPortaBlindada) {
        this.portaBlindada = isPortaBlindada;
    }

    @Override
    public String toString() {
        String temp;

        if(hasPortaBlindada() == true){
            temp = "Sim";
        } else { temp = "Não"; }

        return super.toString() +
                "\tPossui porta blindada: " + temp + "\n" +
                "\tTipo de fracção : " + tipoFracao + "\n" +
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
