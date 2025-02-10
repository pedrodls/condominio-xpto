package application.fracao;

import java.util.List;

import domain.condominio.Condominio;
import domain.fracao.Fracao;
import domain.proprietario.Proprietario;

public class CriarFracaoUseCase {

  private Fracao fracaoNova;
  private FracaoDTO dadosNovos;
  private Condominio condominio;

  public CriarFracaoUseCase(FracaoDTO dadosNovos, Condominio condominio) {
    this.dadosNovos = dadosNovos;
    this.fracaoNova = new Fracao();
    this.condominio = condominio;
  }

  public Fracao validar() throws RuntimeException {

    try {

      List<Fracao> fracoes = this.condominio.getFracoes();

      this.fracaoNova.setId(fracoes == null ? 1 : fracoes.size() + 1);
      this.fracaoNova.setArea(dadosNovos.area);
      this.fracaoNova.setLocalizacao(dadosNovos.localizacao);
      this.fracaoNova.setProprietario(dadosNovos.proprietario);

      return this.fracaoNova;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
