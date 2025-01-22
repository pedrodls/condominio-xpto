package presentation.controllers.condominio;

import java.util.Scanner;

import application.condominio.CondominioDTO;
import application.condominio.CondominioService;
import domain.condominio.Condominio;
import infrastructure.repositorios.CondominioRepositorio;

public class CondominioController {

    public static void criar() throws RuntimeException {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("\t-- Criando Condominio --\n");

            CondominioDTO condominioDTO = new CondominioDTO();

            CondominioService condominioService = new CondominioService(new CondominioRepositorio());

            System.out.println("Insira a morada: ");
            condominioDTO.morada = sc.nextLine();

            System.out.println("Insira o valor da despesa geral: ");
            condominioDTO.despesaGeral = sc.nextDouble();

            System.out.println("Insira o valor da despesa com elevador: ");
            condominioDTO.despesaComElevador = sc.nextDouble();

            System.out.println("Insira a data de construção (DD/MM/YYYY): ");
            condominioDTO.dataConstrucao = sc.nextLine();

            Condominio novoCondominio = condominioService.criarCondominio(condominioDTO);

            System.out.println("Condominio criado: ");
            System.out.println(novoCondominio);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Prime qualquer tecla para sair...");
            sc.next();
            sc.close();
        }

    }
}
