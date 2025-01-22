package application;

import java.util.ArrayList;

public interface IRepositorio<T> {
    public T create(T dados);
    public T update(T dados);
    public boolean delete(int id);
    public T findById(int id);
    public ArrayList<T> findAll();
}
