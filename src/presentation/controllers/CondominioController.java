package presentation.controllers;

import java.io.IOException;
import java.util.Scanner;

import application.condominio.CondominioDTO;
import application.condominio.CondominioService;
import domain.condominio.Condominio;
import infrastructure.repositorios.CondominioRepositorio;
import presentation.MenuCondominio;

public class CondominioController {

    public static void criar() throws RuntimeException {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("\t-- Criando Condominio --\n");

            CondominioDTO condominioDTO = new CondominioDTO();

            CondominioService condominioService = new CondominioService(new CondominioRepositorio());

            System.out.println("Insira a morada: ");
            condominioDTO.morada = sc.nextLine();

            System.out.println("Insira a data de construção (DD/MM/YYYY): ");
            condominioDTO.dataConstrucao = sc.nextLine();

            System.out.println("Insira o valor da despesa geral: ");
            condominioDTO.despesaGeral = sc.nextDouble();

            System.out.println("Insira o valor da despesa com elevador: ");
            condominioDTO.despesaComElevador = sc.nextDouble();

            Condominio novoCondominio = condominioService.criarCondominio(condominioDTO);

            System.out.println("Condominio criado: ");
            System.out.println(novoCondominio.toString());

            System.out.println("Prime qualquer tecla para sair...");

            try {
                System.in.read();
            } catch (IOException e) {
            }

            sc.close();

            new MenuCondominio().renderizarMenu();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
