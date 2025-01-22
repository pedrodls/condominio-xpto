package application.fracao.loja;

import application.fracao.FracaoDTO;
import domain.proprietario.IProprietario;

public class LojaDTO extends FracaoDTO {
    
    public LojaDTO() {

    }

    public LojaDTO(int area, String localizacao, IProprietario proprietario){
        this.area = area;
        this.localizacao = localizacao;
        this.proprietario = proprietario;
    }
}
