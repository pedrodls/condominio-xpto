package application;

import java.util.ArrayList;

public interface IRepositorio<T> {
    public T create(T dados);
    public boolean update(T dados);
    public boolean delete(String id);
    public T findById(String id);
    public ArrayList<T> findAll();
}
