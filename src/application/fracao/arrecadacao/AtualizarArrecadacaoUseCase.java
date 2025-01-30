package application.fracao.arrecadacao;

import domain.fracao.arrecadacao.Arrecadacao;

public class AtualizarArrecadacaoUseCase {

    private Arrecadacao arrecadacaoAntiga;
    private ArrecadacaoDTO dadosNovos;

    public AtualizarArrecadacaoUseCase(Arrecadacao arrecadacaoAntiga, ArrecadacaoDTO dadosNovos) {
        this.arrecadacaoAntiga = arrecadacaoAntiga;
        this.dadosNovos = dadosNovos;
    }

    public Arrecadacao validar() throws RuntimeException {

        try {
            if (arrecadacaoAntiga == null)
                throw new RuntimeException("Arrecadação não encontrada!");

            if (dadosNovos.area > 0)
                this.arrecadacaoAntiga.setArea(dadosNovos.area);

            if (dadosNovos.localizacao.length() > 0)
                this.arrecadacaoAntiga.setLocalizacao(dadosNovos.localizacao);

            if (dadosNovos.proprietario != null)
                this.arrecadacaoAntiga.setProprietario(dadosNovos.proprietario);

            this.arrecadacaoAntiga.setPortaBlindada(dadosNovos.portaBlindada);

            return this.arrecadacaoAntiga;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
