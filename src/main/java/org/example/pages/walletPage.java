package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class walletPage {
    private WebDriver driver;

    // Locator
    By txtTitle = By.xpath("/html/body/main/div/h1");
    By txtBalance = By.xpath("/html/body/main/div/div/div[1]/div[1]/div[2]/div/p[2]");
    By btnTopup = By.xpath("/html/body/main/div/div/div[1]/div[2]/a[1]");
    By txtRecentTransaction = By.xpath("/html/body/main/div/div/div[2]/div[1]/div/div[2]/div[1]/div[2]");

    public walletPage(WebDriver driver) {
        this.driver = driver;
    }
    public String textTitle() {
        return driver.findElement(txtTitle).getText();
    }
    public String textBalance() {
        return driver.findElement(txtBalance).getText();
    }
    public String textRecentTransaction() {
        return driver.findElement(txtRecentTransaction).getText();
    }
    public void clickTopup() {
        driver.findElement(btnTopup).click();
    }
    public boolean isTxtRecentTransactionDisplayed() {
        return driver.findElement(txtRecentTransaction).isDisplayed();
    }
}
