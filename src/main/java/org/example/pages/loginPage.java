package org.example.pages;

import org.example.utils.WaitStrategyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;

    // locator
    private By txtTitle = By.xpath("/html/body/main/div[1]/div/h4");
    private By inputUsername = By.name("username");
    private By inputPassword = By.name("password");
    private By btnSignIn = By.xpath(("//*[@id=\"loginForm\"]/button"));
    private By errorPassword = By.xpath("//*[@id=\"loginForm\"]/div/div[2]/p");
    private By errorWrongCredential = By.id("alert");
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextTitle() {
        return driver.findElement(txtTitle).getText();
    }

    public void setUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public boolean isErrorPasswordDisplayed() {
        return WaitStrategyUtil.isElementDisplayed(driver, errorPassword);
    }

    public boolean isErrorWrongCredentialDisplayed() {
        return WaitStrategyUtil.isElementDisplayed(driver, errorWrongCredential);
    }


    public boolean isErrorUsernameEmptyDisplayed() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].validationMessage;", driver.findElement(inputUsername)
        );
        System.out.println("Validation Message: " + validationMessage);
        assert validationMessage != null;
        return !validationMessage.isEmpty();
    }

    public boolean isErrorPasswordEmptyDisplayed() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].validationMessage;", driver.findElement(inputPassword)
        );
        System.out.println("Validation Message: " + validationMessage);
        assert validationMessage != null;
        return !validationMessage.isEmpty();
    }
    public void clickSignIn() {
        driver.findElement(btnSignIn).click();
    }
}
