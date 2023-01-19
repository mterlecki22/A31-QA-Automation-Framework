package POMMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage2 extends BasePage2 {
    public HomePage2(WebDriver givenDriver) {
        super(givenDriver);
    }

WebDriver driver;
WebDriverWait wait;

By userAvatarIcon = By.cssSelector("img.avatar");

    String playlistName = "Game of Thrones";

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
        public WebElement getUserAvatar(){
            return findElement(userAvatarIcon);
     }
//
//    public HomePage2 getUserAvatar(){
//        driver.findElement(By.xpath("//*[id=\"userBadge\""));
//                return this;
//    }

    public boolean doesPlaylistExist(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()=' "+playlistName+"']"));
        return playlistElement.isDisplayed();
    }













}
