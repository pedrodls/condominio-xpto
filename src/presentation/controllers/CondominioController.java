package presentation.controllers;

import java.util.Scanner;
import java.util.regex.Pattern;

import application.condominio.CondominioDTO;
import application.condominio.CondominioService;
import domain.condominio.Condominio;
import utils.PauseToRead;

public class CondominioController {

    private static String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static Pattern pattern = Pattern.compile(regex);

    public static Condominio criar() throws RuntimeException {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("\t-- Criando Condominio --\n");

            CondominioDTO condominioDTO = new CondominioDTO();

            CondominioService condominioService = new CondominioService();

            System.out.flush();

            System.out.println("Insira a morada: ");
            condominioDTO.morada = sc.nextLine();

            while (true) {
                System.out.println("Insira a data de construção (DD/MM/YYYY): ");
                condominioDTO.dataConstrucao = sc.nextLine();

                if (pattern.matcher(condominioDTO.dataConstrucao).matches()) {
                    break;
                } else
                    System.out.println("Formato inválido! Use DD/MM/YYYY.");
            }

            System.out.println("Insira o valor da despesa geral: ");
            condominioDTO.despesaGeral = sc.nextDouble();

            System.out.println("Insira o valor da despesa com elevador: ");
            condominioDTO.despesaComElevador = sc.nextDouble();

            Condominio novoCondominio = condominioService.criarCondominio(condominioDTO);


            System.out.println("Condomínio criado com sucesso!");
            PauseToRead.pause();
            System.out.flush();

            return novoCondominio;

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            // se der erro perguntar se quer continuar a criar ou quer sair!!
            return criar();
        }

    }
}
