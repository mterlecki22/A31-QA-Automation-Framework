package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

    public class MyStepDefs {
        WebDriver driver;
        WebDriverWait wait;

        @Given("I open browser")
        public void openBroswer() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        @And("I open Login Page")
        public void iOpenLoginPage() {
            driver.get("https://bbb.testpro.io");
        }

        @When("I enter email {string}")
        public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys(email);
        }

        @And("I enter password {string}")
        public void iEnterPassword(String password) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys(password);
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
