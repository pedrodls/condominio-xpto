package application.fracao.loja;

import application.fracao.FracaoService;
import domain.condominio.Condominio;
import domain.fracao.loja.Loja;

public class LojaService extends FracaoService<Loja, LojaDTO> {

    public LojaService(Condominio condominio) {
        super(condominio);
    }

    @Override
    public Loja criar(LojaDTO dados) throws RuntimeException {
        try {
            return (Loja) this.condominio.addFracao(new CriarLojaUseCase(dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
