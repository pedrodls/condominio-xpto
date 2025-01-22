package domain.fracao;

import domain.helpers.Entidade;
import domain.proprietario.IProprietario;

public class Fracao extends Entidade implements IFracao {

    protected long area;
    protected double percentagemArea;
    protected String localizacao;
    protected IProprietario proprietario;

    public Fracao(long area, double percentagemArea, String localizacao, IProprietario proprietario) {
        this.area = area;
        this.percentagemArea = percentagemArea;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public double getPercentagemArea() {
        return percentagemArea;
    }

    public void setPercentagemArea(double percentagemArea) {
        this.percentagemArea = percentagemArea;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public IProprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(IProprietario proprietario) {
        this.proprietario = proprietario;
    }

    public double getQuotaMensal(double despesaGeral, double despesaComElevador){

        //Calcular cota mensal, lembrando que existe temos de pegar a Condominio.areaTotal pois é estático
        
        return 0;
    }

    

}
