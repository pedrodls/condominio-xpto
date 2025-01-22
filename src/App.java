/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import application.condominio.CondominioDTO;
import application.condominio.CondominioService;
import infrastructure.repositorios.CondominioRepositorio;

/**
 *
 * @author dev
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            CondominioDTO dadosCondominio = new CondominioDTO("Avenida São Silvestre", 2424.0, 432.0,
                    "02/10/2020");

            CondominioService cs = new CondominioService(new CondominioRepositorio());

            //cs.criarCondominio(dadosCondominio);

            System.out.println(cs.buscarCondominio());

            System.out.println(cs.atualizarCondominio(dadosCondominio));

            //System.out.println(cs.buscarCondominio());

            //cs.listarFracoes();

            // System.out.println(cs.verificarEquilibrio());

            // System.out.println(cs.somaPercentagemFracoes());

            // System.out.println(cs.somaQuotaMensal());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
