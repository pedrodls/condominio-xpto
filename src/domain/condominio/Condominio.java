package domain.condominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.fracao.Fracao;
import domain.helpers.Entidade;

public class Condominio extends Entidade implements ICondominio {

    private String morada;
    private double areaTotal;
    private double despesaGeral;
    private double despesaComElevador;
    private LocalDate dataConstrucao;
    private List<Fracao> fracoes;

    public Condominio() {
        this.fracoes = new ArrayList<>();
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

    public List<Fracao> getFracoes() {
        return fracoes;
    }

    public void setPercentagemFracoes() throws RuntimeException {
        try {
            if (this.fracoes.size() > 0) {
                for (Fracao fracao : fracoes) {
                    fracao.setPercentagemArea((fracao.getArea() / this.areaTotal) * 100);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fracao addFracao(Fracao fracao) throws RuntimeException {
        try {
            this.fracoes.add(fracao);
            this.areaTotal += fracao.getArea();
            this.setPercentagemFracoes();

            return fracao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean retirarFracao(int id) throws RuntimeException {
        try {

            Fracao fracaoRemovida = this.fracoes.remove(id);
            this.areaTotal -= fracaoRemovida.getArea();
            this.setPercentagemFracoes();

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fracao buscarFracao(int id) throws RuntimeException {
        try {

            return this.fracoes.get(id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fracao atualizarFracao(Fracao fracaoAtualizada) throws RuntimeException {
        try {

            this.fracoes.set(fracaoAtualizada.getId(), fracaoAtualizada);

            return fracaoAtualizada;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
}