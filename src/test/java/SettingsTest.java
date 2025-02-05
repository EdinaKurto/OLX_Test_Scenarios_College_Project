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

public class SettingsTest {
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
    public void SettingNavigation() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement loginLink= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[1]/div[1]/div[2]/a[1]"));
        loginLink.click();
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

        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".items-start")));
        profileButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement settingButton= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/button[1]"));
        settingButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement olxDostave = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[2]/a"));
        olxDostave.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement informacije = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[3]/a"));
        informacije.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement olxPro = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[4]/a"));
        olxPro.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement verifikacije = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[5]/a"));
        verifikacije.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement notifikacije = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[6]/a"));
        notifikacije.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement privatnost = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[7]/a"));
        privatnost.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement profilnaSlika = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[8]/a"));
        profilnaSlika.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement kartice = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[9]/a"));
        kartice.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement sifre = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[10]/a"));
        sifre.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement adresa = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[11]/a"));
        adresa.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/postavke/adresa"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/mojolx/postavke/adresa"));
    }

    @Test
    public void SettingInformationChange() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement loginLink= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[1]/div[1]/div[2]/a[1]"));
        loginLink.click();
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

        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".items-start")));
        profileButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement settingButton= webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/button[1]"));
        settingButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement informacije = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[3]/a"));
        informacije.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement nameChangeField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/form/div[1]/input"));
        nameChangeField.click();
        nameChangeField.sendKeys("Edina");
        Thread.sleep(200);
        WebElement lastNameChangeField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/form/div[2]/input"));
        lastNameChangeField.click();
        lastNameChangeField.sendKeys("Kurto");
        Thread.sleep(200);

        WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/form/div[8]/div[2]/select[1]")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", dateField);
        dateField.click();
        Select date = new Select(dateField);
        date.selectByVisibleText("14");
        WebElement monthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/form/div[8]/div[2]/select[2]")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", monthField);
        monthField.click();
        Select month = new Select(monthField);
        month.selectByVisibleText("08");
        WebElement yearField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/form/div[8]/div[2]/select[3]")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", yearField);
        yearField.click();
        Select year = new Select(yearField);
        year.selectByVisibleText("2002");

        WebElement confirm = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/form/div[10]/button"));
        confirm.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/p")));
        String expectedMessage = "Uspješno ste izmjenili profil.";
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