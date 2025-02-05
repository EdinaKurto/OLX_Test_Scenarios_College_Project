import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class RegisterTest {

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
    public void testBasicRegistration() throws InterruptedException {
        webDriver.get(baseUrl);

        Thread.sleep(200);
        WebElement registrationButton = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/a[2]"));
        registrationButton.click();
        webDriver.getCurrentUrl();
        Thread.sleep(500);
        WebElement acceptButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]"));
        acceptButton.click();

        WebElement emailField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/input"));
        emailField.click();
        emailField.sendKeys("edina.kurto14@gmail.com");
        Thread.sleep(200);
        WebElement passwordField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"));
        passwordField.click();
        passwordField.sendKeys("kenai_je_moj_pas_123");
        Thread.sleep(200);
        WebElement nameField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[3]/div/input"));
        nameField.click();
        nameField.sendKeys("Edina_i_pas");
        Thread.sleep(200);

        WebElement genderField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[4]/select"));
        genderField.click();
        Select gender = new Select(webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[4]/select")));
        gender.selectByValue("female");
        Thread.sleep(200);

        WebElement regionField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[5]/div[1]/div[2]/select"));
        regionField.click();
        Select region = new Select(webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[5]/div[1]/div[2]/select")));
        region.selectByValue("9");
        Thread.sleep(200);

        WebElement placeField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[5]/div[2]/div/div[2]/select"));
        placeField.click();
        Select place = new Select(webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[5]/div[2]/div/div[2]/select")));
        place.selectByValue("133");
        Thread.sleep(200);

        WebElement checkbox = webDriver.findElement(By.xpath("//*[@id=\"checkbox\"]"));
        checkbox.click();

        WebElement registerButton = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/button/div"));
        registerButton.click();
        webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/button")).click();

        System.out.println("Current URL: " + webDriver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://olx.ba/vodic"));
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://olx.ba/vodic"));
    }


    @Test
    public void testInvalidEmail() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);

        WebElement registrationButton = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/a[2]"));
        registrationButton.click();
        Thread.sleep(500);

        WebElement acceptButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]"));
        acceptButton.click();

        WebElement emailField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/input"));
        emailField.click();
        emailField.sendKeys("edina.kurto94gmail.com");
        Thread.sleep(200);

        WebElement passwordField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"));
        passwordField.click();
        passwordField.sendKeys("kenai_je_moj_pas_123");
        Thread.sleep(200);

        WebElement registerButton = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/button/div"));
        registerButton.click();
        Thread.sleep(200);

        WebElement emailErrorMessage = webDriver.findElement(By.xpath("//small[contains(text(),'Polje email mora biti validna e-mail addressa.')]"));

        Assertions.assertNotNull(emailErrorMessage);
        Assertions.assertTrue(emailErrorMessage.isDisplayed());
    }


    @Test
    public void testInvalidPassword() throws InterruptedException {
        webDriver.get(baseUrl);
        Thread.sleep(200);

        WebElement registrationButton = webDriver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[2]/a[2]"));
        registrationButton.click();
        Thread.sleep(500);

        WebElement acceptButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/button[2]"));
        acceptButton.click();

        WebElement emailField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/input"));
        emailField.click();
        emailField.sendKeys("edina.kurto94@gmail.com");
        Thread.sleep(200);

        WebElement passwordField = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/input"));
        passwordField.click();
        passwordField.sendKeys("kenai");
        Thread.sleep(200);

        WebElement registerButton = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/button/div"));
        registerButton.click();
        Thread.sleep(200);

        WebElement passwordErrorMessage = webDriver.findElement(By.xpath("//small[contains(text(),'Šifra ne smije biti kraća od 8 karaktera')]"));

        Assertions.assertNotNull(passwordErrorMessage);
        Assertions.assertTrue(passwordErrorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}