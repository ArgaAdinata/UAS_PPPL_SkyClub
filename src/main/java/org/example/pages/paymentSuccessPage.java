package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paymentSuccessPage {
    private WebDriver driver;

    // locator
    private By txtSuccess = By.xpath("/html/body/div/div/div[1]/h4");

    public paymentSuccessPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isTxtSuccessDisplayed() {
        return driver.findElement(txtSuccess).isDisplayed();
    }
}
