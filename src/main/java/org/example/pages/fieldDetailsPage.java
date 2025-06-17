package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class fieldDetailsPage {
    private WebDriver driver;

    // Locator
    private By schedule = By.xpath("/html/body/main/div/div[3]/div[1]/div[4]/div[2]/div[24]");
    private By btnMobilePayment = By.xpath("/html/body/main/div/div[3]/div[1]/div[4]/div[3]/button");
    private By btnPayment = By.xpath("/html/body/main/div/div[3]/div[2]/div[3]/form/div/button");
    private By scheduleSelector = By.id("schedule-select");
    private By paymentButton = By.id("payment-button");
    private By scheduleError = By.id("schedule-error");

    public fieldDetailsPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectSchedule(int index){
        this.schedule = By.xpath("/html/body/main/div/div[3]/div[1]/div[4]/div[2]/div[" + index + "]");
        driver.findElement(schedule).click();
    }
    public void selectAvailableSchedule() {
        driver.findElement(scheduleSelector).click();
        // Pilih jadwal tersedia
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
        driver.findElement(paymentButton).click();
    }
    public boolean isScheduleErrorDisplayed() {
        return driver.findElement(scheduleError).isDisplayed();
    }
}
