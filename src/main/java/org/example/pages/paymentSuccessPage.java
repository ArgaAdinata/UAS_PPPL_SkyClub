package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class paymentSuccessPage {
    private WebDriver driver;

    // locator
    private By txtSuccess = By.xpath("/html/body/main/div/div/div[2]/p[1]");

    public paymentSuccessPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isTxtSuccessDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtSuccess));
        return driver.findElement(txtSuccess).isDisplayed();
    }
}
