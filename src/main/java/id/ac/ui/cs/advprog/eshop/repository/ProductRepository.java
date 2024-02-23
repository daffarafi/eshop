package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    static int id = 0;

    private List<Product> productData = new ArrayList<Product>();
    public Product create(Product product) {
        if (product.getId() == null) {
            UUID uuid = UUID.randomUUID();
            product.setId(uuid.toString());
        }

        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product find(String id) {
        for (Product product: productData) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
    public Product update(String id, Product updatedProduct) {
        for (Product product : productData) {
            if (product.getId().equals(id)) {
                product.setName(updatedProduct.getName());
                product.setQuantity(updatedProduct.getQuantity());
                return product;
            }
        }
        return null;
    }

    public void delete(String id ) {productData.removeIf(product -> product.getId().equals(id));}
}
