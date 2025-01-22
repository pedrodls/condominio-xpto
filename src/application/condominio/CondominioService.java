package application.condominio;

import application.IRepositorio;
import application.condominio.useCases.AtualizarCondominioUseCase;
import application.condominio.useCases.CriarCondominioUseCase;
import domain.condominio.Condominio;

public class CondominioService {

    private IRepositorio<Condominio> condominioRepositorio;

    public CondominioService(IRepositorio<Condominio> condominioRepositorio) {
        this.condominioRepositorio = condominioRepositorio;
    }

    public Condominio buscarCondominio() throws RuntimeException {
        try {
            return this.condominioRepositorio.findById(0);
        } catch (Exception e) {
            return null;
        }
    }

    public Condominio criarCondominio(CondominioDTO dados) throws RuntimeException {
        try {

            Condominio condominio = this.buscarCondominio();

            if (condominio != null)
                throw new RuntimeException("Condominio já existe, não pode criar outra vez");

            return this.condominioRepositorio.create(new CriarCondominioUseCase(dados).getCondominio());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Condominio atualizarCondominio(CondominioDTO dados) throws RuntimeException {
        try {
            return this.condominioRepositorio
                    .update(new AtualizarCondominioUseCase(this.buscarCondominio(), dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
}
