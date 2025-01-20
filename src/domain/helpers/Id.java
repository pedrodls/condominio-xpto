package domain.helpers;

public class Id {
    private String descricao;

    public Id() {
        this.generateId();
    }

    public String getDescricao() {
        return descricao;
    }

    private void generateId() {
        this.descricao = (System.currentTimeMillis() + "").substring(4, 7);
    }

}
