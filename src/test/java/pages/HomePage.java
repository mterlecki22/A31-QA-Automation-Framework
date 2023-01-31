package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(css = ".playlist:nth-child(3)")  //Old way: By emailField = By.cssSelector("[type='email']");
    WebElement firstPlaylist;

    @FindBy(css = "input[name='name']")  //Old way: By emailField = By.cssSelector("[type='email']");
    WebElement playlistInputField;



    public void doubleClickFirstPlaylist() {
        doubleClick((firstPlaylist));
    }

    public HomePage enterPlaylistName(String playlistName) {
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
     }
        public WebElement getUserAvatar(){
            return findElement(userAvatarIcon);
     }

    public boolean doesPlaylistExist(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()=' "+playlistName+"']"));
        return playlistElement.isDisplayed();
    }




}
