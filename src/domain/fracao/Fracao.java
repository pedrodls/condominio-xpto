package domain.fracao;

import domain.helpers.Entidade;
import domain.proprietario.IProprietario;

public class Fracao extends Entidade implements IFracao {

    protected int area;
    protected double percentagemArea;
    protected String localizacao;
    protected IProprietario proprietario;

    public Fracao(){

    }
    
    public Fracao(int area, String localizacao, IProprietario proprietario) {
        this.area = area;
        this.percentagemArea = 0.0;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getPercentagemArea() {
        return percentagemArea;
    }

    public void setPercentagemArea(double percentagemArea) {
        //Uso de Math para arredondar para 3 casas decimais
        this.percentagemArea = Math.round(percentagemArea * 1000.0) / 1000.0;
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
        
        return (despesaGeral + despesaComElevador) * this.percentagemArea;
    }

    

}
