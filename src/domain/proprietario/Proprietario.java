package domain.proprietario;

import java.util.Date;
import java.util.Objects;

import domain.helpers.Entidade;

public class Proprietario extends Entidade implements IProprietario {

    private String nome;
    private String morada;
    private String telefone;
    private String telemovel;
    private String email;
    private Date dataNascimento;

    public Proprietario() {

    }

    public Proprietario(
            String nome,
            String morada,
            String telefone,
            String telemovel,
            String email,
            Date dataNascimento) {
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {

        return "\n\t\t{\n" +
                "\t\tid: " + this.getId() + "\n" +
                "\t\tnome: " + this.nome + "\n" +
                "\t\tmorada: " + this.morada + "\n" +
                "\t\ttelefone: " + this.telefone + "\n" +
                "\t\ttelemovel: " + this.telemovel + "\n" +
                "\t\temail: " + this.email + "\n" +
                "\t\tdataNascimento: " + this.dataNascimento + "\n" +
                "\t}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Proprietario that = (Proprietario) obj;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(morada, that.morada) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(telemovel, that.telemovel) &&
                Objects.equals(email, that.email) &&
                Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, morada, telefone, telemovel, email, dataNascimento);
    }
}
