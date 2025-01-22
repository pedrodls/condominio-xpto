package application.condominio;

public class CondominioDTO {
    public String morada;
    public double despesaGeral;
    public String dataConstrucao;
    public double despesaComElevador;

    public CondominioDTO(String morada, double despesaGeral, double despesaComElevador, String dataConstrucao) {
        this.morada = morada;
        this.despesaGeral = despesaGeral;
        this.dataConstrucao = dataConstrucao;
        this.despesaComElevador = despesaComElevador;
    }

}
