package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paymentPage {
    private WebDriver driver;

    // Locator
    private By btnPayment = By.xpath("/html/body/div/div[1]/div[2]/form[2]/button");
    private By modalError = By.xpath("/html/body/div/div[2]");

    public paymentPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickPayment(){
        driver.findElement(btnPayment);
    }
    public boolean isModalErrorDisplayed() {
        return driver.findElement(modalError).isDisplayed();
    }

}
