package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    private WebDriver driver;

    // Locator
    By btnRegister = By.xpath("/html/body/nav/div[1]/div/div[3]/div/div/a[2]");
    By btnLogin = By.xpath("/html/body/nav/div[1]/div/div[3]/div/div/a[1]");
    By btnFieldDetails = By.xpath("/html/body/nav/div[1]/div/div[2]/div/a[1]");
    By txtName = By.xpath("//*[@id=\"user-menu-button\"]/span[2]");
    By btnWallet = By.xpath("/html/body/nav/div[1]/div/div[3]/div/div/a[1]");

    public homePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getPageSource(){
        return driver.getPageSource();
    }
    public void clickRegister() {
        driver.findElement(btnRegister).click();
    }
    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }
    public void clickFieldDetails() {
        driver.findElement(btnFieldDetails).click();
    }
    public String getName() {
        return driver.findElement(txtName).getText();
    }
    public void clickWallet() {
        driver.findElement(btnWallet).click();
    }
    public boolean isWalletBtnDisplayed() {
        return driver.findElement(btnWallet).isDisplayed();
    }
    public boolean isRegisterBtnDisplayed() {
        return driver.findElement(btnRegister).isDisplayed();
    }
    public boolean isLoginBtnDisplayed() {
        return driver.findElement(btnLogin).isDisplayed();
    }
    public boolean isTxtNameDisplayed() {
        return driver.findElement(txtName).isDisplayed();
    }
}
