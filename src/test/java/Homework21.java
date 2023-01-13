import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework21 extends BaseTest{{


    @Test
    public void deletePlaylistTest () throws InterruptedException {
        String playlistName = "Game of Thrones";

        //login process
        login("mitchelterlecki@gmail.com", "te$t$tudent");

        //clicking on add button for new playlist
        WebElement addPlaylistIcon = driver.findElement(By.xpath("//i@title='Create a new playlist']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i@title='Create a new playlist']"))).click();

        //creating new playlist
        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist"));
        newPlaylist.click();
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);

        WebElement testPlaylist =  wait.until(ExpectedConditions.elementToBeClickable(By. xpath("//li/a[text()='"+playlistName+"']"
        )));
        testPlaylist.click();

        //deleting the playlist
        WebElement deletePlaylist =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();

        Thread.sleep(3000);
        List<WebElement> playlistNames = driver.findElement(By.xpath("//section[@id='playlists']//li/a"));
        Assert.assertTrue(isNotificationPopUpPresent());

        for(WebElement p : playlistNames){
            String name = p.getText();
            if (name.equals(playlistName)) {
                Assert.assertTrue(false);
            }

        }

