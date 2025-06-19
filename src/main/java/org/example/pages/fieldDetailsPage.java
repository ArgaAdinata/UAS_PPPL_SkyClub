package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class fieldDetailsPage {
    private WebDriver driver;

    // Locator
    private By schedule = By.xpath("/html/body/main/div/div[3]/div[1]/div[4]/div[2]/div[24]");
    private By btnMobilePayment = By.xpath("/html/body/main/div/div[3]/div[1]/div[4]/div[3]/button");
    private By btnPayment = By.xpath("/html/body/main/div/div[3]/div[2]/div[3]/form/div/button");
    private By scheduleSelector;
    private By paymentButton = By.xpath("//button[text()='Bayar']");
    private By scheduleError = By.xpath("/html/body/main/div/div[5]/div/p");

    public fieldDetailsPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectSchedule(int index){
        this.schedule = By.xpath("/html/body/main/div/div[3]/div[1]/div[4]/div[2]/div[" + index + "]");
        driver.findElement(schedule).click();
    }

    private By getScheduleSelector(int index) {
        scheduleSelector = By.xpath("/html/body/main/div/div[3]/div[1]/div[4]/div[2]/div[" + index + "]/div[2]");
        return scheduleSelector;
    }

//    public void selectAvailableSchedule() {
//        driver.findElement(scheduleSelector).click();
//    }

    public void selectAvailableSchedule() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(schedule));
        for (int index = 1; index <= 24; index++) {
            try {
                WebElement element = driver.findElement(getScheduleSelector(index));
                if (element.isEnabled() && element.isDisplayed()) {
                    element.click();
                    return;
                }
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println("Semua schedule penuh");
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
    public void clickPayment() {
        driver.findElement(btnPayment).click();
    }
    public void clickMobilePayment() {
        driver.findElement(btnMobilePayment).click();
    }
    public void goToPaymentPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(btnPayment));
        WebElement button = driver.findElement(btnPayment);
        Actions action = new Actions(driver).moveToElement(button).click();
        action.perform();
    }
    public boolean isScheduleErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(scheduleError));
        System.out.println(driver.findElement(scheduleError).isDisplayed());
        return driver.findElement(scheduleError).isDisplayed();
    }
}
