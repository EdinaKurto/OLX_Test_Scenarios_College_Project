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

public class LoginTest {
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
    public void testBasicLogin() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement loginLink= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[1]/div[1]/div[2]/a[1]"));
        loginLink.click();
        webDriver.getCurrentUrl();
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
        webDriver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/"));
    }

    @Test
    public void testLoginFail() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement loginLinkFail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/header/div/div[1]/div[1]/div[2]/a[1]")));
        loginLinkFail.click();
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        nameField.sendKeys("edina.kurtostu.ibu.edu.ba");
        WebElement passwordField = webDriver.findElement(By.name("password"));
        passwordField.sendKeys("kenai_je_moj_pas_123");
        passwordField.sendKeys(Keys.ENTER);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-toast__text")));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", message);
        Assertions.assertNotNull(message);
        Assertions.assertTrue(message.isDisplayed());
        Assertions.assertTrue(message.getText().contains("Podaci nisu tačni."));
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}