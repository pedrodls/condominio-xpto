package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;

import application.fracao.garagem.GaragemDTO;
import application.fracao.garagem.GarragemService;
import domain.condominio.Condominio;
import domain.fracao.Fracao;
import domain.fracao.garagem.Garagem;
import utils.PauseToRead;

public class CriarGaragemController {

    public static void criar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            Scanner sc = new Scanner(System.in);

            Fracao fracao = CriarFracaoController.criar(condominio, "Garagem");

            if (fracao == null)
                throw new RuntimeException("Erro de validação!");

            GaragemDTO garagemDTO = new GaragemDTO();

            garagemDTO.id = fracao.getId();
            garagemDTO.area = fracao.getArea();
            garagemDTO.localizacao = fracao.getLocalizacao();
            garagemDTO.proprietario = fracao.getProprietario();

            do {
                System.out.println("Numero de Viaturas: ");
                garagemDTO.numeroViaturas = sc.nextInt();
            } while (!(garagemDTO.numeroViaturas > 0));

            sc.nextLine();

            do {

                System.out.printf("O apartamento tem terraço? 1-Sim 2-Não: ");

                char opcao = sc.next().charAt(0);

                if (opcao == '1') {
                    garagemDTO.servicoDeLavagem = true;
                    break;
                } else if (opcao == '2') {
                    garagemDTO.servicoDeLavagem = false;
                    break;
                }

                System.out.println("Opção inválida!");

            } while (true);

            Garagem garagem = new GarragemService(condominio).add(garagemDTO);

            if (garagem == null)
                throw new RuntimeException("Erro ao criar garagem.");

            System.out.println("Garagem criado com sucesso!");
            System.out.println(garagem.toString());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
