package domain.proprietario;

import java.util.Date;

public interface IProprietario {

    public String getNome();

    public void setNome(String nome);

    public String getMorada();

    public void setMorada(String morada);

    public String getTelefone();

    public void setTelefone(String telefone);

    public String getTelemovel();

    public void setTelemovel(String telemovel);

    public String getEmail();

    public void setEmail(String email);

    public Date getDataNascimento();

    public void setDataNascimento(Date dataNascimento);
}
