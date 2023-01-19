package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends BasePage {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;

    public static Actions action = null;
   // WebDriver driver;
    //static WebDriverWait wait;

    // Locators - Refactored since #22 Assignment
           @FindBy (css = "[type='email']")  //Old way: By emailField = By.cssSelector("[type='email']");
           WebElement emailField;
           @FindBy (css = "[type='password']") //Old way: By passwordField = By.cssSelector("[type='password']");
           WebElement passwordField;
           @FindBy (css = "button[type='submit']") //Old way: By submitButtonLocator = By.cssSelector("button[type='submit']");
           WebElement submitButtonLocator;

    public LoginPage(WebDriver givenDriver) {
        // Commented portion is during the class.
        // driver = givenDriver;
        // wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        super(givenDriver);

    }

    public LoginPage provideEmail(String email) {
        // Commented portion is during the class.
//        WebElement emailElement = driver.findElement(emailField);
//        emailElement.click();
//        emailElement.sendKeys(email);
        WebElement emailElement = driver.findElement(emailField).sendKeys(email);
        return this;
    }

//    @FindBy (css="[test]")
//    WebElement email;

    public LoginPage providePassword(String password) {
        // Commented portion is during the class.
//        WebElement passwordElement = driver.findElement(passwordField);
//        passwordElement.click();
//        passwordElement.sendKeys(password);
        WebElement passwordElement = driver.findElement(passwordField).sendKeys(password);
        return this;

    }

    public LoginPage clickSubmitBtn() {
        driver.findElement((By) submitButtonLocator).click();
        return this;
    }

    // Commented portion is during the class.
//    public LoginPage clickSubmitBtn() {
//        driver.findElement(submitButtonLocator).click();
//        //return this;
//  }
    public void login(){
        provideEmail();
        providePassword();
        clickSubmitBtn();

    }

    public static void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

















}












