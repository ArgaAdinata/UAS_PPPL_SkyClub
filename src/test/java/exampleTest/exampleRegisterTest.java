package exampleTest;

import org.example.pages.registerPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class exampleRegisterTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/users/register";

    @Test
    public void testRegister() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Buka halaman register
        driver.get(baseUrl);

        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "johndoe" + System.currentTimeMillis() + "@example.com";

        // Isi form register
        registerPage.setName("John Doe");
        registerPage.setUsername("johndoe123");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("081234567890");
        registerPage.setPassword("password123");
        registerPage.setConfirmPassword("password123");
        registerPage.clickCheckboxTerms();
        //registerPage.clickRegister();
    }
}