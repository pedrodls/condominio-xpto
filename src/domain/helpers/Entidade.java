package domain.helpers;

import java.io.Serializable;

public class Entidade implements Serializable {

    protected Id id;
    private static final long serialVersionUID = 1L;

    public Entidade() {
        this.id = new Id();
    }

    public String getId() {
        return this.id.getDescricao();
    }

    @Override
    public String toString() {
        return "\n{\n\tid: " + this.id.getDescricao() + "\n";
    }

}
