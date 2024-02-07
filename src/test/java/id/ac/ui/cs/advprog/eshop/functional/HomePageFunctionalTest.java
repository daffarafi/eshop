package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class HomePageFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        assertEquals("ADV Shop", pageTitle);
    }

    @Test
    void welcomeMessage_homePage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();

        assertEquals("Welcome", welcomeMessage);
    }

    @Test
    void listProduct_titleMessage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");
        String titleMessage = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Product' List", titleMessage);

    }

    @Test
    void createProduct_titleMessage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        String titleMessage = driver.findElement(By.tagName("h3")).getText();
        assertEquals(titleMessage, "Create New Product");
    }
    @Test
    void createNewProduct(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        WebElement submitBtn = driver.findElement(By.tagName("button"));

        nameInput.sendKeys("Product Baru");
        quantityInput.sendKeys("10");
        submitBtn.click();

        driver.get(baseUrl + "/product/list");

        String nameProduct = driver.findElement(By.tagName("td")).getText();
        assertEquals("Product Baru", nameProduct);
    }
}
