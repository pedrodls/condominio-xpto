package infrastructure.repositorios;

import java.util.ArrayList;

import application.IRepositorio;
import domain.helpers.Entidade;
import infrastructure.entidadePersistente.EntidadePersistente;

public class RepositorioBase<T extends Entidade> implements IRepositorio<T> {

    protected EntidadePersistente<T> entidadePersistente;

    public RepositorioBase(EntidadePersistente<T> entidadePersistente) {
        this.entidadePersistente = entidadePersistente;
    }

    public T create(T dados) throws RuntimeException {
        try {
            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            dadosPersistentes.add(dados);

            this.entidadePersistente.salvarTodosDados(dadosPersistentes);

            return dados;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T update(T dados) throws RuntimeException {
        try {

            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            dadosPersistentes.set(dados.getId(), dados);

            this.entidadePersistente.salvarTodosDados(dadosPersistentes);

            return dados;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id) throws RuntimeException {
        try {

            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            dadosPersistentes.remove(this.findById(id).getId());

            this.entidadePersistente.salvarTodosDados(dadosPersistentes);

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T findById(int id) throws RuntimeException {
        try {

            ArrayList<T> dadosPersistentes = this.entidadePersistente.getTodosDados();

            if (dadosPersistentes.isEmpty())
                throw new RuntimeException("Lista de dados vazia!");

            T dadosEncontrados = dadosPersistentes.get(id);

            if (!(dadosEncontrados == null))
                throw new RuntimeException("Dado(s) não encontrado(s)");

            return dadosEncontrados;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<T> findAll() throws RuntimeException {
        try {
            return this.entidadePersistente.getTodosDados();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
