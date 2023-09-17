package tests;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {

    protected static WebDriver driver;
    static ChromeOptions options = new ChromeOptions();
    public LoginPage loginpage;
    public HomePage homePage;


    @BeforeTest
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*"); // Cause our site need VPN to enable access
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://deposit-fe-test.awaed.co/login");
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void stopDriver() {
        System.out.println("Done testing");
//        driver.quit();
    }

}
