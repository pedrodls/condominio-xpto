package domain.condominio;

import java.time.LocalDate;
import java.util.ArrayList;
import domain.fracao.Fracao;
import domain.helpers.Entidade;

public class Condominio extends Entidade implements ICondominio {

    private String morada;
    private double despesaGeral;
    private double despesaComElevador;
    private LocalDate dataConstrucao;
    private ArrayList<Fracao> fracoes;

    private static long areaTotal;
    private static int numeroFracoes;

    public Condominio() {
    }

    public Condominio(String morada, double despesaGeral, double despesaComElevador, LocalDate dataConstrucao) {
        this.morada = morada;
        this.despesaGeral = despesaGeral;
        this.despesaComElevador = despesaComElevador;
        this.dataConstrucao = dataConstrucao;
        this.fracoes = new ArrayList<>();
        Condominio.areaTotal = 0;
        Condominio.numeroFracoes = 0;
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

    public void setFracoes(ArrayList<Fracao> fracoes) {
        this.fracoes = fracoes;
    }

    public ArrayList<Fracao> getFracoes() {
        return this.fracoes;
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

    public void listarFracoes() {

        if (this.fracoes == null) {
            System.out.println("Lista de Fracoes vazias.");
            return;
        }

        System.out.println("\n-- Listagem de Fracoes do Condominio -- \n");

        this.fracoes.forEach(f -> {
            System.out.println(f.toString());
        });

    }

    public void addFracao(Fracao novaFracao) {
        this.fracoes.add(novaFracao);
        numeroFracoes++;
        areaTotal += novaFracao.getArea();
    }

    public void eliminarFracao(int id) throws RuntimeException {
        try {
            this.fracoes.remove(this.procurarFracao(id));
            System.out.println("Fracao eliminada");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Fracao procurarFracao(int id) throws RuntimeException {

        try {
            Fracao fracaoEncontrado = this.fracoes.get(id);

            if (fracaoEncontrado == null)
                throw new RuntimeException("Fracao não encontrada!");

            return fracaoEncontrado;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarEquilibrio() throws RuntimeException {
        try {
            return somaQuotaMensal() > 99.00;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double somaPercentagemFracoes() throws RuntimeException {
        try {
            double soma = 0.0;

            if (fracoes != null)
                for (Fracao fracao : fracoes)
                    soma += fracao.getPercentagemArea();

            return soma;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double somaQuotaMensal() throws RuntimeException {
        try {

            double somaQuotas = 0.0;

            if (fracoes != null)
                for (Fracao fracao : fracoes)
                    somaQuotas += fracao.getQuotaMensal(this.despesaGeral, this.despesaComElevador);

            return somaQuotas;
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
                "\tnumeroFracoes: " + numeroFracoes + "\n" +
                "}";
    }

}