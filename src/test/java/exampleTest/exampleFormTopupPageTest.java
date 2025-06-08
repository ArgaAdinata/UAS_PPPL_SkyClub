package exampleTest;

import org.example.pages.formTopupPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class exampleFormTopupPageTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/topup";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFormTopupPageElements() {
        // Buka halaman form top-up
        driver.get(baseUrl);

        // Buat instance formTopupPage
        formTopupPage formTopupPage = new formTopupPage(driver);

        // Verifikasi elemen-elemen di halaman form top-up
        Assertions.assertEquals(formTopupPage.textTitle(), "Top Up", "Page title is incorrect!");
    }

    @Test
    public void testTopupFunctionality() {
        // Buka halaman form top-up
        driver.get(baseUrl);

        // Buat instance formTopupPage
        formTopupPage formTopupPage = new formTopupPage(driver);

        // Isi nominal top-up
        formTopupPage.setAmount("50000");

        // Klik tombol top-up
        formTopupPage.clickTopup();

        // Verifikasi navigasi atau hasil setelah top-up (contoh: URL berubah atau elemen tertentu muncul)
        String expectedUrl = "http://skyclub.work.gd/topup/success";
        Assertions.assertEquals(driver.getCurrentUrl(), expectedUrl, "Top-up process failed!");
    }

    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}