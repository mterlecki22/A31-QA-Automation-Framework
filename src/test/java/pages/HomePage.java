package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static java.time.Duration.*;

public class HomePage extends BasePage {


By userAvatarIcon = By.cssSelector("img.avatar");

    String playlistName = "Game of Thrones";

    public HomePage (WebDriver givenDriver) {
        super(givenDriver);
    }
        By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
        By playlistInputField = By.cssSelector("input[name='name']");


    public void doubleClickFirstPlaylist() {
        doubleClick(driver.findElement(firstPlaylist));
    }

    public void enterPlaylistName(String playlistName) {
        driver.findElement(playlistInputField).sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        driver.findElement(playlistInputField).sendKeys(playlistName);
        driver.findElement(playlistInputField).sendKeys(Keys.ENTER);
    }
        public WebElement getUserAvatar(){
            return findElement(userAvatarIcon);
     }


    public boolean doesPlaylistExist(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()=' "+playlistName+"']"));
        return playlistElement.isDisplayed();
    }
    public static void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }


    // Alternative Method
//    public HomePage getUserAvatar(){
//        driver.findElement(By.xpath("//*[id=\"userBadge\""));
//                return this;
//    }








}
