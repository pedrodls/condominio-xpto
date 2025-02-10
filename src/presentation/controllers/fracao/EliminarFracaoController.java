package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;

import domain.condominio.Condominio;
import domain.fracao.Fracao;

import utils.PauseToRead;

public class EliminarFracaoController {

    public static void eliminar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            if (!(condominio.getAreaTotal() > 0)) {
                System.out.println("Não existem frações disponíveis!");
                return;
            }
            
            Scanner sc = new Scanner(System.in);

            if (!(condominio.getAreaTotal() > 0)) {
                System.out.println("Não existem frações disponíveis!");
                return;
            }

            System.out.print("Insira o id da Fração: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (!condominio.retirarFracao(id)) {
                System.out.println("Fração não encontrada!");
                return;
            }

            System.out.println("Fração eliminada com sucesso: ");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage() != null ? e.getMessage() : "Erro de entrada!");
        } finally {
            PauseToRead.pause();
        }

    }

}
