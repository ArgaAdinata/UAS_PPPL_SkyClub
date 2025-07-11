package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

public class BookingSteps {
    private WebDriver driver = BaseSteps.driver;
    private fieldDetailsPage fieldDetailsPage;
    private paymentPage paymentPage;
    private paymentSuccessPage paymentSuccessPage;
    private final String fieldDetailsUrl = "http://skyclub.my.id/field-schedule";
    private final String paymentUrl = "http://skyclub.my.id/payment";
    private final String paymentSuccessUrl = "http://skyclub.my.id/payment/success";

    @Before("@requires_login")
    public void pengguna_sudah_login() {
        driver.manage().window().maximize();
        driver.get("http://skyclub.my.id/users/login");
        loginPage loginPage = new loginPage(driver);
        loginPage.setUsername("test");
        loginPage.setPassword("password");
        loginPage.clickSignIn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Before("@requires_login2")
    public void pengguna_sudah_login2() {
        driver.manage().window().maximize();
        driver.get("http://skyclub.my.id/users/login");
        loginPage loginPage = new loginPage(driver);
        loginPage.setUsername("test4");
        loginPage.setPassword("qwertymnb01");
        loginPage.clickSignIn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("Pengguna berada pada halaman detail lapangan")
    public void pengguna_berada_pada_halaman_detail_lapangan() {
        driver.get(fieldDetailsUrl);
        fieldDetailsPage = new fieldDetailsPage(driver);
    }

    @Given("Pengguna memiliki saldo yang cukup")
    public void pengguna_memiliki_saldo_yang_cukup() {
        basePage basePage = new basePage(driver);
        basePage.clickEye();
        Assertions.assertTrue(basePage.getBalance() > 60000);
    }

    @Given("Pengguna tidak memiliki saldo yang cukup")
    public void pengguna_tidak_memiliki_saldo_yang_cukup() {
        basePage basePage = new basePage(driver);
        basePage.clickEye();
        Assertions.assertTrue(basePage.getBalance() < 60000);
    }

    @When("Pengguna memilih jadwal yang tersedia")
    public void pengguna_memilih_jadwal_yang_tersedia() {
        fieldDetailsPage.selectAvailableSchedule();
    }

    @When("Pengguna tidak memilih jadwal apapun")
    public void pengguna_tidak_memilih_jadwal_apapun() {
        // Tidak melakukan pemilihan jadwal
    }

    @When("Pengguna menuju ke halaman pembayaran")
    public void pengguna_menuju_ke_halaman_pembayaran() {
        fieldDetailsPage.goToPaymentPage();
    }

    @When("Pengguna menyelesaikan pemesanan")
    public void pengguna_menyelesaikan_pemesanan() {
        paymentPage = new paymentPage(driver);
        paymentPage.clickPayment();
    }

    @Then("Sistem membuat jadwal lapangan dipesan")
    public void sistem_membuat_jadwal_lapangan_dipesan() {
        paymentSuccessPage = new paymentSuccessPage(driver);
        Assertions.assertTrue(paymentSuccessPage.isTxtSuccessDisplayed());
    }

    @Then("Saldo Pengguna dikurangi")
    public void saldo_pengguna_dikurangi() {
        basePage basePage = new basePage(driver);
        basePage.clickEye();
        Integer balanceBefore = basePage.getBalanceValue();
        Integer totalPayment = paymentPage.getTotalPayment();
        Assertions.assertTrue((balanceBefore-totalPayment) == basePage.getBalance());
    }

    @Then("Slot penyewaan pada waktu tersebut tidak tersedia untuk pengguna lain")
    public void slot_penyewaan_pada_waktu_tersebut_tidak_tersedia_untuk_pengguna_lain() {
        // Verifikasi slot tidak tersedia
    }

    @Then("Sistem menampilkan pesan {string}")
    public void sistem_menampilkan_pesan(String message) {
        if (message.equals("saldo tidak cukup")) {
            Assertions.assertTrue(paymentPage.isModalErrorDisplayed());
        } else if (message.equals("Pilih jadwal terlebih dahulu")) {
            Assertions.assertTrue(fieldDetailsPage.isScheduleErrorDisplayed());
        }
    }

    @Then("Saldo pengguna tidak berubah pada halaman pembayaran")
    public void saldo_pengguna_tidak_berubah_pada_pembayaran() {
        basePage basePage = new basePage(driver);
        Integer initialBalance = basePage.getBalanceValue();
        basePage.clickEye();
        Integer afterBalance = basePage.getBalance();
        Assertions.assertEquals(initialBalance, afterBalance);
    }

    @Then("Pesanan gagal")
    public void pesanan_gagal() {
        Assertions.assertNotEquals(paymentSuccessUrl, driver.getCurrentUrl());
    }

    @Then("Saldo pengguna tidak berubah di booking")
    public void saldo_pengguna_tidak_berubah() {
        // Verifikasi saldo tidak berubah
    }

    @Then("Slot penyewaan tetap tersedia")
    public void slot_penyewaan_tetap_tersedia() {
        // Verifikasi slot masih tersedia
    }

    @Then("Pengguna tetap berada di halaman detail lapangan")
    public void pengguna_tetap_berada_di_halaman_detail_lapangan() {
        Assertions.assertEquals(fieldDetailsUrl, driver.getCurrentUrl());
    }
}