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

public class NotificationTest {
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
    public void NotificationButtonTag() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement notificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/a[2]")));
        notificationButton.click();
        Thread.sleep(500);
        webDriver.getCurrentUrl();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div[1]")));
        message.click();
        Thread.sleep(500);

        WebElement tag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/button[1]/img")));
        tag.click();
        Thread.sleep(500);

        WebElement tagField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div[2]/input"));
        tagField.click();
        tagField.sendKeys("Poruka od OLX");
        Thread.sleep(200);
    }

    @Test
    public void NotificationButtonDelete_Invisible() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement notificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/a[2]")));
        notificationButton.click();
        Thread.sleep(500);
        webDriver.getCurrentUrl();
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div[1]")));
        message.click();
        Thread.sleep(500);

        WebElement trash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/button[3]/img")));
        trash.click();
        Thread.sleep(500);
        WebElement no = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/button[2]"));
        no.click();
        Thread.sleep(200);

        WebElement invisible = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/button[2]/img"));
        invisible.click();
        Thread.sleep(200);
    }

    @Test
    public void NotificationLinks_LearnMore() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement notificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/a[2]")));
        notificationButton.click();
        Thread.sleep(500);
        webDriver.getCurrentUrl();
        WebElement learnMore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/div[1]/div/div/p/strong/a")));
        learnMore.click();
        Thread.sleep(500);
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", learnMore.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.urlToBe("https://pomoc.olx.ba/hc/bs/articles/10951631379858-Savjeti-za-online-sigurnost"));
        Assertions.assertEquals("https://pomoc.olx.ba/hc/bs/articles/10951631379858-Savjeti-za-online-sigurnost", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }

    @Test
    public void NotificationLinks_MoreAboutSecurity() throws InterruptedException {
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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement notificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/a[2]")));
        notificationButton.click();
        Thread.sleep(500);
        webDriver.getCurrentUrl();
        WebElement learnMoreSecurity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div[2]/div[2]/a")));
        learnMoreSecurity.click();
        Thread.sleep(500);
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", learnMoreSecurity.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.urlToBe("https://olx.ba/o-olxu/online-sigurnost"));
        Assertions.assertEquals("https://olx.ba/o-olxu/online-sigurnost", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }



    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}