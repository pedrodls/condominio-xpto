package domain.helpers;

import java.io.Serializable;
import java.util.UUID;

public class Id implements Serializable {
    private String descricao;
    private static final long serialVersionUID = 1L;

    public Id() {
        this.generateId();
    }

    public String getDescricao() {
        return descricao;
    }

    private void generateId() {
        this.descricao = UUID.randomUUID().toString().substring(4, 8);
    }

}
