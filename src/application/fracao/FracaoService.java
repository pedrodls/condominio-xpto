package application.fracao;

import application.IRepositorio;
import application.fracao.useCases.CriarFracaoUseCase;
import domain.fracao.Fracao;

public class FracaoService {
    private IRepositorio<Fracao> fracaoRepositorio;

    public FracaoService(IRepositorio<Fracao> fracaoRepositorio) {
        this.fracaoRepositorio = fracaoRepositorio;
    }

    public Fracao buscarFracao(int id) throws RuntimeException {
        try {
            return this.fracaoRepositorio.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public Fracao criarFracao(FracaoDTO dados) throws RuntimeException {
        try {

            // Essa parte desta verificação será feita em outro lugar

            /*
             * Fracao fracao = this.buscarFracao();
             * 
             * if (fracao != null)
             * throw new
             * RuntimeException("Arrecadação já existe, não pode criar outra vez!");
             */

            return this.fracaoRepositorio.create(new CriarFracaoUseCase(dados).getFracao());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
