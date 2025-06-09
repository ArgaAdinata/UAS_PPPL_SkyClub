package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class formTopupPage {
    private WebDriver driver;

    // Locator
    private By txtTitle = By.xpath("/html/body/main/div/div/div[1]/h2");
    private By inputAmount = By.name("nominal");
    private By btnTopup = By.xpath("/html/body/main/div/div/div[2]/form/button");

    public formTopupPage(WebDriver driver) {
        this.driver = driver;
    }
    public String textTitle() {
        return driver.findElement(txtTitle).getText();
    }
    public void setAmount(String amount) {
        driver.findElement(inputAmount).sendKeys(amount);
    }
    public static boolean isAlertDisplayed(WebDriver driver) {
        try {
            // Beralih ke alert
            driver.switchTo().alert();
            return true; // Alert ditemukan
        } catch (NoAlertPresentException e) {
            return false; // Alert tidak ditemukan
        }
    }
    public void clickTopup() {
        driver.findElement(btnTopup).click();
    }

}
