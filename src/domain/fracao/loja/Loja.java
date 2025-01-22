package domain.fracao.loja;

import domain.fracao.Fracao;
import domain.proprietario.IProprietario;

public class Loja extends Fracao {

    public Loja(int area, String localizacao, IProprietario proprietario) {
        super(area, localizacao, proprietario);
    }

    @Override
    public double getQuotaMensal(double despesaGeral, double despesaComElevador){
        return despesaGeral * this.percentagemArea;
    }
}
