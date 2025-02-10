package presentation.controllers.condominio;

import java.util.Scanner;
import java.util.regex.Pattern;

import application.condominio.CondominioDTO;
import application.condominio.CondominioService;
import domain.condominio.Condominio;
import utils.PauseToRead;

public class AtualizarCondominioController {

    private static String regex = "^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static Pattern pattern = Pattern.compile(regex);
    private static char atualizar;

    private static void validacao(String atributo){
        Scanner sc = new Scanner(System.in);

        do{
            if(!(atualizar == 'S' || atualizar == 'N' || atualizar == 's' || atualizar == 'n')){
                System.out.println("Opção inválida!");
                System.out.println(" ");
            }

            System.out.print("Deseja atualizar " + atributo + "? (S | N): ");
            atualizar = sc.next().charAt(0);
        }while(!(atualizar == 'S' || atualizar == 'N' || atualizar == 's' || atualizar == 'n'));

        
        sc.nextLine(); // Limpar buffer
    }

    public static Condominio atualizar(Condominio condominio) {

        try {

            String opAtualizar = "Ss";

            System.out.println("\t-- Atualizando Condominio --\n");

            Scanner sc = new Scanner(System.in);

            CondominioDTO condominioDTO = new CondominioDTO();
            CondominioService condominioService = new CondominioService();

            // Atualizar Morada
            validacao("a morada");

            if (opAtualizar.contains(Character.toString(atualizar))) {
                do {
                    System.out.print("Insira a morada(min 2 caracteres): ");
                    condominioDTO.morada = sc.nextLine();
                } while (condominioDTO.morada.length() < 2);
            } else {
                condominioDTO.morada = condominio.getMorada();
            }

            // Atualizar Data de Construção
            validacao("a data de construção");

            if (opAtualizar.contains(Character.toString(atualizar))) {
                do {
                    System.out.print("Insira a data de construção (DD/MM/YYYY): ");
                    condominioDTO.dataConstrucao = sc.nextLine();

                    if (pattern.matcher(condominioDTO.dataConstrucao).matches()) {
                        break;
                    } else {
                        System.out.println("Formato inválido! Use DD/MM/YYYY.");
                    }
                } while (true);
            } else {
                condominioDTO.dataConstrucao = condominio.getDataConstrucao();
            }

            // Atualizar Despesa Geral
            validacao("o valor da despesa geral");

            if (opAtualizar.contains(Character.toString(atualizar))) {

                do {
                    System.out.print("Insira o valor da despesa geral(valor não negativo): ");
                    condominioDTO.despesaGeral = sc.nextDouble();
                    sc.nextLine();
                } while (condominioDTO.despesaGeral < 0);

                // Limpar buffer
            } else {
                condominioDTO.despesaGeral = condominio.getDespesaGeral();
            }

            // Atualizar Despesa com Elevador
            validacao("o valor da despesa com o elevador");

            if (opAtualizar.contains(Character.toString(atualizar))) {
                do {
                    System.out.print("Insira o valor da despesa com elevador(valor não negativo): ");
                    condominioDTO.despesaComElevador = sc.nextDouble();
                    sc.nextLine(); // Limpar buffer
                } while (condominioDTO.despesaComElevador < 0);
            } else {
                condominioDTO.despesaComElevador = condominio.getDespesaComElevador();
            }

            // Atualiza os dados e retorna o novo condomínio
            Condominio novoCondominio = condominioService.atualizarCondominio(condominioDTO, condominio);

            System.out.println("Condomínio atualizado com sucesso!");
            PauseToRead.pause();
            return novoCondominio;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());

            // Pergunta se deseja tentar no vamente ou voltar ao menu
            System.out.print("Deseja tentar novamente? (S | N): ");
            Scanner sc = new Scanner(System.in);
            char resposta = sc.next().charAt(0);
            sc.nextLine();

            if (resposta == 'S' || resposta == 's')
                return atualizar(condominio);

            return condominio;
        }
    }
}
