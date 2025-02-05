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


public class HomePage {
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
    public void HomePage_Item_PhotoView() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name("notASearchField")));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("Laptop HP Victus 15; R5 7535HS; RX 6550M; 512GB; 16GB; 15\"6 DOPER ");
        searchField.sendKeys(Keys.ENTER);
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement chooseItem= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div/div[3]/div/div[1]/div/a/div/div[2]/div[1]/div[3]/div/div/div[2]/div[1]/div[1]"));
        chooseItem.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement photoview= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[1]/div[1]/div[3]/div/div[1]/div[2]/div/div[4]"));
        photoview.click();
        webDriver.getCurrentUrl();
        WebElement photoview1= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[1]/div[1]/div[3]/div/div[1]/div[2]/div/div[4]"));
        photoview1.click();
        webDriver.getCurrentUrl();
        WebElement photoview2= webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div/div[1]/div[1]/div[3]/div/div[1]/div[2]/div/div[4]"));
        photoview2.click();
        webDriver.getCurrentUrl();
        WebDriverWait wait1 = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.urlToBe("https://olx.ba/artikal/64623248#"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/artikal/64623248#"));
    }

    @Test
    public void HomePage_Filter() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement filter= webDriver.findElement(By.cssSelector(".mb-lg > button:nth-child(2)"));
        filter.click();
        webDriver.getCurrentUrl();
        WebElement category= webDriver.findElement(By.cssSelector(".custom-list > li:nth-child(2)"));
        category.click();
        webDriver.getCurrentUrl();

        WebElement filterButtonAfterSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-lg > button:nth-child(2)")));
        String actualFilterButtonText = filterButtonAfterSelection.getText();
        String expectedFilterButtonText = "Moj dom";
        Assertions.assertEquals(expectedFilterButtonText, actualFilterButtonText);
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("https://olx.ba/"));
    }


    @Test
    public void Packet_Button() throws InterruptedException {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]")));
        acceptButton.click();
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.bg-gray-800 > div:nth-child(1) > button:nth-child(3)")));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        Thread.sleep(1000);
        button.click();
        Assertions.assertEquals("https://olx.ba/shopovi/paketi", webDriver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

