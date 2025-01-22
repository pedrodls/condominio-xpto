package domain.helpers;

public class Entidade implements IEntidade {

    protected int id;

    private static final long serialVersionUID = 1L;

    public Entidade() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n{\n\tid: " + this.id + "\n";
    }

}
