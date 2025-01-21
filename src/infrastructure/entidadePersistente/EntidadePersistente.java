package infrastructure.entidadePersistente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class EntidadePersistente<T extends Serializable> {

    private String nomeFicheiro;

    public EntidadePersistente(String nomeFicheiro) {
        this.nomeFicheiro = nomeFicheiro;
    }

    public void salvarTodosDados(ArrayList<T> dados) throws Error {
        try (FileOutputStream fos = new FileOutputStream(this.nomeFicheiro, false);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(dados);

            oos.close();

        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ArrayList<T> getTodosDados() throws Error {
        try (FileInputStream fis = new FileInputStream(this.nomeFicheiro);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
    
            // Lê os dados do arquivo e os armazena em dadosResults
            ArrayList<T> dadosResults = (ArrayList<T>) ois.readObject();
    
            // Retorna os dados lidos do arquivo
            return dadosResults;
    
        } catch (FileNotFoundException e) {
            // Retorna uma lista vazia caso o arquivo não seja encontrado
            System.err.println("Arquivo não encontrado: " + this.nomeFicheiro);
            return new ArrayList<>();
        } catch (Exception e) {
            // Imprime a pilha de erros para melhor diagnóstico
            e.printStackTrace();
            // Lança um erro com a mensagem original
            throw new Error("Erro ao ler dados do arquivo!");
        }
    }
    
    

}
