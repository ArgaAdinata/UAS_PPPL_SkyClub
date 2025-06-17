package stepDefinitions;

import io.cucumber.java.en.*;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

public class TopupSteps {
    private WebDriver driver;
    private formTopupPage formTopupPage;
    private final String walletUrl = "http://skyclub.my.id/wallet";

    @Given("Pengguna sudah login")
    public void pengguna_sudah_login() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Asumsi sudah login
    }

    @Given("Pengguna berada pada halaman dompet")
    public void pengguna_berada_pada_halaman_dompet() {
        driver.get(walletUrl);
        formTopupPage = new formTopupPage(driver);
    }

    @When("Pengguna memasukkan nominal top up {string}")
    public void pengguna_memasukkan_nominal_top_up(String amount) {
        formTopupPage.tryInputAmount(amount);
    }

    @When("Pengguna menyelesaikan proses pembayaran")
    public void pengguna_menyelesaikan_proses_pembayaran() {
        formTopupPage.clickTopup();
    }

    @When("Pengguna menekan tombol top up")
    public void pengguna_menekan_tombol_top_up() {
        formTopupPage.clickTopup();
    }

    @When("Pengguna membiarkan field nominal top up kosong")
    public void pengguna_membiarkan_field_nominal_top_up_kosong() {
        // Tidak melakukan input
    }

    @When("Pengguna mencoba memasukkan nominal top up {string}")
    public void pengguna_mencoba_memasukkan_nominal_top_up(String invalidInput) {
        formTopupPage.tryInputAmount(invalidInput);
    }

    @Then("Sistem menambahkan saldo ke akun pengguna")
    public void sistem_menambahkan_saldo_ke_akun_pengguna() {
        // Verifikasi saldo bertambah
    }

    @Then("Saldo pengguna bertambah sesuai nominal top up")
    public void saldo_pengguna_bertambah_sesuai_nominal_top_up() {
        // Verifikasi saldo bertambah sesuai input
    }

    @Then("Saldo pengguna bertambah dengan menghilangkan desimal {int}")
    public void saldo_pengguna_bertambah_dengan_menghilangkan_desimal(Integer amount) {
        // Verifikasi saldo bertambah tanpa desimal
    }

    @Then("Sistem menampilkan pesan error {string}")
    public void sistem_menampilkan_pesan_error(String errorMessage) {
        Assertions.assertTrue(formTopupPage.isErrorDisplayed(errorMessage));
    }

    @Then("Saldo pengguna tidak berubah")
    public void saldo_pengguna_tidak_berubah() {
        // Verifikasi saldo tidak berubah
    }

    @Then("Pengguna tetap berada di halaman dompet")
    public void pengguna_tetap_berada_di_halaman_dompet() {
        Assertions.assertEquals(walletUrl, driver.getCurrentUrl());
    }

    @Then("Field nominal top up tidak menerima input huruf")
    public void field_nominal_top_up_tidak_menerima_input_huruf() {
        Assertions.assertFalse(formTopupPage.isAmountInputValid());
    }

    @Then("Field nominal top up tetap kosong")
    public void field_nominal_top_up_tetap_kosong() {
        Assertions.assertTrue(formTopupPage.isAmountInputEmpty());
    }
}