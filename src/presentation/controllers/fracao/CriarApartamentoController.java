package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;

import application.fracao.apartamento.ApartamentoDTO;
import application.fracao.apartamento.ApartamentoService;
import domain.condominio.Condominio;
import domain.fracao.Fracao;
import domain.fracao.apartamento.Apartamento;
import domain.fracao.apartamento.TipoApartamento;
import utils.PauseToRead;

public class CriarApartamentoController {

    public static void criar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            Scanner sc = new Scanner(System.in);

            Fracao fracao = CriarFracaoController.criar(condominio, "Apartamento");

            if (fracao == null)
                throw new RuntimeException("Erro de validação!");

            ApartamentoDTO apartamentoDTO = new ApartamentoDTO();

            apartamentoDTO.id = fracao.getId();
            apartamentoDTO.area = fracao.getArea();
            apartamentoDTO.localizacao = fracao.getLocalizacao();
            apartamentoDTO.proprietario = fracao.getProprietario();

            do {

                System.out.println(" -- Tipo de Apartamento -- ");

                for (TipoApartamento tipo : TipoApartamento.values()) {
                    System.out.println("- " + tipo);
                }

                System.out.print("Digite o tipo: ");
                String tipo = sc.nextLine().toUpperCase();

                try {
                    apartamentoDTO.tipo = TipoApartamento.valueOf(tipo);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Opção inválida!");
                }

            } while (true);

            System.out.println("Numero de casas de Banho: ");

            apartamentoDTO.numeroCasaBanhos = sc.nextInt();
            sc.nextLine();

            System.out.println("Numero de Varandas: ");

            apartamentoDTO.numeroCasaBanhos = sc.nextInt();
            sc.nextLine();

            do {

                System.out.printf("O apartamento tem terraço? 1-Sim 2-Não: ");

                char opcao = sc.next().charAt(0);

                if (opcao == '1') {
                    apartamentoDTO.terraco = true;
                    break;
                } else if (opcao == '2') {
                    apartamentoDTO.terraco = false;
                    break;
                }

                System.out.println("Opção inválida!");

            } while (true);

            Apartamento apartamento = new ApartamentoService(condominio).add(apartamentoDTO);

            if (apartamento == null)
                throw new RuntimeException("Erro ao criar apartamento.");

            System.out.println("Apartamento criado com sucesso!");
            System.out.println(apartamento.toString());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
