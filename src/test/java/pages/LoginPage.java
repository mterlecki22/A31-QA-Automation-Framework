package pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.sql.DriverManager.getDriver;

public class LoginPage extends BasePage {


    // Locators - Refactored since #22 Assignment
           @FindBy(css = "[type='email']")  //Old way: By emailField = By.cssSelector("[type='email']");
           WebElement emailField;
           @FindBy(css = "[type='password']") //Old way: By passwordField = By.cssSelector("[type='password']");
           WebElement passwordField;
           @FindBy(css = "button[type='submit']") //Old way: By submitButtonLocator = By.cssSelector("button[type='submit']");
           WebElement submitButtonLocator;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
//    @Then("I enter email{string}")
    public void provideEmail(String email) {
        emailField.click();
    }
//
////    @FindBy (css="[test]")
////    WebElement email;
//    @And ("I enter password {string}")
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmitBtn() {
        submitButtonLocator.click();
    }

    // Commented portion is during the class.
//    public LoginPage clickSubmitBtn() {
//        driver.findElement(submitButtonLocator).click();
//        //return this;
//  }
    public void login(){
        provideEmail("mitchelterlecki@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

















}












