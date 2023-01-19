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
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static FluentWait fluentWait = null;

    public static Actions action = null;
//WebDriver driver;
//WebDriverWait wait;

//By userAvatarIcon = By.cssSelector("img.avatar");

    String playlistName = "Game of Thrones";

    public HomePage (WebDriver givenDriver) {
        super(givenDriver);
    }
//        driver = givenDriver;
//        wait = new WebDriver(driver Duration.ofSeconds(5));

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
     //   public HomePage getUserAvatar(){
     //       return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon);
    // }

    public HomePage getUserAvatar(){
        driver.findElement(By.xpath("//*[id=\"userBadge\""));
                return this;
    }

    public boolean doesPlaylistExist(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()=' "+playlistName+"']"));
        return playlistElement.isDisplayed();
    }













}
