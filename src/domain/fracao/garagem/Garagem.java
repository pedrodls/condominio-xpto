package domain.fracao.garagem;

import domain.fracao.Fracao;
import domain.proprietario.Proprietario;

public class Garagem extends Fracao {

    private int numeroViaturas;
    private boolean servicoDeLavagem;

    final static String tipoFracao = "Garagem";

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
        "\tNúmero de viaturas: " + numeroViaturas + "\n" +
        "\tServiço de lavagem: " + (servicoDeLavagem ? "Sim" : "Não") + "\n" +
        "\tTipo de fracção : " + tipoFracao + "\n" +
        "}";
    }

    @Override
    public boolean equals(Object obj) {

        boolean temp = super.equals(obj);

        if (temp && obj instanceof Garagem){
            Garagem other = (Garagem) obj;

            if (
                numeroViaturas != other.getNumeroViaturas() &&
                servicoDeLavagem != other.getServicoDeLavagem()
                )
                return false;
            return true;
        }

        return false;  
        
    }

}