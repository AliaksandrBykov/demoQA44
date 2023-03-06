package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBaseLogin {

    WebDriver driver;
    @BeforeMethod
    public  void  setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://demoqa.com/login");
    }

    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }
}
