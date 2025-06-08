package exampleTest;

import org.example.pages.paymentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class examplePaymentPageTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/payment";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testPaymentButtonFunctionality() {
        // Buka halaman pembayaran
        driver.get(baseUrl);

        // Buat instance paymentPage
        paymentPage paymentPage = new paymentPage(driver);

        // Klik tombol pembayaran
        paymentPage.clickPayment();

        // Verifikasi apakah modal error muncul
        Assertions.assertTrue(paymentPage.isModalErrorDisplayed(), "Error modal is not displayed!");
    }

    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}