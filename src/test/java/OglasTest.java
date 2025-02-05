import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class OglasTest {

    private static WebDriver webDriver;
    private WebDriverWait wait;
    private static String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Downloads\\geckodriver-v0.35.0-win64\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        baseUrl = "https://olx.ba/";
    }

    @Test
    public void testObjaviOglas() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement oglasButton = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[2]/div/button"));
        oglasButton.click();
        Thread.sleep(500);

        WebElement acceptButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]"));
        acceptButton.click();

        WebElement nameField = webDriver.findElement(By.name("username"));
        nameField.click();
        nameField.sendKeys("Edina_Kurto_14");
        Thread.sleep(200);
        WebElement passwordField = webDriver.findElement(By.name("password"));
        passwordField.click();
        passwordField.sendKeys("kenai_je_moj_pas_123");
        Thread.sleep(200);
        passwordField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        webDriver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement oglasButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/header/div/div[1]/div[2]/div/button")));
        oglasButton2.click();
        Thread.sleep(500);

        WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div")));
        popup.click();
        WebElement nestoDrugoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div/button/div/div/div")));
        nestoDrugoButton.click();
        Thread.sleep(200);

        WebElement inputField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/input"));
        inputField.click();
        inputField.sendKeys("Pas kenai");
        WebElement continueButton = webDriver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div/div[2]/button"));
        continueButton.click();

        Thread.sleep(1000);
        WebElement categoriesField = webDriver.findElement(By.cssSelector(".choose-cat > li:nth-child(2) > button:nth-child(1) > div:nth-child(1) > b:nth-child(3)"));
        categoriesField.click();

        WebElement naslovField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/input")));
        naslovField.click();
        naslovField.sendKeys("Pas kenai (Besplatno ko hoce!)");

        WebElement priceField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div/input")));
        priceField.click();
        priceField.sendKeys("00.00");

        WebElement continueToNext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[4]/div/div/button[2]")));
        continueToNext.click();

        WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"buttonMužjak\"]")));
        gender.click();

        WebElement starost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/input")));
        starost.click();
        starost.sendKeys("8");

        WebElement rasa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/input")));
        rasa.click();
        rasa.sendKeys("Samo jede");

        WebElement continueToNext2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[4]/div/div/button[2]")));
        continueToNext2.click();

        WebElement zavrsi = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[4]/div/div/button[2]")));
        zavrsi.click();
        Thread.sleep(1000);

        WebDriverWait waitForMessage = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement message = waitForMessage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/p[contains(text(),'Uspješno ste objavili oglas')]")));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", message);

        Assertions.assertNotNull(message);
        Assertions.assertTrue(message.isDisplayed());
    }




    @Test
    public void testObjaviOglasFail() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement oglasButton = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[2]/div/button"));
        oglasButton.click();
        Thread.sleep(500);
        WebElement acceptButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]"));
        acceptButton.click();

        WebElement nameField = webDriver.findElement(By.name("username"));
        nameField.click();
        nameField.sendKeys("Edina_Kurto_14");
        Thread.sleep(200);
        WebElement passwordField = webDriver.findElement(By.name("password"));
        passwordField.click();
        passwordField.sendKeys("kenai_je_moj_pas_123");
        Thread.sleep(200);
        passwordField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement oglasButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/header/div/div[1]/div[2]/div/button")));
        oglasButton2.click();
        Thread.sleep(500);

        WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div")));
        popup.click();
        WebElement nestoDrugoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div[1]/div/div/button/div/div/div")));
        nestoDrugoButton.click();
        Thread.sleep(200);

        WebElement inputField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/input"));
        inputField.click();
        inputField.sendKeys("Pas");
        WebElement continueButton = webDriver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div/div[2]/button"));
        continueButton.click();

        Thread.sleep(1000);
        WebElement categoriesField = webDriver.findElement(By.cssSelector(".choose-cat > li:nth-child(2) > button:nth-child(1) > div:nth-child(1) > b:nth-child(3)"));
        categoriesField.click();

        WebElement naslovField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/input")));
        naslovField.click();
        naslovField.sendKeys("Pas");

        WebElement priceField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div/input")));
        priceField.click();
        priceField.sendKeys("00.00");

        WebElement continueToNext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[4]/div/div/button[2]")));
        continueToNext.click();

        WebElement naslovErrorMessage = webDriver.findElement(By.xpath("//small[contains(text(),'Naslov mora imati barem dvije riječi, ne smije biti duži od 55 karaktera i mora biti u latiničnom pismu.')]"));

        Assertions.assertNotNull(naslovErrorMessage);
        Assertions.assertTrue(naslovErrorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}