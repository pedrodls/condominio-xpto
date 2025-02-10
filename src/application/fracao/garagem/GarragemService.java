package application.fracao.garagem;

import application.fracao.FracaoService;
import domain.condominio.Condominio;
import domain.fracao.garagem.Garagem;

public class GarragemService extends FracaoService<Garagem, GaragemDTO> {

    public GarragemService(Condominio condominio) {
        super(condominio);
    }

    @Override
    public Garagem add(GaragemDTO dados) throws RuntimeException {
        try {
            return (Garagem) this.condominio.addFracao(new CriarGaragemUseCase(dados).getGaragem());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
