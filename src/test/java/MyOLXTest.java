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

public class MyOLXTest {
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
    public void testMoji_Oglasi() throws InterruptedException {
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

        WebElement rightMeni = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni.click();
        Thread.sleep(500);
        WebElement aktivniOglasi = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[3]/div[2]/div[2]/a[3]/span"));
        aktivniOglasi.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/artikli/aktivni"));
        Thread.sleep(2000);

        WebElement rightMeni1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni1.click();
        Thread.sleep(500);
        WebElement zavrseniOglasi = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[3]/div[2]/div[2]/a[4]/span"));
        zavrseniOglasi.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/artikli/zavrseni"));
        Thread.sleep(2000);

        WebElement rightMeni2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni2.click();
        Thread.sleep(500);
        WebElement neaktivniOglasi = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[3]/div[2]/div[2]/a[5]/span"));
        neaktivniOglasi.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/artikli/neaktivni"));
        Thread.sleep(2000);

        WebElement rightMeni3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni3.click();
        Thread.sleep(500);
        WebElement narudzbe = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[3]/div[2]/div[2]/a[11]/span"));
        narudzbe.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/narudzbe/aktivne"));
    }

    @Test
    public void testSpaseno() throws InterruptedException {
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
        WebElement rightMeni = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni.click();
        Thread.sleep(500);
        WebElement spaseniOglasi = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.left:nth-child(15) > span:nth-child(2)")));
        spaseniOglasi.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/spaseno/oglasi"));
        Thread.sleep(2000);
        WebElement rightMeni1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni1.click();
        Thread.sleep(500);
        WebElement spaseniKorisnici = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.left:nth-child(16) > span:nth-child(2)")));
        spaseniKorisnici.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/spaseno/korisnici"));
        Thread.sleep(2000);
        WebElement rightMeni2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni2.click();
        Thread.sleep(500);
        WebElement spasenePretrage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.left:nth-child(17) > span:nth-child(2)")));
        spasenePretrage.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/mojolx/spaseno/pretrage"));
    }

    @Test
    public void testOdjava() throws InterruptedException {
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
        WebElement rightMeni = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/div[2]/img[2]")));
        rightMeni.click();
        Thread.sleep(500);
        WebElement odjava = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.left:nth-child(25)")));
        odjava.click();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/"));
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}