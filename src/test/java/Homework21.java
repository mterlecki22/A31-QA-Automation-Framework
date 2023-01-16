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

    String playlistName = "Game of Thrones";
    @Test
        public void renamePlaylist() {

            login("mitchelterlecki@gmail.com", "te$t$tudent");
            choosePlaylist();
            contextClickChoosePlaylist();
            enterPlaylistName();
            Assert.assertTrue(doesPlaylistExist());

        }
            public void contextClickChoosePlaylist() {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
                WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
                action.contextClick(playlistElement).perform();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
            }
        public void enterPlaylistName() {
            WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
            playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
            playlistInputField.sendKeys(playlistName);
            playlistInputField.sendKeys(Keys.ENTER);
        }

        public boolean doesPlaylistExist(){
            WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistName+"']"));
            return playlistElement.isDisplayed();
        }
        public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
        }



    }
