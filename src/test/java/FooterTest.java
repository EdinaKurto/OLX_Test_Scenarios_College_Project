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

public class FooterTest {
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
    public void InformacijeiKontakt_O_nama() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(1000);
        WebElement o_namaLink = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[1]/li[2]/a"));
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", o_namaLink.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        Assertions.assertEquals("https://pomoc.olx.ba/hc/bs/articles/211257409-O-nama", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }

    @Test
    public void InformacijeiKontakt_Marketing() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(1000);
        WebElement o_namaLink = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[1]/li[5]/a"));
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", o_namaLink.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        Assertions.assertEquals("https://marketing.olx.ba/", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }

    @Test
    public void InformacijeiKontaktUslovi() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement usloviLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[1]/li[3]/a")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", usloviLink);
        Thread.sleep(1000);
        usloviLink.click();
        Assertions.assertEquals("https://olx.ba/o-olxu/uslovi-koristenja", webDriver.getCurrentUrl());
    }

    @Test
    public void InformacijeiKontaktOnline_sigurnost() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement online_sigurnostLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".footer-links > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", online_sigurnostLink);
        Thread.sleep(1000);
        online_sigurnostLink.click();
        Assertions.assertEquals("https://olx.ba/o-olxu/online-sigurnost", webDriver.getCurrentUrl());
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------

    @Test
    public void Ostali_Linkovi_Blog() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(1000);
        WebElement blogLink = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[2]/li[2]/a"));
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", blogLink.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        Assertions.assertEquals("https://blog.olx.ba/", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }
    //Blog page is not working properly

    @Test
    public void Ostali_Linkovi_Shop() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement shopLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[2]/li[3]/a")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", shopLink);
        Thread.sleep(1000);
        shopLink.click();
        Assertions.assertEquals("https://olx.ba/shopovi", webDriver.getCurrentUrl());
    }

    @Test
    public void Ostali_Linkovi_OlxTeam() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(1000);
        WebElement teamLink = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[2]/li[4]/a"));
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", teamLink.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        Assertions.assertEquals("https://www.olxgroup.com/", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }

    @Test
    public void Ostali_Linkovi_Dostava() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement shopLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[2]/li[5]/a")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", shopLink);
        Thread.sleep(1000);
        shopLink.click();
        Assertions.assertEquals("https://olx.ba/o-olxu/sta-je-olx-brza-dostava", webDriver.getCurrentUrl());
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------

    @Test
    public void Vas_OLX_Kredit() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement kredit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[3]/li[2]/a")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", kredit);
        Thread.sleep(1000);
        kredit.click();
        Assertions.assertEquals("https://olx.ba/o-olxu/olxkredit", webDriver.getCurrentUrl());
    }

    @Test
    public void Vas_OLX_Sigurnost() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(1000);
        WebElement sigurnost = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[3]/li[3]/a"));
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", sigurnost.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        Assertions.assertEquals("https://blog.olx.ba/2015/04/zlatna-pravila-za-vasu-sigurnost-na-olx-ba/", webDriver.getCurrentUrl());
        webDriver.close();
        webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
    }
    //Blog page is not working properly so this one dosen't work automatically


    @Test
    public void Vas_OLX_Pravila() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement pravila = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[1]/ul[3]/li[4]/a")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", pravila);
        Thread.sleep(1000);
        pravila.click();
        Assertions.assertEquals("https://olx.ba/o-olxu/uslovi-koristenja", webDriver.getCurrentUrl());
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------


    @Test
    public void Podrska() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(1000);
        WebElement podrska = webDriver.findElement(By.cssSelector(".support"));
        ((JavascriptExecutor) webDriver).executeScript("window.open(arguments[0], '_blank');", podrska.getAttribute("href"));
        Thread.sleep(1000);
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        Assertions.assertEquals("https://pomoc.olx.ba/hc/bs", webDriver.getCurrentUrl());
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