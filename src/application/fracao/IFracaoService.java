package application.fracao;

import domain.fracao.Fracao;

public interface IFracaoService<T extends Fracao, K extends FracaoDTO> {

    public T add(K dados) throws RuntimeException;

    public T buscar(int id) throws RuntimeException;

    public void listar() throws RuntimeException;

    public boolean existe(T elemento) throws RuntimeException;

    public T atualizar(int id, K dados) throws RuntimeException;

}
