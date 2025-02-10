package application.fracao;

import domain.fracao.Fracao;

public class AtualizarFracaoUseCase {

    private Fracao fracaoAntiga;
    private FracaoDTO dadosNovos;

    public AtualizarFracaoUseCase(Fracao fracaoAntiga, FracaoDTO dadosNovos) {
        this.fracaoAntiga = fracaoAntiga;
        this.dadosNovos = dadosNovos;
    }

    public Fracao validar() throws RuntimeException {

        try {

            this.fracaoAntiga.setArea(dadosNovos.area);
            this.fracaoAntiga.setLocalizacao(dadosNovos.localizacao);
            this.fracaoAntiga.setProprietario(dadosNovos.proprietario);

            return this.fracaoAntiga;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
