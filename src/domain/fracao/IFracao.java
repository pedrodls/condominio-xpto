package domain.fracao;

import domain.proprietario.IProprietario;

public interface IFracao {
    
    public int getArea();

    public void setArea(int area);

    public float getPercentagemArea();

    public void setPercentagemArea(float percentagemArea);

    public String getLocalizacao();

    public void setLocalizacao(String localizacao);

    public IProprietario getProprietario();

    public void setProprietario(IProprietario proprietario);

    public float getQuotaMensal(float dispesaGeral, float dispesaComElevador);
}
