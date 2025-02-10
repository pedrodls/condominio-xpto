package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;

import domain.condominio.Condominio;
import domain.fracao.Fracao;

import utils.PauseToRead;

public class VerFracaoController {

    public static void visualizar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.print("Insira o id da Fração: ");
            int id = sc.nextInt();
            sc.nextLine();

            Fracao fracao = condominio.buscarFracao(id);

            if (fracao == null) {
                System.out.println("Fração não encontrada!");
            } else {
                System.out.println("Dados da Fração: ");
                System.out.println(fracao.toString());
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage() != null ? e.getMessage() : "Erro de entrada!");
        } finally {
            PauseToRead.pause();
        }

    }

}
