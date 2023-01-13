import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

    //H1. Create a new file Homework20.java with @Test annotation in IntelliJ IDEA.
//
//2. Refactor your code - implement Explicit waits.
//
//3. Remove all implementations of Thread.sleep.
//
//4. Make sure your code runs without failures.
//
//5. Create a new branch and commit your changes.
//
//6. Push your code to a remote repository.
//
//7. Create a pull request.

public class Homework20 extends BaseTest {


    //HOMEWORK 17:

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotification = "Added 1 song into";

        //Navigating to Koel
        //navigateToPage();

        //Login Method w/ Wait time
        login("mitchelterlecki@gmail.com", "te$t$tudent");
        Thread.sleep(3000);

        //Searching a song
        searchSong("Pluto");

        //View search results
        viewAllSearchResults();

        //Selecting the first song
        selectFirstSongResult();

        //Clicking the add button
        clickAddToButton();

        //Selecting the playlist
        choosePlaylist("Homework 17 Playlist");

        //Checking if Popup button is present after selection
        Assert.assertTrue(isNotificationPopUpPresent());

    //--------------------------------------------------------------------------------------------

    //HOMEWORK 18:


        @Test
        public void playASongTest() {
            login("demo@class.com", "te$t$tudent");
            playSong();
            isSongPlaying();

        }


    //----------------------------------------------------------------------------------------------------

    // HOMEWORK 19:

            @Test
            public void deletePlaylistTest() throws InterruptedException {
                String playlistName = "Game of Thrones";

                //login process
                login("mitchelterlecki@gmail.com", "te$t$tudent");


                //i[@title='Create a new playlist']

                //clicking on add button for new playlist
                WebElement addPlaylistIcon = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
                wait.until(ExpectedConditions.elementToBeClickable(addPlaylistIcon)).click();

                //creating new playlist
                WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
                newPlaylist.click();

                WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
                nameField.clear();
                nameField.sendKeys(playlistName, Keys.ENTER);

                WebElement testPlaylist = driver.findElement(By.xpath("//li/a[text()='" + playlistName + "']"));
                testPlaylist.click();

                //deleting the playlist
                WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
                deletePlaylist.click();
            }

        }