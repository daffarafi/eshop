package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @InjectMocks
    private ProductController controller;

    @Mock
    private Model model;

    @Mock
    private ProductServiceImpl service;


    @Test
    void contextLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    void getProductListPage() throws Exception {
        String page = controller.productListPage(model);
        assertEquals("ListProduct", page);
    }

    @Test
    void getEditProductPage() throws Exception {
        when(service.getProductById(0)).thenReturn(new Product());

        String page = controller.editProductPage(0, model);
        assertEquals("EditProduct", page);
    }

    @Test
    void createProductPage() throws Exception {
        String page = controller.createProductPage(model);
        assertEquals("createProduct", page);
    }

    @Test
    void editProductPage() throws Exception {
        when(service.getProductById(0)).thenReturn(new Product());

        String page = controller.editProductPage(0, model);

        assertEquals("EditProduct", page);
    }

    @Test
    void deleteProductRedirectToListPage() throws Exception {
        String page = controller.deleteProduct(0);
        assertEquals("redirect:/product/list", page);
    }

    @Test
    void createProductPostRedirectToListPage() throws Exception {
        String page = controller.createProductPost(new Product());
        assertEquals("redirect:list", page);
    }

    @Test
    void editProductRedirectToListPage() throws Exception {
        String page = controller.editProduct(0, new Product(), model);

        assertEquals("redirect:/product/list", page);
    }
}
