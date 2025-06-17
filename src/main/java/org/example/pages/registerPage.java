package org.example.pages;

import org.example.utils.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class registerPage {
    private WebDriver driver;

    // locator
    private By txtTitle = By.xpath("/html/body/main/div[2]/div[1]/h4");
    private By inputName = By.name("name");
    private By inputUsername = By.name("username");
    private By inputEmail = By.name("email");
    private By inputPhone = By.name("no_telp");
    private By inputPassword = By.name("password");
    private By inputConfirmPassword = By.name("password_confirmation");
    private By checkboxTerms = By.id("remember");
    private By errorPassword = By.xpath("//*[@id=\"form\"]/div/div[3]/p");
    private By errorUsername = By.xpath("//*[@id=\"form\"]/div/div[1]/div[2]/p");
    private By errorEmail = By.xpath("//*[@id=\"form\"]/div/div[2]/div[1]/p");
    private By errorPhone = By.xpath("//*[@id=\"form\"]/div/div[2]/div[2]/p");
    private By btnRegister = By.xpath("//*[@id=\"form\"]/button");

    // constructor
    public registerPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTextTitle() {
        return driver.findElement(txtTitle).getText();
    }
    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }
    public void setUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void setPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(inputConfirmPassword).sendKeys(confirmPassword);
    }
    public boolean isErrorPasswordDisplayed() {
        return WaitStrategy.isElementDisplayed(driver, errorPassword);
        //return driver.findElement(errorPassword).isDisplayed();
    }
    public boolean isErrorUsernameDisplayed() {
        return WaitStrategy.isElementDisplayed(driver, errorUsername);
        //return driver.findElement(errorUsername).isDisplayed();
    }
    public boolean isErrorEmailDisplayed() {
        return WaitStrategy.isElementDisplayed(driver, errorEmail);
//        return driver.findElement(errorEmail).isDisplayed();
    }
    public boolean isErrorPhoneDisplayed() {
        return WaitStrategy.isElementDisplayed(driver, errorPhone);
//        return driver.findElement(errorPhone).isDisplayed();
    }
    public boolean isErrorCheckboxDisplayed(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualMessage = (String) js.executeScript("return arguments[0].validationMessage;", checkboxTerms);

        // 3. Periksa apakah pesan validasi yang didapat sesuai harapan.
        String expectedMessageFromImage = "Please check this box if you want to proceed.";
        if (actualMessage != null && actualMessage.equals(expectedMessageFromImage)) {
            return true;
        }
        return false;
    }

    public void clickCheckboxTerms() {
        driver.findElement(checkboxTerms).click();
    }
    public void clickRegister() {
        driver.findElement(btnRegister).click();
    }
}
