package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private List<Product> products;

    @BeforeEach
    void setup() {
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId("dwad2h3h-s9d2-132s-s012-123dw1e12wd1");
        product1.setName("Sampo Cap Bambang");
        product1.setQuantity(2);
        Product product2 = new Product();
        product2.setId("sdi29378-20si-20su-w8uj-2039183dheu9");
        product2.setName("Sabun Cap Usep");
        product2.setQuantity(1);
        this.products.add(product1);
        this.products.add(product2);
    }

    @Test
    void testCreateOrderEmptyProduct() {
        this.products.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Order order = new Order("1238d7d2d-20s9-d8ef-19d8s7d9eh12", this.products, 128560000L, "Safira Sudrajat");
        });
    }

    @Test
    void testCreateOrderDefaultStatus() {
        Order order = new Order("12312312-1234-1234-1234-123412341234", this.products, 17608560000L, "Safira Sudrajat");

        assertSame(this.products, order.getProducts());
        assertEquals(2, order.getProducts().size());
        assertEquals("Sampo Cap Bambang", order.getProducts().get(0).getName());
        assertEquals("Sabun Cap Usep", order.getProducts().get(1).getName());

        assertEquals("12312312-1234-1234-1234-123412341234", order.getId());
        assertEquals(17608560000L, order.getOrderTime());
        assertEquals("Safira Sudrajat", order.getAuthor());
        assertEquals("WAITING_PAYMENT", order.getStatus());
    }

    @Test
    void testCreateOrderSuccessStatus() {
        Order order = new Order("12341234-1234-1234-1234-123412341234", this.products, 1788560000L, "Safira Sudrajat", "SUCCESS");
        assertEquals("SUCCESS", order.getStatus());
    }

    @Test
    void testCreateOrderInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            Order order = new  Order("12341234-1234-1234-1234-123412341234",
                    this.products, 1708560000L, "Safira Sudrajat", "MEOW");
        });
    }
    @Test
    void testSetStatusToCancelled() {
        Order order = new Order("12341234-1234-1234-1234-123412341234", this.products, 1708560000L, "Safira Sudrajat");

        order.setStatus("CANCELLED");
        assertEquals("CANCELLED", order.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Order order = new Order("12341234-1234-1234-1234-123412341234", this.products, 1708560000L, "Safira Sudrajat");
        assertThrows(IllegalArgumentException.class, () -> order.setStatus("MEOW"));
    }
}
