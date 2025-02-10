package presentation.controllers.condominio;

import java.util.Scanner;
import java.util.regex.Pattern;

import application.condominio.CondominioDTO;
import application.condominio.CondominioService;
import domain.condominio.Condominio;
import utils.PauseToRead;
import utils.UtilDate;

public class CriarCondominioController {

    public static Condominio criar() {

        try {

            System.out.println("\t-- Criando Condominio --\n");
            Scanner sc = new Scanner(System.in);
            CondominioDTO condominioDTO = new CondominioDTO();
            CondominioService condominioService = new CondominioService();

            do {
                System.out.print("Insira a morada(min 2 caracteres): ");
                condominioDTO.morada = sc.nextLine();
            } while (condominioDTO.morada.length() < 2);

            do {
                System.out.print("Insira a data de construção (DD/MM/YYYY): ");
                condominioDTO.dataConstrucao = sc.nextLine();

                if (UtilDate.validarData(condominioDTO.dataConstrucao)) {
                    break;
                } else {
                    System.out.println("Formato inválido! Use DD/MM/YYYY.");
                }
            } while (true);

            do {
                System.out.print("Insira o valor da despesa geral(valor não negativo): ");
                condominioDTO.despesaGeral = sc.nextDouble();
                sc.nextLine();
            } while (condominioDTO.despesaGeral < 0);

            do {
                System.out.print("Insira o valor da despesa com elevador(valor não negativo): ");
                condominioDTO.despesaComElevador = sc.nextDouble();
                sc.nextLine(); // Limpar buffer
            } while (condominioDTO.despesaComElevador < 0);

            Condominio novoCondominio = condominioService.criarCondominio(condominioDTO);

            System.out.println("Condomínio criado com sucesso!");
            PauseToRead.pause();

            return novoCondominio;

        } catch (Exception e) {
            System.out.println("Erro ao Criar: " + e.getMessage());

            // Pergunta se deseja tentar novamente ou voltar ao menu
            System.out.print("Deseja tentar novamente? (S | N): ");
            Scanner sc = new Scanner(System.in);
            char resposta = sc.next().charAt(0);
            sc.nextLine();

            if (resposta == 'S' || resposta == 's')
                return criar();

            return null;
        }
    }
}
