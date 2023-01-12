import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {
@Test(enabled = true, priority = 3, description = "updateUserProfileTest")
public static void updateUserProfileTest() throws InterruptedException {
        String newName = generateRandomName();


    login("demo@class.io", "te$t$tudent");

        Thread.sleep(2000);
        openUserProfilePage();
        setName(newName);
        Thread.sleep(2000);

        provideCurrentPassword("te$t$tudent");
        clickSaveButton();
        Thread.sleep(3000);


        WebElement actualUserProfile = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualUserProfile.getText(), newName);
}
}
