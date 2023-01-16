import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

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
        @Test
        public void hoverOverPlayButton () {
            login("mitchelterlecki@gmail.com","te$tStudent" );
            chooseAllSongsList();
            hoverPlay();
            Assert.assertTrue(hoverPlay().isDisplayed());

        }


        public WebElement hoverPlay() {   //helper method
            WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
            action.moveToElement(play).perform();
            return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        }

        @Test
        public void listOfSongWebElements() {
            login("mitchelterlecki@gmail.com", "Te$t$tudent");
            List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
            System.out.println("Number of Songs found" +countSongsInPlaylist());
            for (WebElement e : songList) {
                System.out.println(e.getText());

            }
    }
}