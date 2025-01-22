package domain.condominio;

import java.time.LocalDate;
import java.util.ArrayList;

import domain.fracao.Fracao;
import domain.helpers.IEntidade;

public interface ICondominio extends IEntidade {

    public String getMorada();

    public void setMorada(String morada);

    public double getDespesaGeral();

    public void setDespesaGeral(double despesaGeral);

    public double getDespesaComElevador();

    public void setDespesaComElevador(double despesaComElevador);

    public void setFracoes(ArrayList<Fracao> fracoes);

    public ArrayList<Fracao> getFracoes();

    public int getNumeroFracoes();

    public long getAreaTotal();

    public LocalDate getDataConstrucao();

    public void setDataConstrucao(LocalDate dataConstrucao);

    public void listarFracoes();

    public void addFracao(Fracao novaFracao);

    public void eliminarFracao(int id);

    public Fracao procurarFracao(int id);

    public boolean verificarEquilibrio();

    public double somaPercentagemFracoes();

    public double somaQuotaMensal();
}
