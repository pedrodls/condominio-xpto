package application.fracao.loja.useCases;

import application.fracao.loja.LojaDTO;
import domain.fracao.loja.Loja;

public class AtualizarLojaUseCase {
    private Loja loja;
    private LojaDTO dadosPorAtualizar;

    public AtualizarLojaUseCase(Loja loja, LojaDTO dadosPorAtualizar) {
        this.loja = loja;
        this.dadosPorAtualizar = dadosPorAtualizar;
    }

    public Loja validar() throws RuntimeException {

        try {
            if (loja == null)
                throw new RuntimeException("Loja não encontrada!");

            if (dadosPorAtualizar.area > 0)
                this.loja.setArea(dadosPorAtualizar.area);
        
            if (dadosPorAtualizar.localizacao.length() > 0)
                this.loja.setLocalizacao(dadosPorAtualizar.localizacao);

            if (dadosPorAtualizar.proprietario != null)
                this.loja.setProprietario(dadosPorAtualizar.proprietario);

            return this.loja;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
