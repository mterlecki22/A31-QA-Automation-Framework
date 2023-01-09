import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    
    //1. Create a new file Homework16.java in IntelliJ IDEA.
//
//2. Create a test case registration Navigation() using @Test annotation.
//
//3. Using Selenium, Navigate to "https://bbb.testpro.io/".
//
//4. Click Registration link.
//
//5. Validate that you are redirected to Registration page.
//
//6. Create a new branch and commit your changes.
//
//7. Push your code to a remote repository.
//
//8. Create a pull request.

    @Test
    public void Navigation () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";

        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        driver.quit();


    }
}