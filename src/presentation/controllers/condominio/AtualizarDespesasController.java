package presentation.controllers.condominio;

import java.util.Scanner;

import domain.condominio.Condominio;
import presentation.Menu;
import utils.Constantes;
import utils.PauseToRead;

public class AtualizarDespesasController {


    public static void visualizar(Condominio condominio) throws RuntimeException {

        try {
            Scanner sc = new Scanner(System.in);
            boolean naoSair = true;

            do {

                char opcao = new Menu(Constantes.despesaMenu, "Actualização das Despesas").escolherOpcaoMenu();


                // if(opcao != 2){
                //     
                //     FuncoesMenu.condominio.setDespesaGeral(sc.nextDouble());
                // }
                // if(opcao != 1){
                    

                switch (opcao) {
                    case '1':
                        System.out.println("Novo valor da despesa Geral (casas decimais" +
                             "devem ser separadas por um ponto, exemplo -> 9.5): ");
                        condominio.setDespesaGeral(sc.nextDouble());
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case '2':
                        System.out.println("Novo valor da despesa com o elevador (casas decimais" +
                        "devem ser separadas por um ponto, exemplo -> 9.5): ");
                        condominio.setDespesaComElevador(sc.nextDouble());
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case '3':
                        System.out.println("Novo valor da despesa Geral (casas decimais" +
                        "devem ser separadas por um ponto, exemplo -> 9.5): ");
                        condominio.setDespesaGeral(sc.nextDouble());

                        System.out.println("Novo valor da despesa com o elevador (casas decimais" +
                        "devem ser separadas por um ponto, exemplo -> 9.5): ");
                        condominio.setDespesaComElevador(sc.nextDouble());
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case '4':
                        naoSair = false;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }

            } while (naoSair);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}

