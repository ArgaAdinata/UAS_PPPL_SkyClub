package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;

    // locator
    private By txtTitle = By.xpath("/html/body/main/div[1]/div/h4");
    private By inputUsername = By.name("username");
    private By inputPassword = By.name("password");
    private By btnSignIn = By.xpath(("//*[@id=\"loginForm\"]/button"));

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

    public void clickSignIn() {
        driver.findElement(btnSignIn).click();
    }

}
