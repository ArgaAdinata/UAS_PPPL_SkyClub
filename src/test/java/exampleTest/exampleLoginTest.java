package exampleTest;

import org.example.pages.loginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class exampleLoginTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/users/login";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        // Buka halaman login
        driver.get(baseUrl);

        // Buat instance loginPage
        loginPage loginPage = new loginPage(driver);

        // Verifikasi apakah halaman login terbuka
        Assertions.assertEquals(loginPage.getTextTitle(), "Login", "Login failed!");

        // Isi form login
        loginPage.setUsername("test");
        loginPage.setPassword("password");
        //loginPage.clickSignIn();
    }

    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}