/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import application.condominio.CondominioService;
import domain.condominio.Condominio;
import presentation.MenuGeral;

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

            Condominio condominio = new CondominioService().buscarCondominio();

            if (condominio == null)
                new MenuGeral().renderizarMenuInicial();
            else
                new MenuGeral(condominio).renderizarMenu();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
