package domain.condominio;

import java.util.ArrayList;
import java.util.Date;

import domain.fracao.IFracao;

public interface ICondominio {

    public String getMorada();

    public void setMorada(String morada);

    public int getNumeroFracoes();

    public float getDispesaGeral();

    public void setDispesaGeral(float dispesaGeral);

    public float getDispesaComElevador();

    public void setDispesaComElevador(float dispesaComElevador);

    public void listarFracoes();

    public void setFracoes(ArrayList<IFracao> fracoes);

    public Date getDataConstrucao();

    public void setDataConstrucao(Date dataConstrucao);

    public void addFracao(IFracao fracao);

    public void eliminarFracao(String id);

    public void procurarFracao(String id);

    public boolean verificarEquilibrio();

    public float somaPercentagemFracoes();

    public float somaQuotaMensal();
}
