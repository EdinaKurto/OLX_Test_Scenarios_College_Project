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

public class CategoriesTest {
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
    public void testVozila() {
        webDriver.get(baseUrl);
        WebElement vozila = webDriver.findElement(By.xpath("//*[@id=\"sect--btn0\"]"));
        vozila.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/vozila"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/vozila"));

        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/h2")));
        Assertions.assertEquals("Polovna i nova vozila, automobili, motocikli, bicikli, kamioni, teretna vozila, quadovi", text.getText());
    }

    @Test
    public void testNekretnine() {
        webDriver.get(baseUrl);
        WebElement nekretnine = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[3]/div"));
        nekretnine.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/nekretnine"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/nekretnine"));

        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[1]/h2")));
        Assertions.assertEquals("Stanovi i apartmani, kuće, zemljišta, poslovni prostori, vikendice, skladišta i hale", text.getText());
    }

    @Test
    public void testServis_Usluge() {
        webDriver.get(baseUrl);
        WebElement servis = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[4]/div"));
        servis.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=2159&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=2159&from_homepage=1"));
    }

    @Test
    public void testPoslovi() {
        webDriver.get(baseUrl);
        WebElement posao = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[5]/div"));
        posao.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=2286&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=2286&from_homepage=1"));
    }

    @Test
    public void testDijelovi() {
        webDriver.get(baseUrl);
        WebElement dio = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[6]/div"));
        dio.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=928&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=928&from_homepage=1"));
    }

    @Test
    public void testMobitel() {
        webDriver.get(baseUrl);
        WebElement mobitel = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[7]/div"));
        mobitel.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=3&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=3&from_homepage=1"));
    }

    @Test
    public void testKompjuter() {
        webDriver.get(baseUrl);
        WebElement komp = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[8]/div"));
        komp.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=5&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=5&from_homepage=1"));
    }

    @Test
    public void testTehnika() {
        webDriver.get(baseUrl);
        WebElement tehnika = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[9]/div"));
        tehnika.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=14&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=14&from_homepage=1"));
    }

    @Test
    public void testMoj_Dom() {
        webDriver.get(baseUrl);
        WebElement dom = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[10]/div"));
        dom.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=701&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=701&from_homepage=1"));
    }

    @Test
    public void testBiznis_Industrija() {
        webDriver.get(baseUrl);
        WebElement biznis = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[11]/div"));
        biznis.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=224&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=224&from_homepage=1"));
    }

    @Test
    public void testOdjca_Obuca() {
        webDriver.get(baseUrl);
        WebElement odjeca = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[12]/div"));
        odjeca.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=465&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=465&from_homepage=1"));
    }

    @Test
    public void testSportska_oprema() {
        webDriver.get(baseUrl);
        WebElement oprema = webDriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div/a[13]/div"));
        oprema.click();
        webDriver.getCurrentUrl();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/pretraga?category_id=171&from_homepage=1"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/pretraga?category_id=171&from_homepage=1"));
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
