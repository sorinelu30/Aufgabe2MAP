package repository;

import model.Charakter;
import model.Produkt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InMemoryRepository<T> implements IRepository<T> {
    private final Map<Integer, T> repo = new HashMap<>();
    private int currentId = 1;

    @Override
    public void create(T entity) {
        if (entity instanceof Charakter c) {
            repo.put(c.getId(), entity);
        } else if (entity instanceof Produkt) {
            repo.put(currentId++, entity);
        }
    }

    @Override
    public T read(int id) {
        return repo.get(id);
    }

    @Override
    public void update(T entity) {
        if (entity instanceof Charakter c && repo.containsKey(c.getId())) {
            repo.put(c.getId(), entity);
        }
    }

    @Override
    public void delete(int id) {
        repo.remove(id);
    }

    @Override
    public List<T> getAll() {
        return repo.values().stream().toList();
    }

    @Override
    public Set<Integer> getAllIds() {
        return repo.keySet();
    }
}
