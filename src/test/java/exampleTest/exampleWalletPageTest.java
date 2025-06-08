package exampleTest;

import org.example.pages.walletPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class exampleWalletPageTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/wallet";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testWalletPageElements() {
        // Buka halaman wallet
        driver.get(baseUrl);

        // Buat instance walletPage
        walletPage walletPage = new walletPage(driver);

        // Verifikasi elemen-elemen di halaman wallet
        Assertions.assertEquals(walletPage.textTitle(), "Wallet", "Page title is incorrect!");
        Assertions.assertNotNull(walletPage.textBalance(), "Balance text is missing!");
        Assertions.assertTrue(walletPage.isTxtRecentTransactionDisplayed(), "Recent transaction is not displayed!");
    }

    @Test
    public void testTopupNavigation() {
        // Buka halaman wallet
        driver.get(baseUrl);

        // Buat instance walletPage
        walletPage walletPage = new walletPage(driver);

        // Klik tombol top-up
        walletPage.clickTopup();

        // Verifikasi navigasi ke halaman top-up
        String expectedUrl = "http://skyclub.work.gd/topup";
        Assertions.assertEquals(driver.getCurrentUrl(), expectedUrl, "Navigation to top-up page failed!");
    }

    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}