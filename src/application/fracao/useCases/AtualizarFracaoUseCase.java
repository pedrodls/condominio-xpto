package application.fracao.useCases;

import application.fracao.FracaoDTO;
import domain.fracao.Fracao;

public class AtualizarFracaoUseCase {

    private Fracao fracao;
    private FracaoDTO dadosPorAtualizar;

    public AtualizarFracaoUseCase(Fracao fracao, FracaoDTO dadosPorAtualizar) {
        this.fracao = fracao;
        this.dadosPorAtualizar = dadosPorAtualizar;
    }

    public Fracao validar() throws RuntimeException {

        try {
            if (fracao == null)
                throw new RuntimeException("Fracção não encontrada!");

            if (dadosPorAtualizar.area > 0)
                this.fracao.setArea(dadosPorAtualizar.area);
        
            if (dadosPorAtualizar.localizacao.length() > 0)
                this.fracao.setLocalizacao(dadosPorAtualizar.localizacao);

            if (dadosPorAtualizar.proprietario != null)
                this.fracao.setProprietario(dadosPorAtualizar.proprietario);

            return this.fracao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
