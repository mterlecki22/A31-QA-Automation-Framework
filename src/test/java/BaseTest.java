import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions action = null;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @DataProvider(name = "incorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"invalid@email.com", "invalidPassword"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
       // driver = pickBrowser(System.getProperty("browser"));
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));
        Actions action;
        action = new Actions(driver);

        // List<WebElement> listOfElements = driver.findElement(By.xpath("//div"));
        // FluentWait wait = new FluentWait(Pages.LoginTests.driver);   //example of FluentWait ***rarely used***
//                wait
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(Exception.class);
    }

    //    public static void navigateToPage() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }
    public static void login(String email, String password) {   //includes the entire login process
        provideEmail(email);
        providePassword(password);
        clickSubmit();

    }

    @AfterMethod   //Quiting the driver after every method
    public static void closeBrowser() {
        LoginTests.driver.quit();
    }

//    private WebDriver pickBrowser (String browser){
//        switch (browser) {
//            case "Firefox": {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }
//            case "MicrosoftEdge": {
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//            }
//            default :{
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//        }
//        return driver;
//
//    }

    public static void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
        //fluentWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));  //fluentWait example
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)); //referring to 'elementToBeClickable' this
        //    method only takes WebElement - otherwise see the 'provideEmail for other way
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }


    public static void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public boolean isNotificationPopUpPresent() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.isDisplayed();
    }

    public static void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm-input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(4000);
    }
//            public void contextClickFirstSong(){
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//                WebElement = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
//                Actions action = new Actions (driver);
//                action.contextClick(firstSong().perform());
//            }

    public static void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }

    public void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.song-menu li.playback"))).click();
    }

    public void isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid= 'sound-bar-play']"));

    }

    public static void viewAllSearchResults() throws InterruptedException {
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results-section.songs-h1-button"));
        wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(String.valueOf(viewAllSearchResults))));
        viewAllSearchResults.click();

    }

    public List displayAllSongs(){
        List <WebElement> songList = driver.findElements(By.cssSelector("#playlistWrapper td.title"));
        return songList;
    }

    public static void selectFirstSongResult() throws InterruptedException {
        WebElement selectFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper-tr.song-item-td.title"));
        wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(String.valueOf(selectFirstSongResult))));
        selectFirstSongResult.click();

    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(String.valueOf(addTo))));
        addTo.click();

    }
//    public static void grabASong() {
//    WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']")));
//    WebElement playlist = driver.findElement(By.xpath("//li/a[contains(@href,'#!/playlist/35439'"));
//    action.clickAndHold(song).moveToElement(playlist).release(playlist).build().perform();
//  }
    public static Dimension countSongsInPlaylist() {
        return driver.findElement(By.cssSelector("#playlistWrapper td.title")).getSize();
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Edited Playlist Name']"));
        return playlistElement.isDisplayed();
    }

    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        // Actions action = new Actions (driver);
        action.doubleClick(playlistElement).perform();
    }

    public void choosePlayListByName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text)(), ' "+ name +"')]"))).click();

    }

    public static void hoverToPlayBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn]")));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn]"));
        Actions actions = new Actions (driver);
        actions.moveToElement(playButton).perform();

    }

    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
//            clear() does not work, element has an attribute of "required"
//            workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Game of Thrones");
        playlistInputField.sendKeys(Keys.ENTER);
    }



}
