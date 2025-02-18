package repository;

import java.util.List;
import java.util.Set;

public interface IRepository<T> {
    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(int id);
    List<T> getAll();
    Set<Integer> getAllIds();
}
