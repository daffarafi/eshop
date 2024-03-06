package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl service;


    @Test
    void testDeleteProduct() {
        Product newProduct = new Product();
        service.create(newProduct);

        List<Product> beforeDeleteProducts = service.findAll();
        System.out.println(beforeDeleteProducts.size());

        assertEquals(1, beforeDeleteProducts.size());

        service.delete(newProduct.getId());
        List<Product> afterDeleteProducts = service.findAll();
        assertEquals(0, afterDeleteProducts.size());
    }

    @Test
    void testEditProduct() {
        Product oldProduct = new Product();
        oldProduct.setId("eb558e9f-1039-4600-8860-71af6af63bde");
        oldProduct.setName("Sampo Cap Bambang");
        oldProduct.setQuantity(100);
        service.create(oldProduct);

        Product newProduct = new Product();
        newProduct.setName("Sampo Cap Bambang Baru");
        newProduct.setQuantity(50);

        service.update("eb558e9f-1039-4600-8860-71af6af63bde", newProduct);

        Product editedProduct = service.find("eb558e9f-1039-4600-8860-71af6af63bde");

        assertEquals(editedProduct.getQuantity(), newProduct.getQuantity());
        assertEquals(editedProduct.getName(), newProduct.getName());

        service.delete("eb558e9f-1039-4600-8860-71af6af63bde");
    }

    @Test
    void testFindAll() {
        Product newProduct1 = new Product();
        Product newProduct2 = new Product();
        Product newProduct3 = new Product();
        service.create(newProduct1);
        service.create(newProduct2);
        service.create(newProduct3);

        List<Product> products = service.findAll();
        assertEquals(3, products.size());

        service.delete(newProduct1.getId());
        service.delete(newProduct2.getId());
        service.delete(newProduct3.getId());
    }
}
