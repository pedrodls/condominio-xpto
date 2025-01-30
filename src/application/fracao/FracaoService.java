package application.fracao;

import java.util.List;

import domain.condominio.Condominio;
import domain.fracao.Fracao;

public class FracaoService<T extends Fracao, K extends FracaoDTO> implements IFracaoService<T, K> {

    protected Condominio condominio;

    public FracaoService(Condominio condominio) {
        this.condominio = condominio;
    }

    @SuppressWarnings("unchecked")
    public T criar(K dados) throws RuntimeException {
        try {
            return (T) this.condominio.addFracao(new CriarFracaoUseCase(dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public T buscar(int id) throws RuntimeException {
        try {
            return (T) this.condominio.buscarFracao(id);
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public void listar() throws RuntimeException {
        try {

            System.out.println("- - - - - - - - - - - - - - - - - - -");

            for (T fracao : (List<T>) this.condominio.getFracoes())
                System.out.println(fracao.toString());

            System.out.println("- - - - - - - - - - - - - - - - - - -");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public boolean existe(T elemento) throws RuntimeException {
        try {

            for (T fracao : (List<T>) this.condominio.getFracoes())
                if (fracao.equals(elemento))
                    return true;

            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T atualizar(int id, K dados) throws RuntimeException {
        try {
            return (T) this.condominio
                    .atualizarFracao(new AtualizarFracaoUseCase(this.condominio.buscarFracao(id), dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
