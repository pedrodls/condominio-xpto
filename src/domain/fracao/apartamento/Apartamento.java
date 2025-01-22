package domain.fracao.apartamento;

import domain.fracao.Fracao;
import domain.proprietario.IProprietario;

public class Apartamento extends Fracao{
    
    private TipoApartamento tipo; 
    private int numeroCasaBanhos;
    private int numeroVarandas;
    private boolean terraco;

    public Apartamento(int area, String localizacao, IProprietario proprietario, TipoApartamento tipo, int numeroCasaBanhos, int numeroVarandas, boolean terraco) {
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
}
