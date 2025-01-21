package domain.condominio;


import java.time.LocalDate;

import domain.fracao.IFracao;

public interface ICondominio {

    public String getMorada();

    public void setMorada(String morada);

    public double getDispesaGeral();

    public void setDispesaGeral(double dispesaGeral);

    public double getDispesaComElevador();

    public void setDispesaComElevador(double dispesaComElevador);

    public void listarFracoes();

    //public void setFracoes(ArrayList<IFracao> fracoes);

    //public int getNumeroFracoes();
    
    //public ArrayList<IFracao> getFracoes();

    public LocalDate getDataConstrucao();

    public void setDataConstrucao(LocalDate dataConstrucao);

    public void addFracao(IFracao fracao);

    public void eliminarFracao(String id);

    public void procurarFracao(String id);

    public boolean verificarEquilibrio();

    public double somaPercentagemFracoes();

    public double somaQuotaMensal();
}
