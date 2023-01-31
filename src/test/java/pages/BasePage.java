package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.*;

import java.time.Duration;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void doubleClick(WebElement locator) {
        wait.until(elementToBeClickable(locator));
        actions.doubleClick(locator).perform();
    }

    public void contextClick(WebElement locator) {
        wait.until(elementToBeClickable(locator));
        actions.contextClick(locator).perform();
    }

    public void click (WebElement locator) {
        wait.until(elementToBeClickable(locator));
        locator.click();
    }
    public void click (By locator) {
        wait.until(elementToBeClickable(locator));
    }
    public WebElement findElement(By locator){
        return wait.until(visibilityOfElementLocated(locator));
    }
    public void contextClickFirstSong() {
        wait.until(visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        Actions action = new Actions(driver);
        action.contextClick(firstSong).perform();
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }

    //hover to play button/controls - refer to SeleniumTechniques for old code.
//    public  WebElement hoverToPlayBtn(){
//
//        login();
//        chooseAllSongsList();
//        Assert.assertTrue(hoverPlay().isDisplayed());
//        hoverPlay().click();
//        Assert.assertTrue(isSongPlaying());
//
//    }





}


