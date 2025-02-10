package domain.condominio;

import java.util.List;

import domain.fracao.Fracao;
import domain.helpers.IEntidade;

public interface ICondominio extends IEntidade {

    public String getMorada();

    public void setMorada(String morada);

    public double getDespesaGeral();

    public void setDespesaGeral(double despesaGeral);

    public double getDespesaComElevador();

    public void setDespesaComElevador(double despesaComElevador);

    public double getAreaTotal();

    public String getDataConstrucao();

    public void setDataConstrucao(String dataConstrucao);

    public List<Fracao> getFracoes();

    public void setPercentagemFracoes();

    public Fracao addFracao(Fracao fracao) throws RuntimeException;

    public boolean retirarFracao(int id) throws RuntimeException;

    public Fracao buscarFracao(int id) throws RuntimeException;

    public Fracao atualizarFracao(Fracao fracaoAtualizada) throws RuntimeException;

}
