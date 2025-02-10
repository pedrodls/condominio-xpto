package application.condominio;

import application.condominio.useCases.AtualizarCondominioUseCase;
import application.condominio.useCases.CriarCondominioUseCase;
import domain.condominio.Condominio;
import infrastructure.Persistente;

public class CondominioService {

    Persistente<Condominio> persistente;

    public CondominioService() {
        this.persistente = new Persistente<Condominio>();
    }

    public Condominio buscarCondominio() throws RuntimeException {
        try {
            return persistente.get();
        } catch (Exception e) {
            return null;
        }
    }

    public Condominio criarCondominio(CondominioDTO dados) throws RuntimeException {
        try {

            return new CriarCondominioUseCase(dados).getCondominio();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Condominio atualizarCondominio(CondominioDTO dados, Condominio condominio) throws RuntimeException {
        try {

            Condominio condominioAtualizado = new AtualizarCondominioUseCase(condominio, dados).validar();

            return condominioAtualizado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
