package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePage {
    private WebDriver driver;
    private static Integer balanceValue;

    private By eye = By.xpath("/html/body/nav/div[1]/div/div[3]/div/div/button");
    private By balance = By.xpath("/html/body/nav/div[1]/div/div[3]/div/div/span");

    public basePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEye() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(eye));
        WebElement eyeElement = driver.findElement(eye);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eyeElement);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eyeElement);
    }

    public Integer getBalance() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(balance));
        String balanceText = driver.findElement(balance).getText();
        if (balanceText.length() > 2) {
            balanceText = balanceText.substring(0, balanceText.length() - 2);
        }
        balanceText = balanceText.replaceAll("[^0-9]", "");
        try {
            balanceValue = Integer.parseInt(balanceText);
            return balanceValue;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing balance: " + e.getMessage());
            return null;
        }
    }

    public Integer getBalanceValue() {
        return balanceValue;
    }
}
