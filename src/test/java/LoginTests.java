import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        Thread.sleep(2000);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000);
        driver.quit();
    }

        @Test
        public static void LoginValidEmailPasswordTest () throws InterruptedException {
// Precondition: Chrome Browser should be opened
// Step 1: Open KOEL login page
// Step 2: Enter Existing Username
// Step 3: Enter Correct Password
// Step 4: Click on Login Button
// Expected Result: User should be directed to home page

            //Step 1:
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            Thread.sleep(2000);
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(), url);
            Thread.sleep(2000);

            //User Email
            WebElement emailField = driver.findElement(By.cssSelector("[typ='email']"));
            emailField.click();
            CharSequence keysToSend;
            emailField.sendKeys("demo@class.com");

            //User Password
            WebElement passwordField = driver.findElement(By.cssSelector("[typ='password'"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");

            //User Login
            WebElement loginField = driver.findElement(By.cssSelector("[typ='submit'"));
            loginField.click();

            //Expected Result: User should be directed to Homepage
            WebElement avatar = driver.findElement(By.className("avatar"));
            Assert.assertTrue(avatar.isDisplayed());
            driver.quit();

        }

@Test
        public static void LoginInvalidEmailTest () throws InterruptedException {

// Precondition: Chrome Browser should be opened
    //Declare Web Driver
// Step 1: Open KOEL login page
    // Tell driver to load the page
// Step 2: Enter Existing Username
    // Locate the field box
    // Click on field box
    //Enter invalid credentials
// Step 3: Enter Correct Password
    // Locate the field box
    // Click on field box
    //Enter anything
// Step 4: Click on Login Button
    // Locate the field box
    // Click on field box
// Expected Result: User should stay on login page
    //Assert the present of email field to user

        //Step 1:
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        Thread.sleep(2000);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000);

        //User Email
        WebElement emailField = driver.findElement(By.cssSelector("[typ='email']"));
        emailField.click();
        CharSequence keysToSend;
        emailField.sendKeys("sheldoncooper@class.com");

        //User Password
        WebElement passwordField = driver.findElement(By.cssSelector("[typ='password'"));
        passwordField.click();
        passwordField.sendKeys("bazinga");

        //User Login
        WebElement loginField = driver.findElement(By.cssSelector("[typ='submit']"));
        loginField.click();

        //Expected Result: User should remain on login page
        Assert.assertTrue(emailField.isDisplayed());
        driver.quit();




        }
}
