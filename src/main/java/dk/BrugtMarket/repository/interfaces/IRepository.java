package dk.BrugtMarket.repository.interfaces;

import java.util.List;

public interface IRepository<T> {
    public void remove(String id);
    public List<T> getAll();
    public void insert(T entity);
    public T getById(String id);
}
