package application.condominio.useCases;

import java.util.List;

import application.fracao.ProprietarioDTO;
import domain.condominio.Condominio;
import domain.proprietario.Proprietario;

public class CriarProprietarioUseCase {

  private Condominio condominio;
  private Proprietario proprietario;
  private ProprietarioDTO dados;

  public CriarProprietarioUseCase(ProprietarioDTO dados, Condominio condominio) {
    this.dados = dados;
    this.condominio = condominio;
    this.proprietario = new Proprietario();
  }

  public Proprietario getProprietario() throws RuntimeException {

    try {

      List<Proprietario> proprietarios = this.condominio.getProprietarios();

      this.proprietario.setId(proprietarios == null ? 1 : proprietarios.size() + 1);
      this.proprietario.setEmail(dados.email);
      this.proprietario.setNome(dados.nome);
      this.proprietario.setMorada(dados.morada);
      this.proprietario.setTelefone(dados.telefone);
      this.proprietario.setTelemovel(dados.telemovel);
      this.proprietario.setDataNascimento(dados.dataNascimento);

      return !condominio.validarExistenciaProprietario(this.proprietario) ? this.proprietario : null;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
