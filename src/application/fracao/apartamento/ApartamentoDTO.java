package application.fracao.apartamento;

import application.fracao.FracaoDTO;
import domain.fracao.apartamento.TipoApartamento;

public class ApartamentoDTO extends FracaoDTO{

    public int id;
    public TipoApartamento tipo; 
    public int numeroCasaBanhos;
    public int numeroVarandas;
    public boolean terraco;

}
