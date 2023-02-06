import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PhoneBookFirstTest {

    WebDriver driver;

    String login;

    @BeforeMethod
    public  void  setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
    }


    @Test
    public void shouldBeRightTitle() {
        login = driver.getTitle();
        Assert.assertEquals(login, "PhonebookUi", "False");
    }

    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }
}
