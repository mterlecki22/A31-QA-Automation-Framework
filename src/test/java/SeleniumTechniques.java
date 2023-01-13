import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SeleniumTechniques extends BaseTest{


    @Test
    public void playSong() throws InterruptedException {
        login("mitchelterlecki@gmail.com", "te$t$tudent");
        chooseAllSongsList();
        choosePlay();
        contextClickFirstSong();
        choosePlay();
        Thread.sleep(3000);
        Assert.assertTrue(isSongPlaying());


    }

    @Test
    public void renamePlaylist() throws InterruptedException{

    }
    @Test
    public void hoverOverPlayButton(){
        login();
        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());

    }

    private WebElement hoverPlay() {   //helper method
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    }

    @Test
    public void listOfSongWebElements() {
        login("mitchelterlecki@gmail.com", "Te$t$tudent");
        List<WebElement> songList = driver.findElement(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found" +countSongsInPlaylist());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }

    }


}
