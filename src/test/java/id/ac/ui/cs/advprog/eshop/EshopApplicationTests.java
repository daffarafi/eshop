package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EshopApplicationTests {

    @Autowired
    private EshopApplication application;

    @Test
    void contextLoads() {
        assertNotNull(application);
    }

    @Test
    public void main() {
        application.main(new String[] {});
    }
}
