package domain.condominio;

import java.time.LocalDate;


import domain.fracao.IFracao;
import domain.helpers.Entidade;

public class Condominio extends Entidade implements ICondominio {

    private String morada;
    private double dispesaGeral;
    private LocalDate dataConstrucao;
    private double dispesaComElevador;
    // private ArrayList<IFracao> fracoes;
    // private static int numeroFracoes = 0;

     public Condominio() {
    }
     
    public Condominio(String morada, double dispesaGeral, double dispesaComElevador,
            /* ArrayList<IFracao> fracoes, */ LocalDate dataConstrucao) {
        this.morada = morada;
        this.dispesaGeral = dispesaGeral;
        this.dispesaComElevador = dispesaComElevador;
        this.dataConstrucao = dataConstrucao;
        // this.fracoes = fracoes;
        // Condominio.numeroFracoes = fracoes.size();
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public double getDispesaGeral() {
        return dispesaGeral;
    }

    public void setDispesaGeral(double dispesaGeral) {
        this.dispesaGeral = dispesaGeral;
    }

    public double getDispesaComElevador() {
        return dispesaComElevador;
    }

    public void setDispesaComElevador(double dispesaComElevador) {
        this.dispesaComElevador = dispesaComElevador;
    }

    /*
     * public void setFracoes(ArrayList<IFracao> fracoes) {
     * this.fracoes = fracoes;
     * }
     * 
     * public ArrayList<IFracao> getFracoes() {
     * return this.fracoes;
     * }
     */

    /*
     * public int getNumeroFracoes() {
     * return numeroFracoes;
     * }
     */

    public LocalDate getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(LocalDate dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public void listarFracoes() {

    }

    public void addFracao(IFracao fracao) {

    }

    public void eliminarFracao(String id) {

    }

    public void procurarFracao(String id) {
    }

    public boolean verificarEquilibrio() {
        return false;
    }

    public double somaPercentagemFracoes() {
        return 0;
    }

    public double somaQuotaMensal() {
        return 0;
    }

}