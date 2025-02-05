import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.time.Duration;


public class ShopTest {
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
    public void AutomobiliShopTest() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement shopLink= webDriver.findElement(By.cssSelector("li.mr-md:nth-child(3) > a:nth-child(1)"));
        shopLink.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement automobiliFilter= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/ul/li[1]"));
        automobiliFilter.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement ShopItem= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[1]/a"));
        ShopItem.click();
        webDriver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement aktivniOglas= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/div/div[1]/ul/li[1]/a"));
        aktivniOglas.click();
        webDriver.getCurrentUrl();
        WebElement zavrseniOglas= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/div/div[1]/ul/li[2]/a"));
        zavrseniOglas.click();
        webDriver.getCurrentUrl();
        WebElement dojmovi= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/div/div[1]/ul/li[3]/a"));
        dojmovi.click();
        webDriver.getCurrentUrl();
        WebElement o_nama= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/div/div[1]/ul/li[4]/a"));
        o_nama.click();
        webDriver.getCurrentUrl();
        WebElement radnoVrijeme= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/div/div[1]/ul/li[5]/a"));
        radnoVrijeme.click();
        webDriver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement message = webDriver.findElement(By.xpath("//h1[contains(text(),'Shop nije unio radno vrijeme')]"));
        Assertions.assertNotNull(message);
        Assertions.assertTrue(message.isDisplayed());
    }

    @Test
    public void MobiteliShopTest() throws InterruptedException {
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
        WebElement shopLink= webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[3]"));
        shopLink.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement mobitelFilter= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/ul/li[3]"));
        mobitelFilter.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement ShopItem= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[1]/a"));
        ShopItem.click();
        webDriver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement aktivniOglas= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/div/div[1]/ul/li[1]/a"));
        aktivniOglas.click();
        WebElement favorite= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[2]/div[2]/button[2]"));
        favorite.click();
        webDriver.getCurrentUrl();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/p")));
        String expectedMessage = "Uspješno ste spasili korisnika";
        Assertions.assertNotNull(successMessage);
        Assertions.assertTrue(successMessage.isDisplayed());
        Assertions.assertEquals(expectedMessage, successMessage.getText());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}