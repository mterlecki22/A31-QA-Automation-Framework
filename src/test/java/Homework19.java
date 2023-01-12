import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedCondition.*;

//Homework #19:
//        Additional Annotations & DataProviders
//
//        1. Create a new file Homework19.java with @Test annotation in IntelliJ IDEA.
//
//        2. Create a test case deletePlaylist() using @Test annotations.
//
//        3. Use the helper/reusable methods we created.
//
//        4. Use @Parameters for passing baseUrl from the TestNG config file to the tests.
//
//        5. Navigate to "https://bbb.testpro.io/".
//
//        6. Log in with your credentials.
//
//        7. Choose a playlist.
//
//        8. Delete the playlist
//
//        9. Validate that the playlist is deleted.
//
//        10. Create a new branch and commit your changes.
//
//        11. Push your code to a remote repository.
//
//        12. Create a pull request.

public class Homework19 extends BaseTest{

@Test
public void deletePlaylistTest () throws InterruptedException {
    String playlistName = "Game of Thrones";

    //login process
    login("demo@class.io", "te$t$tudent");

    //clicking on add button for new playlist
    WebElement addPlaylistIcon = driver.findElement(By.xpath("//i@title='Create a new playlist']"));
    wait.until(ExpectedConditions.elementToBeClickable(addPlaylistIcon)).click();

    //creating new playlist
  WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
    newPlaylist.click();

  WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
    nameField.clear();
    nameField.sendKeys(playlistName, Keys.ENTER);

  WebElement testPlaylist =  driver.findElement(By.xpath("//li/a[text()='"+playlistName+"']"));
    testPlaylist.click();

    //deleting the playlist
 WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']")));
    deletePlaylist.click();

    Thread.sleep(3000);
    List<WebElement> playlistNames = driver.findElement(By.xpath("//section[@id='playlists']//li/a"));
    Assert.assertTrue(isNotificationPopUpPresent());

    for (WebElement p : playlistNames) {
        String name = p.getText();
        if (name.equals(playlistName)){
            Assert.assertTrue(false);
        }
    }
    }
}

//    public WebElement getDeletedPlaylistMsg () {
//       return driver.findElement(By.cssSelector("div.success.show"));
//
//    }

        //Alternative DELETION PROCESS
        // deletePlaylistBtnProcess();

//    WebElement deletedPlaylistMsg = getDeletedPlaylistMsg();
//    Assert.assertTrue(deletedPlaylistMsg.isDisplayed());

//    public void deletePlaylistBtnProcess () throws InterruptedException {
//        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
//        deletePlaylistBtn.click();
//        Thread.sleep(3000);
//
//    }
////    //Open Playlist
////    openPlaylist();
//    public void openPlaylist() throws InterruptedException {
//    WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
//    emptyPlaylist.click();
//    Thread.sleep(2000);
//    }