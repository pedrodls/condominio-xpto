package infrastructure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import utils.Constantes;

public class Persistente<T extends Serializable> {

    private String nomeFicheiro;

    public Persistente() {
        this.nomeFicheiro = Constantes.condominioFIle;
    }

    public void set(T dados) throws RuntimeException {
        try (
                FileOutputStream fos = new FileOutputStream(this.nomeFicheiro, false);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(dados);

            oos.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public T get() throws RuntimeException {
        try (FileInputStream fis = new FileInputStream(this.nomeFicheiro);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (T) ois.readObject();

        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler dados do arquivo!");
        }
    }

}
