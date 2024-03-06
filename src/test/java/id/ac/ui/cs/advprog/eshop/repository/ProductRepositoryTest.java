package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api. Test;
import org.junit. jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith (MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setName("Sampo Cap Bambang");
        product.setQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getId(), savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getQuantity(), savedProduct.getQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setId("eb558e9f-1039-4600-8860-71af6af63bde");
        product1.setName("Sampo Cap Bambang");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("ebwer233-weqw-312w-1829-13ih2h3u1hu");
        product2.setName("Sampo Cap Usep");
        product2.setQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getId(), savedProduct.getId());
        savedProduct = productIterator.next();
        assertEquals(savedProduct.getId(), product2.getId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setName("Sampo Cap Bambang");
        product.setQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getId(), savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getQuantity(), savedProduct.getQuantity());

        Product editedProduct = new Product();
        editedProduct.setName("Sampo Cap Bambang Baru");
        editedProduct.setQuantity(10);
        productRepository.update("eb558e9f-1039-4600-8860-71af6af63bde", editedProduct);

        productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product newProduct = productIterator.next();
        assertEquals(newProduct.getId(), product.getId());
        assertEquals(newProduct.getName(), editedProduct.getName());
        assertEquals(newProduct.getQuantity(), editedProduct.getQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setName("Sampo Cap Bambang");
        product.setQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        productRepository.delete("eb558e9f-1039-4600-8860-71af6af63bde");

        Iterator<Product> newProductIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindUnique() {
        Product product = new Product();
        product.setId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setName("Sampo Cap Bambang");
        product.setQuantity(100);
        productRepository.create(product);

        Product product2 = new Product();
        product2.setId("ebwer233-weqw-312w-1829-13ih2h3u1hu");
        product2.setName("Sampo Cap Usep");
        product2.setQuantity(50);
        productRepository.create(product2);

        Product product3 = new Product();
        product2.setId("d8s98dwd-f92j-s92j-skd0-dkd01j29j3i");
        product2.setName("Sampo Cap Udin");
        product2.setQuantity(25);
        productRepository.create(product2);

        Product testedProduct = productRepository.find("ebwer233-weqw-312w-1829-13ih2h3u1hu");
        assertEquals(testedProduct, product2);
    }
}
