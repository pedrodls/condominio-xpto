package domain.fracao.loja;

import domain.fracao.Fracao;
import domain.proprietario.Proprietario;

public class Loja extends Fracao {

    // Para criar um objecto Nulo
    public Loja() {
        super();
    }

    public Loja(int area, String localizacao, Proprietario proprietario) {
        super(area, localizacao, proprietario);
    }

    @Override
    public double getQuotaMensal(double despesaGeral, double despesaComElevador) {
        return despesaGeral * this.percentagemArea;
    }

    @Override
    public String toString() {
        return super.toString() + " } ";
    }
}
