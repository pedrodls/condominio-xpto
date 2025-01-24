package application.fracao;

import java.util.List;

import application.IRepositorio;
import application.fracao.useCases.AtualizarFracaoUseCase;
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

    //Retorna true se a fracção passada por parâmetro já existir no condomínio
    public boolean existeFracao(FracaoDTO dados) throws RuntimeException {
        try {
            
            List<Fracao> fracoes = this.fracaoRepositorio.findAll();
            Fracao novaFracao = new CriarFracaoUseCase(dados).getFracao();

            for (Fracao fracao : fracoes) {
                if (fracao.equals(novaFracao)) return true;
            }

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Fracao atualizarFracao(int id, FracaoDTO dados) throws RuntimeException {
        try {
            return this.fracaoRepositorio
                    .update(new AtualizarFracaoUseCase(this.buscarFracao(id), dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void retirarFracao(int id) throws RuntimeException {
        try {
            
            this.fracaoRepositorio.delete(id);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
