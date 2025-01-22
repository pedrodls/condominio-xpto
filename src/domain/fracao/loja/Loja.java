package domain.fracao.loja;

import domain.fracao.Fracao;
import domain.proprietario.IProprietario;

public class Loja extends Fracao {

    public Loja(int area, double percentagemArea, String localizacao, IProprietario proprietario) {
        super(area, area, localizacao, proprietario);
    }

    @Override
    public double getQuotaMensal(double despesaGeral, double despesaComElevador){
        return 0;
    }
}
