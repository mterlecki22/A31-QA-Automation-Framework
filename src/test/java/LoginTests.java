import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.BasePage;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;


public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }

    @Test(enabled = true, priority = 1, description = "loginEmailValidPassword")
    public static void loginEmailValidPassword()throws InterruptedException{

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        //homePage.getUserAvatar().isDisplayed();
        //alternative method (isDisplayed not working)
        loginPage.provideEmail ("mitchelterlecki@gmail.com");
        loginPage.providePassword ("te$t$tudent");
        loginPage.clickSubmitBtn();
        //Thread.sleep(5000);
       // WebElement avatartIcon = wait.until(By.cssSelector("img.avatar"));
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        Thread.sleep(2000);
//        WebElement avatartIcon = driver.findElement(By.cssSelector("img.avatar"));
//        Assert.assertTrue(avatartIcon.isDisplayed());
    }

}


