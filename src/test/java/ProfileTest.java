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

public class ProfileTest {
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
    public void ProfileLinks() throws InterruptedException {
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
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".items-start")));
        profileButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement aktivniButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/div[3]/div/div[1]/div/ul/li[1]/a")));
        aktivniButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.urlToBe("https://olx.ba/profil/Edina_Kurto_14/aktivni"));
        WebElement zavrseniButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/div[3]/div/div[1]/div/ul/li[2]/a")));
        zavrseniButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);

        wait.until(ExpectedConditions.urlContains("https://olx.ba/profil/Edina_Kurto_14/zavrseni"));
        WebElement failfinishedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Nemate završenih oglasa')]")));
        assertEquals("Nemate završenih oglasa", failfinishedText.getText());
        WebElement dojamButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/div[3]/div/div[1]/div/ul/li[3]/a")));
        dojamButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);

        wait.until(ExpectedConditions.urlContains("https://olx.ba/profil/Edina_Kurto_14/dojmovi"));
        WebElement faildojmoviText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Nemate ostavljenih dojmova')]")));
        assertEquals("Nemate ostavljenih dojmova", faildojmoviText.getText());
    }

    @Test
    public void ProfileOglasiStatistika() throws InterruptedException {
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
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".items-start")));
        profileButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);

        WebElement OglasButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div/a[1]")));
        OglasButton1.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement statistikaButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/button[1]")));
        statistikaButton.click();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait3 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait3.until(ExpectedConditions.urlToBe("https://olx.ba/artikal/65855527#"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/artikal/65855527#"));
    }

    @Test
    public void ProfileOglasSakrij() throws InterruptedException {
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
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".items-start")));
        profileButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);

        WebElement OglasButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div/a[1]")));
        OglasButton1.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement opcijeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/button[2]")));
        opcijeButton.click();

        WebElement hideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div/div/div[2]/div/div[2]/button[2]")));
        hideButton.click();
        WebElement unhideButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/button[2]")));
        unhideButton.click();
    }

    @Test
    public void ProfilePostavke() throws InterruptedException {
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
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".items-start")));
        profileButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);

        WebElement postavke = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/button[1]")));
        postavke.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait3 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait3.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/postavke/korisnicke-informacije"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/mojolx/postavke/korisnicke-informacije"));
    }



    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}