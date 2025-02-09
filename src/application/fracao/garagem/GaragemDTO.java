package application.fracao.garagem;

import application.fracao.FracaoDTO;
import domain.proprietario.Proprietario;

public class GaragemDTO extends FracaoDTO{
    
    public int numeroViaturas;
    public boolean servicoDeLavagem;
    
    public GaragemDTO(int viaturas, boolean lavagem, int area, String localizacao, Proprietario proprietario){
        this.numeroViaturas = viaturas;
        this.servicoDeLavagem = lavagem;
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
    }
}
