package application.fracao.arrecadacao.useCases;

import application.fracao.arrecadacao.ArrecadacaoDTO;
import domain.fracao.arrecadacao.Arrecadacao;

public class AtualizarArrecadacaoUseCase {
private Arrecadacao arrecadacao;
    private ArrecadacaoDTO dadosPorAtualizar;

    public AtualizarArrecadacaoUseCase(Arrecadacao arrecadacao, ArrecadacaoDTO dadosPorAtualizar) {
        this.arrecadacao = arrecadacao;
        this.dadosPorAtualizar = dadosPorAtualizar;
    }

    public Arrecadacao validar() throws RuntimeException {

        try {
            if (arrecadacao == null)
                throw new RuntimeException("Arrecadação não encontrada!");

            if (dadosPorAtualizar.area > 0)
                this.arrecadacao.setArea(dadosPorAtualizar.area);
        
            if (dadosPorAtualizar.localizacao.length() > 0)
                this.arrecadacao.setLocalizacao(dadosPorAtualizar.localizacao);

            if (dadosPorAtualizar.proprietario != null)
                this.arrecadacao.setProprietario(dadosPorAtualizar.proprietario);

            this.arrecadacao.setPortaBlindada(dadosPorAtualizar.portaBlindada);

            

            return this.arrecadacao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
