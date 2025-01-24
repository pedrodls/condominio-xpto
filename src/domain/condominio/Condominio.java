package domain.condominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.fracao.Fracao;
import domain.helpers.Entidade;

public class Condominio extends Entidade implements ICondominio {

    private String morada;
    private double despesaGeral;
    private double despesaComElevador;
    private LocalDate dataConstrucao;
   

    private List<Fracao> fracoes;
    private double areaTotal;
    

    public Condominio() {
    }

    public Condominio(String morada, double despesaGeral, double despesaComElevador, LocalDate dataConstrucao,
            double areaTotal, int numeroFracoes) {
        this.morada = morada;
        this.despesaGeral = despesaGeral;
        this.despesaComElevador = despesaComElevador;
        this.dataConstrucao = dataConstrucao;
        this.fracoes = new ArrayList<>();
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

    public double getAreaTotal() {
        return areaTotal;
    }

    public LocalDate getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(LocalDate dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tmorada: " + this.getMorada() + "\n" +
                "\tdespesaGeral: " + this.getDespesaGeral() + "\n" +
                "\tdespesaComElevador: " + this.getDespesaComElevador() + "\n" +
                "\tdataDeConstrucao: " + this.getDataConstrucao() + "\n" +
                "\tareaTotal: " + areaTotal + "\n" +
                "\tnumeroFracoes: " + this.fracoes.size() + "\n" +
                "}";
    }

    public void addFracao(Fracao fracao){
        this.fracoes.add(fracao);

        //implementa o método addFracao nos usesCases do proprietario, é só pôr a linha 83 desse
        fracao.getProprietario().addFracao(fracao);

        this.areaTotal += fracao.getArea();
        this.setPercentagemFracoes();
    }

    public boolean retirarFracao(Fracao fracao){
        int temp = -1;

        for (int i = 0; i < (fracoes.size() - 1); i++) {
            if(fracoes.get(i).getId() == fracao.getId()){
                temp = i; break;
            }
        }

        if (temp != -1) {
            fracoes.get(temp).getProprietario().retirarFracao(fracoes.get(temp)); //implementa só essa de retirar tmbm
            areaTotal -= fracoes.get(temp).getArea();
            fracoes.remove(temp);
            this.setPercentagemFracoes();
            return true;
        }

        return false;

    }

    public void setPercentagemFracoes(){
        for (Fracao fracao : fracoes) {
            fracao.setPercentagemArea((fracao.getArea() / this.areaTotal) * 100);
        }
    }

    public List<Fracao> getFracoes() {
        return fracoes;
    }

}