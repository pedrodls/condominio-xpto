package application.fracao.loja;

import java.util.List;

import application.IRepositorio;
import application.fracao.loja.useCases.AtualizarLojaUseCase;
import application.fracao.loja.useCases.CriarLojaUseCase;
import domain.fracao.loja.Loja;

public class LojaService {
private IRepositorio<Loja> lojaRepositorio;

    public LojaService(IRepositorio<Loja> lojaRepositorio) {
        this.lojaRepositorio = lojaRepositorio;
    }

    public Loja buscarLoja(int id) throws RuntimeException {
        try {
            return this.lojaRepositorio.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    public Loja criarLoja(LojaDTO dados) throws RuntimeException {
        try {

            // Essa parte desta verificação será feita em outro lugar

            /*
             * Loja loja = this.buscarLoja();
             * 
             * if (loja != null)
             * throw new
             * RuntimeException("Arrecadação já existe, não pode criar outra vez!");
             */

            return this.lojaRepositorio.create(new CriarLojaUseCase(dados).getLoja());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //Retorna true se a fracção passada por parâmetro já existir no condomínio
    public boolean existeLoja(LojaDTO dados) throws RuntimeException {
        try {
            
            List<Loja> fracoes = this.lojaRepositorio.findAll();
            Loja novaLoja = new CriarLojaUseCase(dados).getLoja();

            for (Loja loja : fracoes) {
                if (loja.equals(novaLoja)) return true;
            }

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Loja atualizarLoja(int id, LojaDTO dados) throws RuntimeException {
        try {
            return this.lojaRepositorio
                    .update(new AtualizarLojaUseCase(this.buscarLoja(id), dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void retirarLoja(int id) throws RuntimeException {
        try {
            
            this.lojaRepositorio.delete(id);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
