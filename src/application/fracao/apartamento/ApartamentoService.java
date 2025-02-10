package application.fracao.apartamento;

import application.fracao.FracaoService;
import domain.condominio.Condominio;
import domain.fracao.apartamento.Apartamento;

public class ApartamentoService extends FracaoService<Apartamento, ApartamentoDTO> {

    public ApartamentoService(Condominio condominio) {
        super(condominio);
    }

    @Override
    public Apartamento add(ApartamentoDTO dados) throws RuntimeException {
        try {
            return (Apartamento) this.condominio.addFracao(new CriarApartamentoUseCase(dados).getApartamento());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
