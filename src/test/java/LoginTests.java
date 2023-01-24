import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
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
    public static void LoginEmailValidPassword()throws InterruptedException{

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail ("mitchelterlecki@gmail.com");
        loginPage.providePassword ("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        Thread.sleep(2000);
//        WebElement avatartIcon = driver.findElement(By.cssSelector("img.avatar"));
//        Assert.assertTrue(avatartIcon.isDisplayed());
    }
    @Test
    public void playSong()   {  // Look at assigment #22 for alterted refactored code
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        //loginPage.login();
        loginPage.provideEmail ("mitchelterlecki@gmail.com");
        loginPage.providePassword ("te$t$tudent");
        loginPage.clickSubmitBtn();
        AllSongsPage.chooseAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlay();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }

//    @Test
//    public void playSong()   {  // Look at assigment #22 for alterted refactored code
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        AllSongsPage allSongsPage = new AllSongsPage(driver);
//        loginPage.provideEmail("mitchelterlecki@gmail.com").providePassword("te$t$tudent").clickSubmitBtn();
//        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
//    }

}


