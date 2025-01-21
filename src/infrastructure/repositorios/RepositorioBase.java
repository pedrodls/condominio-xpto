package infrastructure.repositorios;

import java.util.ArrayList;
import java.util.Optional;

import application.IRepositorio;
import domain.helpers.Entidade;
import domain.helpers.Id;
import infrastructure.entidadePersistente.EntidadePersistente;

public class RepositorioBase<T extends Entidade> implements IRepositorio<T> {

    protected EntidadePersistente<T> entidadePersistente;

    public RepositorioBase(EntidadePersistente<T> entidadePersistente) {
        this.entidadePersistente = entidadePersistente;
    }

    public T create(T dados) throws Error {
        try {
            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            dadosPersistentes.add(dados);

            this.entidadePersistente.salvarTodosDados(dadosPersistentes);

            return dados;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public boolean update(T dados) throws Error {
        try {

            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            dadosPersistentes.add(dadosPersistentes.indexOf(this.findById(dados.getId())), dados);

            this.entidadePersistente.salvarTodosDados(dadosPersistentes);

            return true;

        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public boolean delete(String id) throws Error {
        try {

            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            dadosPersistentes.remove(this.findById(id));

            this.entidadePersistente.salvarTodosDados(dadosPersistentes);

            return true;

        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public T findById(String id) throws Error {
        try {

            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            T dadosEncontrados = dadosPersistentes.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst().get();

            if (!(dadosEncontrados.getId().length() > 0))
                throw new Error("Dado(s) não encontrado(s)");

            return dadosEncontrados;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ArrayList<T> findAll() throws Error {
        try {
            return this.entidadePersistente.getTodosDados();
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
