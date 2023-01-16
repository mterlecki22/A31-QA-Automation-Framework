import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.UUID;

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
    public static FluentWait fluentWait = null;

    // Public static Actions actions = null;

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
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));


        // FluentWait wait = new FluentWait(LoginTests.driver);   //example of FluentWait ***rarely used***
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

    public static void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
        //fluentWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));  //fluentWait example
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)); //referring to 'elementToBeClickable' this
        //method only takes WebElement - otherwise see the 'provideEmail for other way
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

    //Methods below used for Homework17 class - ******disregard********
    public static void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm-input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(4000);
    }

    public static void viewAllSearchResults() throws InterruptedException {
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results-section.songs-h1-button"));
        viewAllSearchResults.click();
        Thread.sleep(4000);
    }

    public static void selectFirstSongResult() throws InterruptedException {
        WebElement selectFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper-tr.song-item-td.title"));
        selectFirstSongResult.click();
        Thread.sleep(4000);
    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
        Thread.sleep(4000);

    }

    public static void grabASong() {
        WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']"));
        WebElement playlist = driver.findElement(By.xpath("//li/a[contains(@href,'#!/playlist/35439'"));
        Actions acts = new Actions(driver);
        acts.clickAndHold(song).moveToElement(playlist).release(playlist).build().perform();
    }

    public static void choosePlaylist(String playlistName) throws InterruptedException {
        WebElement playlistNameElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text(),'" + playlistName + "')]"));
        playlistNameElement.click();
        Thread.sleep(3000);
    }

    public void playSong() {
        WebElement playNxtBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNxtBtn.click();
        playBtn.click();
    }

    public void isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}

