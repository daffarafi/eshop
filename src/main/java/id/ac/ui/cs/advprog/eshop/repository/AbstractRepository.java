package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

abstract class AbstractRepository<T extends Product> {
    protected List<T> data;

    public AbstractRepository() {
        this.data = new ArrayList<T>();
    }

    public T create(T entity) {
        if (entity.getId() == null) {
            UUID uuid = UUID.randomUUID();
            entity.setId(uuid.toString());
        }
        data.add(entity);
        return entity;
    }

    public Iterator<T> findAll() {
        return data.iterator();
    }

    public T find(String id) {
        for (T entity : data) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    public abstract T update(String id, T updatedEntity);

    public void delete(String id) {
        data.removeIf(entity -> entity.getId().equals(id));
    }
}