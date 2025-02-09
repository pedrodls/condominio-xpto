package application.condominio.useCases;

import application.condominio.CondominioDTO;
import domain.condominio.Condominio;

public class AtualizarCondominioUseCase {

    private Condominio condominio;
    private CondominioDTO dadosPorAtualizar;

    public AtualizarCondominioUseCase(Condominio condominio, CondominioDTO dadosPorAtualizar) {
        this.condominio = condominio;
        this.dadosPorAtualizar = dadosPorAtualizar;
    }

    public Condominio validar() throws RuntimeException {

        try {
            if (condominio == null)
                throw new RuntimeException("Dados não Encontrados!");

            if (dadosPorAtualizar.morada.length() > 0)
                this.condominio.setMorada(dadosPorAtualizar.morada);

            if (dadosPorAtualizar.dataConstrucao.length() > 0)
                this.condominio.setDataConstrucao(dadosPorAtualizar.dataConstrucao);

            if (dadosPorAtualizar.despesaGeral >= 0)
                this.condominio.setDespesaComElevador(dadosPorAtualizar.despesaComElevador);

            if (dadosPorAtualizar.despesaComElevador >= 0)
                this.condominio.setDespesaGeral(dadosPorAtualizar.despesaGeral);

            return this.condominio;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
