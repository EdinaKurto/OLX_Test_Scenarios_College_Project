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

public class NavigationTest {
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
    public void testTopNavigation_Pocetna() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement pocetnaLink= webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[1]/a"));
        pocetnaLink.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/"));
    }

    @Test
    public void testTopNavigation_Kategorije() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement kategorijeLink= webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[2]/a"));
        kategorijeLink.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/kategorije"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/kategorije"));
    }

    @Test
    public void testTopNavigation_Marketing() throws InterruptedException {
        webDriver.get(baseUrl);
        WebElement marketingLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[4]/a"));
        marketingLink.click();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://marketing.olx.ba/"));
        Assertions.assertEquals("https://marketing.olx.ba/", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }

    @Test
    public void testTopNavigation_Shops() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);
        WebElement shopLink= webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[3]/a"));
        shopLink.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/shopovi"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/shopovi"));
    }

    @Test
    public void testTopNavigation_Blog() throws InterruptedException {
        webDriver.get(baseUrl);
        WebElement blogLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[5]/a"));
        blogLink.click();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://blog.olx.ba/"));
        Assertions.assertEquals("https://blog.olx.ba/", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }

    @Test
    public void testTopNavigation_OtherLinks_PodrškaKorisnicima() {
        webDriver.get(baseUrl);
        WebElement ostaliLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[7]"));
        ostaliLink.click();
        WebElement podrska = webDriver.findElement(By.linkText("Podrška korisnicima"));
        podrska.click();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://pomoc.olx.ba/hc/bs"));
        Assertions.assertEquals("https://pomoc.olx.ba/hc/bs", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }

    @Test
    public void testTopNavigation_OtherLinks_Onama () {
        webDriver.get(baseUrl);

        WebElement ostaliLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[7]"));
        ostaliLink.click();

        WebElement o_nama = webDriver.findElement(By.linkText("O nama"));
        o_nama.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/o-olxu/o-nama"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/o-olxu/o-nama"));
    }

    @Test
    public void testTopNavigation_OtherLinks_UsloviKorištenja() {
        webDriver.get(baseUrl);
        WebElement ostaliLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[7]"));
        ostaliLink.click();
        WebElement uslovi = webDriver.findElement(By.linkText("Uslovi korištenja"));
        uslovi.click();
        webDriver.getCurrentUrl();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/o-olxu/uslovi-koristenja"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/o-olxu/uslovi-koristenja"));
    }

    @Test
    public void testTopNavigation_OtherLinks_OLXKredit() {
        webDriver.get(baseUrl);
        WebElement ostaliLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[7]"));
        ostaliLink.click();
        WebElement kredit = webDriver.findElement(By.linkText("OLX kredit"));
        kredit.click();
        webDriver.getCurrentUrl();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/o-olxu/olxkredit"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/o-olxu/olxkredit"));
    }

    @Test
    public void testTopNavigation_OtherLinks_Sigurnost() {
        webDriver.get(baseUrl);

        WebElement ostaliLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[7]"));
        ostaliLink.click();

        WebElement sigurnost = webDriver.findElement(By.linkText("Online sigurnost"));
        sigurnost.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/o-olxu/online-sigurnost"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/o-olxu/online-sigurnost"));
    }

    @Test
    public void testTopNavigation_OtherLinks_Privatnost() {
        webDriver.get(baseUrl);
        WebElement ostaliLink = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[7]"));
        ostaliLink.click();
        WebElement privatnost = webDriver.findElement(By.linkText("Privatnost podataka"));
        privatnost.click();
        webDriver.getCurrentUrl();
        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/o-olxu/privatnost-podataka"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/o-olxu/privatnost-podataka"));
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}