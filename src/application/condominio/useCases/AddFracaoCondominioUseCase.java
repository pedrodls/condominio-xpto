package application.condominio.useCases;

import domain.condominio.Condominio;
import domain.fracao.Fracao;

public class AddFracaoCondominioUseCase {

    private Condominio condominio;
    private Fracao fracao;

    public AddFracaoCondominioUseCase(Condominio condominio, Fracao fracao) {
        this.condominio = condominio;
        this.fracao = fracao;
    }

    public void validar() throws RuntimeException {
        try {

            this.condominio.addFracao(fracao);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
