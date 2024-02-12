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
        product.setProductId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1039-4600-8860-71af6af63bde");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("ebwer233-weqw-312w-1829-13ih2h3u1hu");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(savedProduct.getProductId(), product2.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());

        Product editedProduct = new Product();
        editedProduct.setProductName("Sampo Cap Bambang Baru");
        editedProduct.setProductQuantity(10);
        productRepository.editById(0, editedProduct);

        productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product newProduct = productIterator.next();
        assertEquals(newProduct.getProductId(), product.getProductId());
        assertEquals(newProduct.getProductName(), editedProduct.getProductName());
        assertEquals(newProduct.getProductQuantity(), editedProduct.getProductQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        productRepository.delete(0);

        Iterator<Product> newProductIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindUnique() {
        Product product = new Product();
        product.setProductId("eb558e9f-1039-4600-8860-71af6af63bde");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product product2 = new Product();
        product2.setProductId("ebwer233-weqw-312w-1829-13ih2h3u1hu");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product product3 = new Product();
        product2.setProductId("d8s98dwd-f92j-s92j-skd0-dkd01j29j3i");
        product2.setProductName("Sampo Cap Udin");
        product2.setProductQuantity(25);
        productRepository.create(product2);

        Product testedProduct = productRepository.findUnique(1);
        assertEquals(testedProduct, product2);
    }
}
