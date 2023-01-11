import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    //  @Test(enabled = true, priority = 0, description = "loginEmptyEmailPasswordTest")
   @Test (dataProvider= "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public static void loginEmptyEmailPasswordTest(String email, String password){
     login(email,password);
     Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test(enabled = true, priority = 1, description = "loginValidEmailValidPasswordTest")
    public static void loginValidEmailValidPasswordTest() throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement clickAvatarIcon = driver.findElement(By.cssSelector("ing.avatar"));
        Assert.assertTrue(clickAvatarIcon.isDisplayed());
    }

    @Test(enabled = true, priority = 2, description = "loginInvalidEmailValidPasswordTest")
    public static void loginInvalidEmailValidPasswordTest() throws InterruptedException {

        provideEmail("johndoe@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);


    }
}