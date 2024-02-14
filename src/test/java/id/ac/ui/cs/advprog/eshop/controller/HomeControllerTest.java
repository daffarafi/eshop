package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HomeControllerTest {

    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    void getHomepage() throws Exception {
        String homepage = controller.homepage();
        assertEquals("Homepage", homepage);
    }

}
