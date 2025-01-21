/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import application.condominio.CondominioDTO;
import application.condominio.CondominioService;
import domain.condominio.Condominio;
import infrastructure.repositorios.CondominioRepositorio;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Teste do CRUD do condominio

        try {
            //CondominioDTO dadosCondominio = new CondominioDTO("Avenida São José", 2424.0, 432.0, "02/10/2020");

            CondominioService cs = new CondominioService(new CondominioRepositorio());

            //Condominio novoCondominio = cs.criarCondominio(dadosCondominio);

            ArrayList<Condominio> dadosCmd = cs.condominioRepositorio.findAll();
            
            dadosCmd.forEach(action -> {
                System.out.println(action.toString());
            });
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
