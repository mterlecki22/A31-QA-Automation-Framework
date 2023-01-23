package POMMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage2 extends BasePage2 {

    // Locators
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage2(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

//    @FindBy (css="[test]")
//    WebElement email;

    public void providePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
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
