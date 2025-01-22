package application.condominio;

import application.IRepositorio;
import application.condominio.useCases.AtualizarCondominioUseCase;
import application.condominio.useCases.CriarCondominioUseCase;
import domain.condominio.Condominio;
import domain.fracao.Fracao;

public class CondominioService {

    private IRepositorio<Condominio> condominioRepositorio;

    public CondominioService(IRepositorio<Condominio> condominioRepositorio) {
        this.condominioRepositorio = condominioRepositorio;
    }

    public Condominio buscarCondominio() throws RuntimeException {
        try {
            return this.condominioRepositorio.findById(0);
        } catch (Exception e) {
            return null;
        }
    }

    public Condominio criarCondominio(CondominioDTO dados) throws RuntimeException {
        try {

            Condominio condominio = this.buscarCondominio();

            if (condominio != null)
                throw new RuntimeException("Condominio já existe, não pode criar outra vez");

            return this.condominioRepositorio.create(new CriarCondominioUseCase(dados).getCondominio());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Condominio atualizarCondominio(CondominioDTO dados) throws RuntimeException {
        try {
            return this.condominioRepositorio
                    .update(new AtualizarCondominioUseCase(this.buscarCondominio(), dados).validar());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listarFracoes() throws RuntimeException {
        try {
            Condominio condominio = this.buscarCondominio();

            if (condominio == null) {
                System.out.println("Deve criar um condominio antes!");
                return;
            }

            condominio.listarFracoes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarFracao(Fracao novaFracao) throws RuntimeException {
        try {
            Condominio condominio = this.buscarCondominio();
            condominio.addFracao(novaFracao);
            this.condominioRepositorio.update(condominio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarFracao(int id) throws RuntimeException {
        try {
            Condominio condominio = this.buscarCondominio();
            condominio.eliminarFracao(id);
            this.condominioRepositorio.update(condominio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Fracao procurarFracao(int id) throws RuntimeException {
        try {
            Condominio condominio = this.buscarCondominio();
            return condominio.procurarFracao(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    public boolean verificarEquilibrio() throws RuntimeException {
        try {
            Condominio condominio = this.buscarCondominio();
            return condominio.verificarEquilibrio();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    public double somaPercentagemFracoes() throws RuntimeException {
        try {
            Condominio condominio = this.buscarCondominio();
            return condominio.somaPercentagemFracoes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    public double somaQuotaMensal() throws RuntimeException {
        try {
            Condominio condominio = this.buscarCondominio();
            return condominio.somaQuotaMensal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}
