/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.fracao;

//import domain.proprietario.IProprietario;

/**
 *
 * @author 20220204
 */
public class FracaoDTO {
    public long area;
    public String localizacao;
    //public IProprietario proprietario;
    
    public FracaoDTO() {
        this.area = -1;
        this.localizacao = " ";
    }

    public FracaoDTO(long area, String localizacao) {
        this.area = area;
        this.localizacao = localizacao;
    }
    
}
