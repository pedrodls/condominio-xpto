package domain.condominio;

import java.time.LocalDate;
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

    public LocalDate getDataConstrucao();

    public void setDataConstrucao(LocalDate dataConstrucao);

    public List<Fracao> getFracoes();

}
