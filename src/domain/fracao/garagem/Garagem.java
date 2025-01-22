package domain.fracao.garagem;

import domain.fracao.Fracao;
import domain.proprietario.IProprietario;

public class Garagem extends Fracao {

    private int numeroViaturas;

    private boolean servicoDeLavagem;

    public Garagem(int area, String localizacao, IProprietario proprietario, int numeroViaturas, boolean servicoDeLavagem) {

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
}
