package application.fracao.apartamento;

import application.fracao.FracaoDTO;
import domain.fracao.apartamento.TipoApartamento;
import domain.proprietario.IProprietario;
import domain.proprietario.Proprietario;

public class ApartamentoDTO extends FracaoDTO{
    
    public TipoApartamento tipo; 
    public int numeroCasaBanhos;
    public int numeroVarandas;
    public boolean terraco;

    public ApartamentoDTO(TipoApartamento tipo, int casaBanhos, int varandas, boolean terraco,int area, String localizacao, IProprietario proprietario){
        
        this.tipo = tipo;
        this.numeroCasaBanhos = casaBanhos;
        this.numeroVarandas = varandas;
        this.terraco = terraco;
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = (Proprietario) proprietario;
    }
}
