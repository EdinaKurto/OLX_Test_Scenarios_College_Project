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

public class CartTest {
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
    public void cartAdd() throws InterruptedException {
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
        WebElement A1Box= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/div[2]/a"));
        A1Box.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement A1BoxItem= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div[2]/div/div[1]/a[1]"));
        A1BoxItem.click();
        webDriver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement addItemCart= webDriver.findElement(By.cssSelector(".user-contact > button:nth-child(4)"));
        addItemCart.click();
        webDriver.getCurrentUrl();
        Thread.sleep(1000);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-toast__text")));
        String expectedMessage = "Uspješno ste dodali artikal LUX Produžni kabl na kolutu, 4 utičnice 50m 301447 u korpu";
        Assertions.assertNotNull(successMessage);
        Assertions.assertTrue(successMessage.isDisplayed());
        Assertions.assertEquals(expectedMessage, successMessage.getText());
    }

    @Test
    public void cartDelete() throws InterruptedException {
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
        WebElement cart= webDriver.findElement(By.cssSelector("button.mr-md:nth-child(1)"));
        cart.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement goCart= webDriver.findElement(By.cssSelector("button.w-full"));
        goCart.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement delete= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[2]/ul/li/ul/li/div/div[2]/button"));
        delete.click();
        webDriver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-toast__text")));
        String expectedMessage = "Uspješno ste izbrisali oglas iz korpe";
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