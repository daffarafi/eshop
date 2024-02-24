package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService<T extends Product> {
    public T create(T product);
    public List<T> findAll();
    T find(String productId);
    public T update(String productId, T id);
    public void delete(String productId);

}
