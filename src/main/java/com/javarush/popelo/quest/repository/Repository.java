package com.javarush.popelo.quest.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository<K, T> {
    protected Map<K, T> repository = new HashMap<>();

    public void save(K id, T entity) {
        repository.put(id, entity);
    }

    public T getById(K id) {
        return repository.get(id);
    }

    public boolean isExists(K id) {
        return repository.containsKey(id);
    }

    public boolean isEmpty() {
        return repository.isEmpty();
    }

    public int count() {
        return repository.size();
    }

}
