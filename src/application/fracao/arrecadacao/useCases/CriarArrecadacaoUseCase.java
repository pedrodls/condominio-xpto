package application.fracao.arrecadacao.useCases;

import application.fracao.arrecadacao.ArrecadacaoDTO;
import application.fracao.useCases.CriarFracaoUseCase;
import domain.fracao.arrecadacao.Arrecadacao;

public class CriarArrecadacaoUseCase {
    
    private Arrecadacao arrecadacao;
    private ArrecadacaoDTO dados;
    
    public CriarArrecadacaoUseCase(ArrecadacaoDTO dados) {
      ;
    }
    
    public Arrecadacao getArrecadacao() throws RuntimeException {

        try {

          if (dados.area <= 0)
            throw new RuntimeException("A área não pode ser zero ou negativa");

          
          //this.arrecadacao = new Loja(dados.area, 0.0, dados.localizacao, );
          //linha acima comentada pq falta o ultimo parametro, o proprietario

          return this.arrecadacao;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
    }
}
