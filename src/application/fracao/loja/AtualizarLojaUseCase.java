package application.fracao.loja;

import domain.fracao.loja.Loja;

public class AtualizarLojaUseCase {

    private Loja lojaAntiga;
    private LojaDTO dadosNovos;

    public AtualizarLojaUseCase(Loja lojaAntiga, LojaDTO dadosNovos) {
        this.lojaAntiga = lojaAntiga;
        this.dadosNovos = dadosNovos;
    }

    public Loja validar() throws RuntimeException {

        try {

            if (dadosNovos.area > 0)
                this.lojaAntiga.setArea(dadosNovos.area);

            if (dadosNovos.localizacao.length() > 0)
                this.lojaAntiga.setLocalizacao(dadosNovos.localizacao);

            if (dadosNovos.proprietario != null)
                this.lojaAntiga.setProprietario(dadosNovos.proprietario);

            return this.lojaAntiga;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
