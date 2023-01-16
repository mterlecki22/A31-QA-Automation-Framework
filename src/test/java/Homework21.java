import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;



// HOMEWORK 21:

// 1. Using Action Class methods, create/refactor the test case renamePlaylist().
//
//2. Implement Explicit Waits.
//
//3. Remove all Thread.sleep implementations.
//
//4. Create a new branch and commit your changes.
//
//5. Push your code to a remote repository.
//
//6. Create a pull request.

public class Homework21 extends BaseTest {
        @Test
        public void renamePlaylist() {

            login("mitchelterlecki@gmail.com", "te$t$tudent");
            doubleClickChoosePlaylist();
            enterPlaylistName();
            Assert.assertTrue(doesPlaylistExist());

        }
            public void doubleClickChoosePlaylist() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
            WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
            action.doubleClick(playlistElement).perform();
        }

        public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Swiss Roll Mood Playlist");
        playlistInputField.sendKeys(Keys.ENTER);



    }
}