package domain.condominio;

import java.time.LocalDate;
import domain.helpers.Entidade;

public class Condominio extends Entidade implements ICondominio {

    private String morada;
    private double despesaGeral;
    private double despesaComElevador;
    private LocalDate dataConstrucao;

    private static long areaTotal;
    private static int numeroFracoes;

    public Condominio() {
    }

    public Condominio(String morada, double despesaGeral, double despesaComElevador, LocalDate dataConstrucao,
            long areaTotal, int numeroFracoes) {
        this.morada = morada;
        this.despesaGeral = despesaGeral;
        this.despesaComElevador = despesaComElevador;
        this.dataConstrucao = dataConstrucao;
        Condominio.areaTotal = areaTotal;
        Condominio.numeroFracoes = numeroFracoes;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public double getDespesaGeral() {
        return this.despesaGeral;
    }

    public void setDespesaGeral(double despesaGeral) {
        this.despesaGeral = despesaGeral;
    }

    public double getDespesaComElevador() {
        return this.despesaComElevador;
    }

    public void setDespesaComElevador(double despesaComElevador) {
        this.despesaComElevador = despesaComElevador;
    }

    public int getNumeroFracoes() {
        return numeroFracoes;
    }

    public long getAreaTotal() {
        return areaTotal;
    }

    public LocalDate getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(LocalDate dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public void setAreaTotal(long areaTotal) {
        Condominio.areaTotal += areaTotal;
    }

    public void setNumeroFracoes(int numeroFracoes) {
        Condominio.numeroFracoes += numeroFracoes;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tmorada: " + this.getMorada() + "\n" +
                "\tdespesaGeral: " + this.getDespesaGeral() + "\n" +
                "\tdespesaComElevador: " + this.getDespesaComElevador() + "\n" +
                "\tdataDeConstrucao: " + this.getDataConstrucao() + "\n" +
                "\tareaTotal: " + areaTotal + "\n" +
                "\tnumeroFracoes: " + numeroFracoes + "\n" +
                "}";
    }

}