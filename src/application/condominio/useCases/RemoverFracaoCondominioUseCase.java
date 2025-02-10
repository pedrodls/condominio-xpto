package application.condominio.useCases;

import domain.condominio.Condominio;

public class RemoverFracaoCondominioUseCase {

    private Condominio condominio;
    private int id;

    public RemoverFracaoCondominioUseCase(Condominio condominio, int id) {
        this.condominio = condominio;
        this.id = id;
    }

    public boolean validar() throws RuntimeException {

        try {
            this.condominio.retirarFracao(this.id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Fracao nao encontrada!");
        }
    }
}
