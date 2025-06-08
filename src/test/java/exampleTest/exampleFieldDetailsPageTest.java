package exampleTest;

import org.example.pages.fieldDetailsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class exampleFieldDetailsPageTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/field-details";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFieldDetailsPageElements() {
        // Buka halaman field details
        driver.get(baseUrl);

        // Buat instance fieldDetailsPage
        fieldDetailsPage fieldDetailsPage = new fieldDetailsPage(driver);

        // Pilih jadwal tertentu
        fieldDetailsPage.selectSchedule(24);

        // Klik tombol pembayaran
        fieldDetailsPage.clickPayment();

        // Verifikasi navigasi atau elemen setelah pembayaran
        String expectedUrl = "http://skyclub.work.gd/payment";
        Assertions.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to payment page failed!");
    }

    @Test
    public void testMobilePaymentFunctionality() {
        // Buka halaman field details
        driver.get(baseUrl);

        // Buat instance fieldDetailsPage
        fieldDetailsPage fieldDetailsPage = new fieldDetailsPage(driver);

        // Pilih jadwal tertentu
        fieldDetailsPage.selectSchedule(24);

        // Klik tombol pembayaran mobile
        fieldDetailsPage.clickMobilePayment();

        // Verifikasi navigasi atau elemen setelah pembayaran mobile
        String expectedUrl = "http://skyclub.work.gd/mobile-payment";
        Assertions.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to mobile payment page failed!");
    }

    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}