package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;

import application.fracao.arrecadacao.ArrecadacaoDTO;
import application.fracao.arrecadacao.ArrecadacaoService;
import domain.condominio.Condominio;
import domain.fracao.Fracao;
import domain.fracao.arrecadacao.Arrecadacao;
import utils.PauseToRead;

public class CriarArrecadacaoController {

    public static void criar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            Scanner sc = new Scanner(System.in);

            Fracao fracao = CriarFracaoController.criar(condominio, "Arrecadação");

            if (fracao == null)
                throw new RuntimeException("Erro de validação!");

            ArrecadacaoDTO arrecadacaoDTO = new ArrecadacaoDTO();

            arrecadacaoDTO.id = fracao.getId();
            arrecadacaoDTO.area = fracao.getArea();
            arrecadacaoDTO.localizacao = fracao.getLocalizacao();
            arrecadacaoDTO.proprietario = fracao.getProprietario();

            do {

                System.out.printf("A arrecadação tem porta blidanda? 1-Sim 2-Não: ");

                char opcao = sc.next().charAt(0);

                if (opcao == '1') {
                    arrecadacaoDTO.portaBlindada = true;
                    break;
                } else if (opcao == '2') {
                    arrecadacaoDTO.portaBlindada = false;
                    break;
                }

                System.out.println("Opção inválida!");

            } while (true);

            Arrecadacao arrecadacao = new ArrecadacaoService(condominio).add(arrecadacaoDTO);

            if (arrecadacao == null)
                throw new RuntimeException("Erro ao criar arrecadação.");

            System.out.println("Arrecadação criada com sucesso!");
            System.out.println(arrecadacao.toString());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
