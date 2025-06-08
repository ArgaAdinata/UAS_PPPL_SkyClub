package exampleTest;

import org.example.pages.paymentSuccessPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class examplePaymentSuccessPageTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/payment-success";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testPaymentSuccessPageElements() {
        // Buka halaman payment success
        driver.get(baseUrl);

        // Buat instance paymentSuccessPage
        paymentSuccessPage paymentSuccessPage = new paymentSuccessPage(driver);

        // Verifikasi elemen teks sukses
        Assertions.assertTrue(paymentSuccessPage.isTxtSuccessDisplayed(), "Success text is not displayed!");
    }

    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}