package domain.condominio;

import java.util.ArrayList;
import java.util.Date;

import domain.fracao.IFracao;
import domain.helpers.Entidade;

public class Condominio extends Entidade implements ICondominio {

    private String morada;
    private float dispesaGeral;
    private Date dataConstrucao;
    private float dispesaComElevador;
    private ArrayList<IFracao> fracoes;
    private static int numeroFracoes = 0;

    public Condominio(String morada, float dispesaGeral, float dispesaComElevador,
            ArrayList<IFracao> fracoes, Date dataConstrucao) {
        this.morada = morada;
        this.dispesaGeral = dispesaGeral;
        this.dispesaComElevador = dispesaComElevador;
        this.fracoes = fracoes;
        this.dataConstrucao = dataConstrucao;
        Condominio.numeroFracoes = fracoes.size();
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumeroFracoes() {
        return numeroFracoes;
    }

    public float getDispesaGeral() {
        return dispesaGeral;
    }

    public void setDispesaGeral(float dispesaGeral) {
        this.dispesaGeral = dispesaGeral;
    }

    public float getDispesaComElevador() {
        return dispesaComElevador;
    }

    public void setDispesaComElevador(float dispesaComElevador) {
        this.dispesaComElevador = dispesaComElevador;
    }

    public void setFracoes(ArrayList<IFracao> fracoes) {
        this.fracoes = fracoes;
    }

    public ArrayList<IFracao> getFracoes() {
        return this.fracoes;
    }

    public Date getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(Date dataConstrucao) {
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

    public float somaPercentagemFracoes() {
        return 0;
    }

    public float somaQuotaMensal() {
        return 0;
    }

}