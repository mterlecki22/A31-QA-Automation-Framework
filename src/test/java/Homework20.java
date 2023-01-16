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
    }

    //Searching a song
    public static void searchSong(String songTitleKeyword) throws InterruptedException {
        //searchSong("Pluto");
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm-input[type=search]"));
        //  WebElement searchField = driver.findElement(By.cssSelector("div#searchForm-input[type=search]"));
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys("Pluto");


        //View search results
        //viewAllSearchResults();
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results-section.songs-h1-button"));
        wait.until(ExpectedConditions.elementToBeClickable(viewAllSearchResults));
        viewAllSearchResults.click();

        //Selecting the first song
        // selectFirstSongResult();
        WebElement selectFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper-tr.song-item-td.title"));
        wait.until(ExpectedConditions.elementToBeClickable(selectFirstSongResult));
        selectFirstSongResult.click();


        //Clicking the add button
        // clickAddToButton();
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        wait.until(ExpectedConditions.elementToBeClickable(addTo));
        addTo.click();

        //Selecting the playlist
        // choosePlaylist("Homework 17 Playlist");
        WebElement playlistNameElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text(),'Homework 17 Playlist')]"));
        wait.until(ExpectedConditions.elementToBeClickable(playlistNameElement));
        playlistNameElement.click();


        //Checking if Popup button is present after selection
        //  Assert.assertTrue(isNotificationPopUpPresent());

    }
    //--------------------------------------------------------------------------------------------

    //HOMEWORK 18:


    @Test
    public void playASongTest() {
        login("demo@class.com", "te$t$tudent");
    }

         //Below is the improved method for: playSong();
        public void playSong() {
        WebElement playNxtBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(playNxtBtn)).click();
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(playBtn)).click();

        }
       // Below is the improved method for: isSongPlaying();
        public void isSongPlaying() {
            WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
            wait.until(ExpectedConditions.elementToBeClickable(soundBar));
            Assert.assertTrue(soundBar.isDisplayed());

        }


        //----------------------------------------------------------------------------------------------------

        // HOMEWORK 19:

        @Test
        public void deletePlaylistTest () {
            String playlistName = "Game of Thrones";

            //login process
            login("mitchelterlecki@gmail.com", "te$t$tudent");


            //i[@title='Create a new playlist']

            //clicking on add button for new playlist
            WebElement addPlaylistIcon = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
            wait.until(ExpectedConditions.elementToBeClickable(addPlaylistIcon)).click();

            //creating new playlist
            WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
            wait.until(ExpectedConditions.elementToBeClickable(newPlaylist)).click();

            WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
            wait.until(ExpectedConditions.elementToBeClickable(nameField));
            nameField.clear();
            nameField.sendKeys(playlistName, Keys.ENTER);

            WebElement testPlaylist = driver.findElement(By.xpath("//li/a[text()='" + playlistName + "']"));
            wait.until(ExpectedConditions.elementToBeClickable(testPlaylist)).click();

            //deleting the playlist
            WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
            wait.until(ExpectedConditions.elementToBeClickable(deletePlaylist)).click();

        }

    }
