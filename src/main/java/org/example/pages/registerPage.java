package org.example.pages;

import org.openqa.selenium.By;
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
    public void clickCheckboxTerms() {
        driver.findElement(checkboxTerms).click();
    }
    public void clickRegister() {
        driver.findElement(btnRegister).click();
    }
}
