package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        PageFactory.initElements(driver, LoginPage.class);
    }
    //    @FindBy (css="[test]")
//    WebElement email;

    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

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

    public static void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }


    // FOLLOWING ARE EXAMPLES OF FLUENT INTERFACE

//    public LoginPage provideEmail(String email) {
//        emailField.sendKeys(email);
//          return this;
//    }
//
//    public LoginPage providePassword(String password) {
//        passwordField.sendKeys(password);
//          return this;
//    }
//    public LoginPage clickSubmitBtn() {
//        submitButtonLocator.click();
//          return this;
//    }

















}












