package exampleTest;

import org.example.pages.homePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class exampleHomePageTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePageElements() {
        // Buka halaman home
        driver.get(baseUrl);

        // Buat instance homePage
        homePage homePage = new homePage(driver);

        // Verifikasi elemen-elemen di halaman home
        Assertions.assertTrue(homePage.isRegisterBtnDisplayed(), "Register button is not displayed!");
        Assertions.assertTrue(homePage.isLoginBtnDisplayed(), "Login button is not displayed!");
        Assertions.assertTrue(homePage.isWalletBtnDisplayed(), "Wallet button is not displayed!");

        // Verifikasi judul halaman
        String expectedTitle = "SkyClub";
        Assertions.assertEquals(homePage.getTitle(), expectedTitle, "Page title is incorrect!");
    }

    @Test
    public void testNavigationToRegisterPage() {
        // Buka halaman home
        driver.get(baseUrl);

        // Buat instance homePage
        homePage homePage = new homePage(driver);

        // Klik tombol register
        homePage.clickRegister();

        // Verifikasi navigasi ke halaman register
        String expectedUrl = "http://skyclub.work.gd/users/register";
        Assertions.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to register page failed!");
    }

    @Test
    public void testNavigationToLoginPage() {
        // Buka halaman home
        driver.get(baseUrl);

        // Buat instance homePage
        homePage homePage = new homePage(driver);

        // Klik tombol login
        homePage.clickLogin();

        // Verifikasi navigasi ke halaman login
        String expectedUrl = "http://skyclub.work.gd/users/login";
        Assertions.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to login page failed!");
    }

    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}