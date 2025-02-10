package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;

import application.fracao.CriarFracaoUseCase;
import application.fracao.FracaoDTO;
import application.fracao.FracaoService;
import domain.condominio.Condominio;
import domain.fracao.Fracao;
import utils.PauseToRead;

public class CriarFracaoController {

    public static Fracao criar(Condominio condominio, String nomeFracao) throws RuntimeException, ParseException {

        try {

            FracaoDTO fracaoDTO = new FracaoDTO();

            Scanner sc = new Scanner(System.in);

            System.out.println("\t-- Criando " + nomeFracao + " --\n");

            do {
                System.out.flush();
                System.out.printf("Insira a localização(min 2 caracteres): ");
                fracaoDTO.localizacao = sc.nextLine();
            } while (fracaoDTO.localizacao.length() < 2);

            do {
                System.out.printf("Insira a área(valor maior que zero): ");
                fracaoDTO.area = sc.nextDouble();
                sc.nextLine();
            } while (fracaoDTO.area <= 0);

            do {
                System.out.printf("Atribuir a proprietário existente? 1-Sim 2-Novo proprietário: ");
                char opcao = sc.nextLine().charAt(0);

                if (opcao == '1') {
                    System.out.printf("Informe o id do proprietário: ");
                    int id = sc.nextInt();
                    fracaoDTO.proprietario = condominio.getProprietario(id);

                    sc.nextLine(); // Limpar buffer

                    if (fracaoDTO.proprietario == null) {
                        System.out.println("Proprietário não encontrado!");
                        PauseToRead.pause();
                    }
                } else if (opcao == '2') {
                    fracaoDTO.proprietario = CriarProprietarioController.criar(condominio);
                } else {
                    System.out.println("Opção inválida!");
                }

            } while (fracaoDTO.proprietario == null);

            return new CriarFracaoUseCase(fracaoDTO, condominio).validar();

        } catch (RuntimeException e) {
            return null;
        }

    }
}
