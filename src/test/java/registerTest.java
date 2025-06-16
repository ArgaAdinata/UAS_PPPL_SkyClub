import org.example.pages.registerPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class registerTest {
    private WebDriver driver;
    private String baseUrl = "http://skyclub.work.gd/users/register";

    @BeforeEach
    public void setUp() {
        // Inisialisasi WebDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegister() {
        // Buka halaman register
        driver.get(baseUrl);

        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "johndoe" + System.currentTimeMillis() + "@example.com";

        // Isi form register
        registerPage.setName("John Doe");
        registerPage.setUsername("johndoe123");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("081234567890");
        registerPage.setPassword("password123");
        registerPage.setConfirmPassword("password123");
        registerPage.clickCheckboxTerms();
        //registerPage.clickRegister();
    }

    // Pendaftaran berhasil dengan data valid
    @Test
    public void berhasilDataValid() {
        // Buka halaman register
        driver.get(baseUrl);

        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "pppl" + System.currentTimeMillis() + "@mail.com";

        // Isi form register
        registerPage.setName("PPPL");
        registerPage.setUsername("PPPL");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("08654321234");
        registerPage.setPassword("password");
        registerPage.setConfirmPassword("password");
        registerPage.clickCheckboxTerms();
        registerPage.clickRegister();
    }

    // Pendaftaran gagal karena password kurang dari 6 karakter
    @Test
    public void gagalPasswordKurang() {
        // Buka halaman register
        driver.get(baseUrl);

        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "pppl2" + System.currentTimeMillis() + "@mail.com";

        // Isi form register
        registerPage.setName("PPPL2");
        registerPage.setUsername("PPPL2");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("086543222345");
        registerPage.setPassword("pass");
        registerPage.setConfirmPassword("pass");
        registerPage.clickCheckboxTerms();
        registerPage.clickRegister();

        // Tampilan pesan error
        Assertions.assertTrue(registerPage.isErrorPasswordDisplayed());
    }

    // Pendaftaran gagal karena username sudah ada
    @Test
    public void gagalUsernameAda() {
        // Buka halaman register
        driver.get(baseUrl);

        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "pppl3" + System.currentTimeMillis() + "@mail.com";

        // Isi form register
        registerPage.setName("PPPL3");
        registerPage.setUsername("test");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("08654323312");
        registerPage.setPassword("password");
        registerPage.setConfirmPassword("password");
        registerPage.clickCheckboxTerms();
        registerPage.clickRegister();

        // Tampilan pesan error
        Assertions.assertTrue(registerPage.isErrorUsernameDisplayed());
    }

    // Pendaftaran gagal karena email sudah ada
    @Test
    public void gagalEmailAda() {
        // Buka halaman register
        driver.get(baseUrl);

        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "test" + System.currentTimeMillis() + "@gmail.com";

        // Isi form register
        registerPage.setName("PPPL");
        registerPage.setUsername("PPPL3");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("08654323323");
        registerPage.setPassword("password");
        registerPage.setConfirmPassword("password");
        registerPage.clickCheckboxTerms();
        registerPage.clickRegister();

        // Tampilan pesan error
        Assertions.assertTrue(registerPage.isErrorEmailDisplayed());
    }
    
    // Pendaftaran gagal karena nomor telepon berupa string
    @Test
    public void gagalNomorTelpString() {
        // Buka halaman register
        driver.get(baseUrl);
        
        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        
        // Isi form register
        registerPage.setPhone("08654323323");
        
        // Tampilan pesan error
        Assertions.assertTrue(registerPage.isErrorPhoneDisplayed());
    }
    
    // Pendaftaran gagal karena confirm password tidak cocok
    @Test
    public void gagalConfirmPassTidakCocok() {
        // Buka halaman register
        driver.get(baseUrl);
    
        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "PPPL4" + System.currentTimeMillis() + "@mail.com";
    
        // Isi form register
        registerPage.setName("PPPL");
        registerPage.setUsername("PPPL4");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("08654324323");
        registerPage.setPassword("password");
        registerPage.setConfirmPassword("wrongpassw");
        registerPage.clickCheckboxTerms();
        registerPage.clickRegister();
    
        // Tampilan pesan error
        Assertions.assertTrue(registerPage.isErrorPasswordDisplayed());
    }

    // Pendaftaran gagal karena checkbox terms belum dicentang
    @Test
    public void gagalCheckbox() {
        // Buka halaman register
        driver.get(baseUrl);
    
        // Buat instance registerPage
        registerPage registerPage = new registerPage(driver);
        String dynamicEmail = "PPPL5" + System.currentTimeMillis() + "@mail.com";
    
        // Isi form register
        registerPage.setName("PPPL");
        registerPage.setUsername("PPPL5");
        registerPage.setEmail(dynamicEmail);
        registerPage.setPhone("08654325522");
        registerPage.setPassword("password");
        registerPage.setConfirmPassword("password");
        registerPage.clickRegister();
    
        // Tampilan pesan error
    }
    
    
    @AfterEach
    public void tearDown() {
        // Tutup browser
        if (driver != null) {
            driver.quit();
        }
    }
}
