package domain.condominio;

import java.util.ArrayList;
import java.util.List;

import domain.fracao.Fracao;
import domain.helpers.Entidade;
import domain.proprietario.Proprietario;

public class Condominio extends Entidade implements ICondominio {

    private String morada;
    private double areaTotal;
    private double despesaGeral;
    private double despesaComElevador;
    private String dataConstrucao;
    private List<Fracao> fracoes;
    private List<Proprietario> proprietarios;

    public Condominio() {

    }

    public Condominio(String morada, double despesaGeral, double despesaComElevador, String dataConstrucao,
            double areaTotal, int numeroFracoes) {

        this.morada = morada;
        this.despesaGeral = despesaGeral;
        this.despesaComElevador = despesaComElevador;
        this.dataConstrucao = dataConstrucao;
        this.fracoes = new ArrayList<>();
        this.proprietarios = new ArrayList<>();
        this.areaTotal = 0.0;
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

    public String getDataConstrucao() {
        return dataConstrucao;
    }

    public void setDataConstrucao(String dataConstrucao) {
        this.dataConstrucao = dataConstrucao;
    }

    public List<Proprietario> getProprietarios() {
        return this.proprietarios;
    }

    public List<Fracao> getFracoes() {
        return this.fracoes;
    }

    private boolean validarExistenciaProprietario(Proprietario proprietario) {
        return this.proprietarios.indexOf(proprietario) > 0;
    }

    private boolean validarEliminacaoProprietario(Proprietario proprietario) {

        long countFractions = this.fracoes.stream()
                .filter(f -> f.getProprietario().equals(proprietario))
                .count();

        return countFractions == 1;
    }

    public Fracao addFracao(Fracao fracao) throws RuntimeException {
        try {
            this.fracoes.add(fracao);
            this.areaTotal += fracao.getArea();
            this.setPercentagemFracoes();
            if (!this.validarExistenciaProprietario(fracao.getProprietario())) {
                this.proprietarios.add(fracao.getProprietario());
            }
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
            if (this.validarEliminacaoProprietario(fracaoRemovida.getProprietario())) {
                this.proprietarios.remove(fracaoRemovida.getProprietario().getId());
            }
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

            this.proprietarios.set(fracaoAtualizada.getProprietario().getId(), fracaoAtualizada.getProprietario());

            return fracaoAtualizada;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listFracoes() {
        System.out.println("----------Fracções que compõem o condomínio----------");
        System.out.println(" ");

        for (Fracao fracao : fracoes) {
            System.out.println(fracao);
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public void setPercentagemFracoes() throws RuntimeException {
        try {
            if (this.fracoes != null && this.fracoes.size() > 0) {
                for (Fracao fracao : fracoes) {
                    fracao.setPercentagemArea((fracao.getArea() / this.areaTotal) * 100);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double calculateSomaPercentagensFracoes() {

        if (this.fracoes == null)
            return 0;

        double temp = 0.0;

        for (Fracao fracao : fracoes) {
            temp += fracao.getPercentagemArea();
        }

        return temp;
    }

    public boolean verificarPercentagensFracoes() {
        return Math.round(calculateSomaPercentagensFracoes()) == 100;
    }

    public double calculateSomaQuotas() {

        if (this.fracoes == null)
        return 0;
        
        double temp = 0.0;

        for (Fracao fracao : fracoes) {
            temp += fracao.getQuotaMensal(despesaGeral, despesaComElevador);
        }

        return temp;
    }

    public boolean verificarSomaQuotas() {
        return this.calculateSomaQuotas() == (despesaGeral + despesaComElevador);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tmorada: " + this.getMorada() + "\n" +
                "\tdespesaGeral: " + this.getDespesaGeral() + "\n" +
                "\tdespesaComElevador: " + this.getDespesaComElevador() + "\n" +
                "\tdataDeConstrucao: " + this.getDataConstrucao() + "\n" +
                "\tareaTotal: " + areaTotal + "\n" +
                "\tnumeroFracoes: " + (this.fracoes == null ? 0 : this.fracoes.size()) + "\n" +
                "}";
    }

}