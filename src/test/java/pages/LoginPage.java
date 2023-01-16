package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      // super (givenDriver);

    }

    public void provideEmail(String email){
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);

        driver.findElement(emailField).sendKeys(email);
    }

    @FindBy (css="[test]")
    WebElement email;

    public void providePassword (String password){
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);


        driver.findElement(passwordField).sendKeys(password);
    }
    public LoginPage clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
        return this;
    }
    public void login(){
        provideEmail("mitchelterlecki@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

    }
}
