package domain.fracao;

import domain.helpers.IEntidade;
import domain.proprietario.IProprietario;

public interface IFracao extends IEntidade  {
    
    public long getArea();

    public void setArea(long area);

    public double getPercentagemArea();

    public void setPercentagemArea(double percentagemArea);

    public String getLocalizacao();

    public void setLocalizacao(String localizacao);

    public IProprietario getProprietario();

    public void setProprietario(IProprietario proprietario);

    public double getQuotaMensal(double despesaGeral, double despesaComElevador);
}
