package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class paymentPage {
    private WebDriver driver;
    private Integer totalPayment;

    // Locator
    private By jadwal = By.xpath("/html/body/main/div/div[1]/div[1]/div[2]/div/div[2]/p[1]");
    private By btnPayment = By.xpath("/html/body/main/div/div[1]/div[2]/form[2]/button");
    private By nominalPayment = By.xpath("/html/body/main/div/div[1]/div[2]/div/div[3]/p[2]");
    private By modalError = By.xpath("/html/body/main/div/div[2]/div/h2");

    public paymentPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickPayment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jadwal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nominalPayment));
        String nominalPayment = driver.findElement(this.nominalPayment).getText();
        if (nominalPayment.length() > 2) {
            nominalPayment = nominalPayment.substring(0, nominalPayment.length() - 2);
        }
        nominalPayment = nominalPayment.replaceAll("[^0-9]", "");
        try {
            totalPayment = Integer.parseInt(nominalPayment);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing balance: " + e.getMessage());
        }

        wait.until(ExpectedConditions.elementToBeClickable(btnPayment));
        WebElement button = driver.findElement(btnPayment);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public Integer getTotalPayment() {
        return totalPayment;
    }

    public boolean isModalErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalError));
        System.out.println(driver.findElement(modalError).isDisplayed());
        return driver.findElement(modalError).isDisplayed();
    }

}
