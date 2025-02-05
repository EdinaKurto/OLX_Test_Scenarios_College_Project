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

public class SearchBarTest {
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
    public void searchbarItem() {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name("notASearchField")));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("renault clio");
        searchField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("https://olx.ba/pretraga?q=renault+clio"));
    }

    @Test
    public void searchbarItemNotFound() {
        webDriver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.name("notASearchField")));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("moj dragi pas kenai");
        searchField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("https://olx.ba/pretraga?q=moj+dragi+pas+kenai"));
        WebElement failText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Nema rezultata za traženi pojam')]")));
        assertEquals("Nema rezultata za traženi pojam", failText.getText());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}