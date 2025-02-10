package domain.fracao.garagem;

import domain.fracao.Fracao;
import domain.proprietario.Proprietario;

public class Garagem extends Fracao {

    private int numeroViaturas;

    private boolean servicoDeLavagem;

    // Para criar um objecto Nulo
    public Garagem() {
        super();
    }

    public Garagem(int area, String localizacao, Proprietario proprietario, int numeroViaturas,
            boolean servicoDeLavagem) {

        super(area, localizacao, proprietario);
        this.numeroViaturas = numeroViaturas;
        this.servicoDeLavagem = servicoDeLavagem;

    }

    public int getNumeroViaturas() {
        return numeroViaturas;
    }

    public void setNumeroViaturas(int numeroViaturas) {
        this.numeroViaturas = numeroViaturas;
    }

    public boolean getServicoDeLavagem() {
        return servicoDeLavagem;
    }

    public void setServicoDeLavagem(boolean servicoDeLavagem) {
        this.servicoDeLavagem = servicoDeLavagem;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tnumeroDeViaturas: " + this.numeroViaturas + "\n" +
                "\tserviçoDeLavagem: " + this.servicoDeLavagem != null ? "Sim"
                        : "Não" + "\n" +
                                "}";
    }
}
