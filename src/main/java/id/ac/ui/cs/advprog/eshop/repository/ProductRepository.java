package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository extends AbstractRepository<Product> {
    static int id = 0;

    public ProductRepository() {
        this.data = new ArrayList<Product>();
    }

    @Override
    public Product update(String id, Product updatedProduct) {
        for (Product product : data) {
            if (product.getId().equals(id)) {
                product.setName(updatedProduct.getName());
                product.setQuantity(updatedProduct.getQuantity());
                return product;
            }
        }
        return null;
    }
}
