import org.openqa.selenium.By;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
    }

    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }

    @Test
    public void shouldBeRightTitle() {
        login = driver.getTitle();
        Assert.assertEquals(login, "PhonebookUi", "False");
    }


    @Test
    public void  searchPhonebook() {
//        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test@gmail.com");
        driver.findElement(By.className("btn")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(), 'Bakanov ')]")).isDisplayed());


    }

}
