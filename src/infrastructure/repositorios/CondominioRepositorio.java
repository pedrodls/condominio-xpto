package infrastructure.repositorios;

import domain.condominio.Condominio;
import utils.Constantes;
import infrastructure.entidadePersistente.EntidadePersistente;

public class CondominioRepositorio extends RepositorioBase<Condominio> {

    public CondominioRepositorio() {
        super(new EntidadePersistente<Condominio>(Constantes.condominioFIle));
    }

    @Override
    public Condominio findById(int id) throws RuntimeException {
        try {
            return super.findAll().get(0);
        } catch (Exception e) {
            return null;
        }
    }

}
