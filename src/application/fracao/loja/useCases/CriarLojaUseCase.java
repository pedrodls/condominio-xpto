package application.fracao.loja.useCases;

import application.fracao.loja.LojaDTO;
import domain.fracao.loja.Loja;

public class CriarLojaUseCase {
    
    private Loja loja;
    private LojaDTO dados;
    
    public CriarLojaUseCase(LojaDTO dados) {
        this.dados = dados;
    }
    
    public Loja getLoja() throws RuntimeException {

        try {

          if (dados.area <= 0)
            throw new RuntimeException("A área não pode ser zero ou negativa");

          this.loja.setId(0);
          //this.loja = new Loja(dados.area, 0.0, dados.localizacao, );
          //linha acima comentada pq falta o ultimo parametro, o proprietario

          return this.loja;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
    }
}
