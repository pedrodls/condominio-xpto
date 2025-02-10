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

            if (dadosNovos.area > 0)
                this.fracaoAntiga.setArea(dadosNovos.area);

            if (dadosNovos.localizacao.length() > 0)
                this.fracaoAntiga.setLocalizacao(dadosNovos.localizacao);

            if (dadosNovos.proprietario != null)
                this.fracaoAntiga.setProprietario(dadosNovos.proprietario);

            return this.fracaoAntiga;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
