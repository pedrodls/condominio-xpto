package domain.fracao;

import domain.helpers.IEntidade;
import domain.proprietario.Proprietario;

public interface IFracao extends IEntidade {

    public double getArea();

    public void setArea(double area);

    public double getPercentagemArea();

    public void setPercentagemArea(double percentagemArea);

    public String getLocalizacao();

    public void setLocalizacao(String localizacao);

    public Proprietario getProprietario();

    public void setProprietario(Proprietario proprietario);

    public double getQuotaMensal(double despesaGeral, double despesaComElevador);
}
