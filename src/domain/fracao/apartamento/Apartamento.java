package domain.fracao.apartamento;

import domain.fracao.Fracao;
import domain.proprietario.Proprietario;

public class Apartamento extends Fracao {

    private TipoApartamento tipo;
    private int numeroCasaBanhos;
    private int numeroVarandas;
    private boolean terraco;

    final static String tipoFracao = "Apartamento";

    // Para criar um objecto Nulo
    public Apartamento() {
        super();
    }

    public Apartamento(int area, String localizacao, Proprietario proprietario, TipoApartamento tipo,
            int numeroCasaBanhos, int numeroVarandas, boolean terraco) {
        super(area, localizacao, proprietario);
        this.tipo = tipo;
        this.numeroCasaBanhos = numeroCasaBanhos;
        this.numeroVarandas = numeroVarandas;
        this.terraco = terraco;
    }

    public TipoApartamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoApartamento tipo) {
        this.tipo = tipo;
    }

    public int getNumeroCasaBanhos() {
        return numeroCasaBanhos;
    }

    public void setNumeroCasaBanhos(int numeroCasaBanhos) {
        this.numeroCasaBanhos = numeroCasaBanhos;
    }

    public int getNumeroVarandas() {
        return numeroVarandas;
    }

    public void setNumeroVarandas(int numeroVarandas) {
        this.numeroVarandas = numeroVarandas;
    }

    public boolean isTerraco() {
        return terraco;
    }

    public void setTerraco(boolean terraco) {
        this.terraco = terraco;
    }

    @Override
    public String toString() {
        String temp;

        if(isTerraco() == true){
            temp = "Sim";
        } else { temp = "Não"; }

        return super.toString() +
        "\tTipo de apartamento: " + tipo + "\n" +
        "\tNúmero de casas de banho: " + numeroCasaBanhos + "\n" +
        "\tNúmero de varandas: " + numeroVarandas + "\n" +
        "\tTem terraço: " + temp + "\n" +
        "\tTipo de fracção: " + tipoFracao + "\n" +
        "}";
    }

    @Override
    public boolean equals(Object obj) {

        boolean temp = super.equals(obj);

        if (temp && obj instanceof Apartamento){
            Apartamento other = (Apartamento) obj;

            if (
                tipo != other.tipo &&
                numeroCasaBanhos != other.getNumeroCasaBanhos() &&
                numeroVarandas != other.getNumeroVarandas() &&
                terraco != other.isTerraco()
                )
                return false;
            return true;
        }

        return false;  
        
    }
}
