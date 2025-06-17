package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.example.pages.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private WebDriver driver;
    private loginPage loginPage;
    private final String loginUrl = "http://skyclub.my.id/users/login";
    private final String homePageUrl = "http://skyclub.my.id/";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Pengguna memiliki akun dengan username {string} dan password {string}")
    public void pengguna_memiliki_akun_dengan_username_dan_password(String username, String password) {
        // Buat register atau asumsi bahwa pengguna sudah terdaftar
        System.out.println("Asumsi: Pengguna dengan username '" + username + "' sudah terdaftar");
    }

    @Given("Pengguna telah membuka halaman login")
    public void pengguna_telah_membuka_halaman_login() {
        driver.get(loginUrl);
        loginPage = new loginPage(driver);
        Assertions.assertEquals("Login", loginPage.getTextTitle(), "Judul halaman login tidak sesuai");
    }

    @When("Pengguna mengisi username {string} dan password {string}")
    public void pengguna_mengisi_username_dan_password(String username, String password) {
        if (!username.isEmpty()) {
            loginPage.setUsername(username);
        }
        if (!password.isEmpty()) {
            loginPage.setPassword(password);
        }
    }

    @And("Pengguna menekan tombol {string}")
    public void pengguna_menekan_tombol_login(String buttonName) {
        loginPage.clickSignIn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Pengguna berhasil login")
    public void pengguna_berhasil_login() {
        Assertions.assertNotEquals(loginUrl, driver.getCurrentUrl(), "URL tidak berubah setelah login");
    }

    @And("Pengguna diarahkan ke halaman yang sesuai")
    public void pengguna_diarahkan_ke_halaman_yang_sesuai() {
        Assertions.assertEquals(homePageUrl, driver.getCurrentUrl(), "Redirect setelah login tidak sesuai");
    }

    @Then("Sistem menampilkan pesan {string} di halaman yang sama")
    public void sistem_menampilkan_pesan_di_halaman_yang_sama(String errorMessage) {
        boolean errorFound = false;

        switch (errorMessage) {
            case "username atau password salah":
                errorFound = loginPage.isErrorWrongCredentialDisplayed();
                break;
            case "Password minimal 6 karakter":
                errorFound = loginPage.isErrorPasswordDisplayed();
                break;
            case "Username tidak boleh kosong":
                errorFound = loginPage.isErrorUsernameEmptyDisplayed();
                break;
            case "Password tidak boleh kosong":
                errorFound = loginPage.isErrorPasswordEmptyDisplayed();
                break;
            case "Username dan password tidak boleh kosong":
                errorFound = loginPage.isErrorUsernameEmptyDisplayed() && loginPage.isErrorPasswordEmptyDisplayed();
                break;
            default:
                throw new IllegalArgumentException("Pesan error tidak dikenali: " + errorMessage);
        }

        Assertions.assertTrue(errorFound, "Pesan error '" + errorMessage + "' tidak ditampilkan");
    }

    @And("Pengguna tetap berada di halaman login")
    public void pengguna_tetap_berada_di_halaman_login() {
        Assertions.assertEquals(loginUrl, driver.getCurrentUrl(), "Halaman harus tetap di login page");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}