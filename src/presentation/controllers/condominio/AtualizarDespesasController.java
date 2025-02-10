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
            
            Double temp;

            do {

                String opcao = new Menu(Constantes.DESPESA_MENU, "Actualização das Despesas").escolherOpcaoMenu();
                    

                switch (opcao) {
                    case "1":

                        do{
                            System.out.println("Novo valor da despesa Geral (casas decimais" +
                             "devem ser separadas por um ponto, exemplo -> 9.5): ");

                            temp = sc.nextDouble();
                        }while(temp < 0);
                        
                        condominio.setDespesaGeral(temp);
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case "2":

                        do{
                            System.out.println("Novo valor da despesa com o elevador (casas decimais" +
                                "devem ser separadas por um ponto, exemplo -> 9.5): ");

                            temp = sc.nextDouble();
                        }while(temp < 0);
                        
                        condominio.setDespesaComElevador(temp);
                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case "3":

                        do{
                            System.out.println("Novo valor da despesa Geral (casas decimais" +
                            "devem ser separadas por um ponto, exemplo -> 9.5): ");

                            temp = sc.nextDouble();
                        }while(temp < 0);
                        
                        condominio.setDespesaGeral(temp);

                        do{
                            System.out.println("Novo valor da despesa com o elevador (casas decimais" +
                                "devem ser separadas por um ponto, exemplo -> 9.5): ");

                            temp = sc.nextDouble();
                        }while(temp < 0);
                        
                        condominio.setDespesaComElevador(temp);

                        PauseToRead.pause();
                        System.out.flush();
                        break;
                    case "4":
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

