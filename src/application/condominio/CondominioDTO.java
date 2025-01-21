package application.condominio;

public class CondominioDTO {
    public String morada;
    public double dispesaGeral;
    public String dataConstrucao;
    public double dispesaComElevador;

    public CondominioDTO() {
    }

    public CondominioDTO(String morada, double dispesaGeral, double dispesaComElevador, String dataConstrucao) {
        this.morada = morada;
        this.dispesaGeral = dispesaGeral;
        this.dataConstrucao = dataConstrucao;
        this.dispesaComElevador = dispesaComElevador;
    }

}
