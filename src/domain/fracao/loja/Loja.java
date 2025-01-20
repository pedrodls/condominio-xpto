package domain.fracao.loja;

import domain.fracao.Fracao;
import domain.proprietario.IProprietario;

public class Loja extends Fracao {

    public Loja(int area, float percentagemArea, String localizacao, IProprietario proprietario) {
        super(area, area, localizacao, proprietario);
    }

    @Override
    public float getQuotaMensal(float dispesaGeral, float dispesaComElevador){
        return 0;
    }
}
