package domain.helpers;

public class Entidade {
    protected Id id;

    public Entidade() {
        this.id = new Id();
    }

    public String getId() {
        return this.id.getDescricao();
    }

}
