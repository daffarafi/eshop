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
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl service;


    @Test
    public void testDeleteProduct() {
        service.create(new Product());

        List<Product> beforeDeleteProducts = service.findAll();
        System.out.println(beforeDeleteProducts.size());

        assertEquals(beforeDeleteProducts.size(), 1);

        service.delete(0);
        List<Product> afterDeleteProducts = service.findAll();
        assertEquals(afterDeleteProducts.size(), 0);
    }

    @Test
    public void testEditProduct() {
        Product oldProduct = new Product();
        oldProduct.setProductId("eb558e9f-1039-4600-8860-71af6af63bde");
        oldProduct.setProductName("Sampo Cap Bambang");
        oldProduct.setProductQuantity(100);
        service.create(oldProduct);

        Product newProduct = new Product();
        newProduct.setProductName("Sampo Cap Bambang Baru");
        newProduct.setProductQuantity(50);

        service.editProduct(0, newProduct);

        Product editedProduct = service.getProductById(0);

        assertEquals(editedProduct.getProductQuantity(), newProduct.getProductQuantity());
        assertEquals(editedProduct.getProductName(), newProduct.getProductName());

        service.delete(0);
    }

    @Test
    public void testFindAll() {
        service.create(new Product());
        service.create(new Product());
        service.create(new Product());

        List<Product> products = service.findAll();
        assertEquals(3, products.size());

        service.delete(0);
        service.delete(0);
        service.delete(0);
    }
}
