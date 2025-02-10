package presentation.controllers.fracao;

import java.text.ParseException;
import java.util.Scanner;

import application.condominio.useCases.CriarProprietarioUseCase;
import application.fracao.ProprietarioDTO;
import domain.condominio.Condominio;
import domain.proprietario.Proprietario;
import utils.PauseToRead;
import utils.UtilDate;
import utils.UtilValidator;

public class CriarProprietarioController {

    public static Proprietario criar(Condominio condominio) throws RuntimeException, ParseException {


        try {

            Proprietario novoProprietario;

            ProprietarioDTO proprietarioDTO = new ProprietarioDTO();

            Scanner sc = new Scanner(System.in);

            System.out.println("\t-- Criando Proprietário --\n");

            System.out.println("Insira os dados do proprietário...");

            do {
                System.out.printf("Nome completo(2 caracteres no minimo): ");
                proprietarioDTO.nome = sc.nextLine();
            } while (proprietarioDTO.nome.length() < 2);

            System.out.printf("Morada: ");
            proprietarioDTO.morada = sc.nextLine();

            do {
                System.out.printf("Telefone(9XXXXXXXX | 22XXXXXXX): ");
                proprietarioDTO.telefone = sc.nextLine();

                if (!UtilValidator.validarNumeroContacto(proprietarioDTO.telefone))
                    System.out.println("Telefone inválido");

            } while (!UtilValidator.validarNumeroContacto(proprietarioDTO.telefone));

            do {

                System.out.printf("Telemóvel(9XXXXXXXX): ");
                proprietarioDTO.telemovel = sc.nextLine();

                if (!UtilValidator.validarNumeroContacto(proprietarioDTO.telemovel))
                    System.out.println("Telemóvel inválido");

            } while (!UtilValidator.validarNumeroContacto(proprietarioDTO.telemovel));

            do {
                System.out.printf("Email: ");
                proprietarioDTO.email = sc.nextLine();
                if (!UtilValidator.validarEmail(proprietarioDTO.email))
                    System.out.println("Email inválido!");
            } while (!UtilValidator.validarEmail(proprietarioDTO.email));

            do {
                System.out.printf("Data de nascimento(DD/MM/YYYY): ");
                String auxDataString = sc.nextLine();

                if (UtilDate.validarData(auxDataString)) {
                    proprietarioDTO.dataNascimento = UtilDate.stringToDate(auxDataString);
                    break;
                } else {
                    System.out.println("Formato inválido! Use DD/MM/YYYY.");
                }
            } while (true);

            novoProprietario = new CriarProprietarioUseCase(proprietarioDTO, condominio).getProprietario();

            if (novoProprietario == null) {
                System.out.println("Este proprietário já existe!");
            } else {
                System.out.println("Proprietário criado com sucesso!");
            }
            
            PauseToRead.pause();
            System.out.flush();

            return novoProprietario;

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
