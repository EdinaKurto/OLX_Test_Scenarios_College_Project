import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.junit.Assert.*;

public class HTTPEnforcement {
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
    public void testHTTPEnforcement() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        assertEquals("https://olx.ba/", webDriver.getCurrentUrl());
    }

    @Test
    public void testHTTPSStartWith() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        assertTrue(webDriver.getCurrentUrl().startsWith("https"));
    }

    @Test
    public void testHTTPSNotEquals() throws InterruptedException {
        webDriver.get(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        assertNotEquals("http://olx.ba/", webDriver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}