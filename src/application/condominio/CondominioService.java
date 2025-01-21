package application.condominio;

import application.IRepositorio;
import application.condominio.useCases.CriarCondominioUseCase;
import domain.condominio.Condominio;

public class CondominioService {

    public IRepositorio<Condominio> condominioRepositorio;

    public CondominioService(IRepositorio<Condominio> condominioRepositorio) {
        this.condominioRepositorio = condominioRepositorio;
    }

    public Condominio criarCondominio(CondominioDTO dados) throws Error {
        try {
            return this.condominioRepositorio.create(new CriarCondominioUseCase(dados).getCondominio());
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
