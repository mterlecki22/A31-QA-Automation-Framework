package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

    public class MyStepDefs {
        WebDriver driver;
        WebDriverWait wait;

        @Given("I open browser")
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        @And("I open Login Page")
        public void iOpenLoginPage() {
            driver.get("https://bbb.testpro.io");
        }


        @When("I enter email {string}")
        public void i_enter_email(String string) {
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
            emailField.sendKeys(string);
        }
        @When("I enter password {string}")
        public void i_enter_password(String string) {
            By passwordField = By.cssSelector("[type='password']");
            WebElement passwordElement = driver.findElement(passwordField);
            passwordElement.sendKeys(string);

        }

        @And("I submit")
        public void iSubmit() {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
        }

        @Then("I am logged in")
        public void iAmLoggedIn() {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());




        }
        }
