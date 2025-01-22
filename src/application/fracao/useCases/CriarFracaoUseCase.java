package application.fracao.useCases;

import application.fracao.FracaoDTO;
import application.fracao.loja.LojaDTO;
import domain.fracao.Fracao;
import domain.fracao.arrecadacao.Arrecadacao;
import domain.fracao.loja.Loja;

public class CriarFracaoUseCase {

    private Fracao fracao;
    private FracaoDTO dados;
    
    public CriarFracaoUseCase(FracaoDTO dados) {
        this.dados = dados;
    }
    
    @SuppressWarnings("unchecked")
    public Fracao getFracao() throws RuntimeException {

        try {

          if (dados.area <= 0)
            throw new RuntimeException("A área não pode ser zero ou negativa");

          this.fracao.setId(0);
          if (fracao instanceof Loja){
            this.fracao = new Loja(dados.area, dados.localizacao, dados.proprietario);
          }else if (fracao instanceof Arrecadacao){
            this.fracao = new Arrecadacao(dados.area, dados.localizacao, dados.proprietario, dados.portaBlindada);
          }

          return this.fracao;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
    }
}
