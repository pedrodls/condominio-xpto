package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;


import application.fracao.loja.LojaDTO;
import application.fracao.loja.LojaService;
import domain.condominio.Condominio;
import domain.fracao.Fracao;
import domain.fracao.loja.Loja;
import utils.PauseToRead;

public class CriarLojaController {

    public static void criar(Condominio condominio) throws RuntimeException, ParseException {

        try {

            Fracao fracao = CriarFracaoController.criar(condominio, "Loja");

            LojaDTO lojaDTO = new LojaDTO();

            if (fracao == null)
                throw new RuntimeException("Erro de validação!");

            lojaDTO.id = fracao.getId();
            lojaDTO.area = fracao.getArea();
            lojaDTO.localizacao = fracao.getLocalizacao();
            lojaDTO.proprietario = fracao.getProprietario();

            Loja loja = new LojaService(condominio).add(lojaDTO);

            if (loja == null)
                throw new RuntimeException("Erro ao criar loja.");

            System.out.println("Loja criada com sucesso!");
            System.out.println(loja.toString());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            PauseToRead.pause();
            System.out.flush();
        }

    }
}
