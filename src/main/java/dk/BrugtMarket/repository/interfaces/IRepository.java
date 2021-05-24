package dk.BrugtMarket.repository.interfaces;

import dk.BrugtMarket.domain.Id;

import java.util.List;

public interface IRepository<T> {
    public void remove(Id id);
    public List<T> getAll();
    public void insert(T entity);
    public T getById(Id id);
}
