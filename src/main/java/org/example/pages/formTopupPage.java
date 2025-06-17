package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class formTopupPage {
    private WebDriver driver;
    private String nominalTopup;

    // Locator
    private By txtTitle = By.xpath("/html/body/main/div/div/div[1]/h2");
    private By inputAmount = By.name("nominal");
    private By amountInput = By.xpath("/html/body/main/div/div/div[1]/input");
    private By saldo = By.xpath("/html/body/main/div/div/div[1]/div[1]/div[2]/div/p[2]");
    private By errorMessage = By.xpath("/html/body/main/div/div[5]/div/p");
    private By btnTopup = By.xpath("/html/body/main/div/div/div[2]/form/button");
    private By lastTopup = By.xpath("/html/body/main/div/div/div[2]/div[1]/div/div[2]/div[1]/div[2]");

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
    public void tryInputAmount(String Input) {
        nominalTopup = Input;
        driver.findElement(amountInput).sendKeys(Input);
    }
    public boolean isErrorDisplayed(String message) {
        Boolean alert = driver.switchTo().alert().getText().contains(message);
        driver.switchTo().alert().accept();
        return alert;
    }

    public Integer getLastTopup() {
        if (nominalTopup.contains(".")) {
            nominalTopup = nominalTopup.substring(0, nominalTopup.indexOf("."));
        }
        return Integer.parseInt(nominalTopup);
    }

    public Integer getSaldo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String saldoText = driver.findElement(saldo).getText();
        if (saldoText.length() > 2) {
            saldoText = saldoText.substring(0, saldoText.length() - 2);
        }
        saldoText = saldoText.replaceAll("[^0-9]", "");
        try {
            return Integer.parseInt(saldoText);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing balance: " + e.getMessage());
            return null;
        }
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public boolean isAmountInputEmpty() {
        return driver.findElement(amountInput).getAttribute("value").matches("0");
    }
    public boolean isAmountInputValid() {
        return driver.findElement(amountInput).getAttribute("value").matches("\\d+");
    }
}
