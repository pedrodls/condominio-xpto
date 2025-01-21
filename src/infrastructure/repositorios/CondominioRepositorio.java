package infrastructure.repositorios;

import domain.condominio.Condominio;
import utils.Constantes;
import infrastructure.entidadePersistente.EntidadePersistente;

public class CondominioRepositorio extends RepositorioBase<Condominio> {

    public CondominioRepositorio() {
        super(new EntidadePersistente(Constantes.condominioFIle));
    }

    
}
