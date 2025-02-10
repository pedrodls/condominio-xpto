package application.fracao.arrecadacao;

import application.fracao.FracaoService;
import domain.condominio.Condominio;
import domain.fracao.arrecadacao.Arrecadacao;

public class ArrecadacaoService extends FracaoService<Arrecadacao, ArrecadacaoDTO> {

    public ArrecadacaoService(Condominio condominio) {
        super(condominio);
    }

    @Override
    public Arrecadacao add(ArrecadacaoDTO dados) throws RuntimeException {
        try {
            return (Arrecadacao) this.condominio.addFracao(new CriarArrecadacaoUseCase(dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
