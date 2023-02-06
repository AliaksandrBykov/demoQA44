import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTestGoogleTest {
    // before test method  setUp

    // Tests

    //after test method  tearDown
    WebDriver driver;
    String title;


    @BeforeMethod
    public  void  setUp() {
        driver = new ChromeDriver(); // указываем с каким браузером мы работаем и запускаем его
        driver.manage().window().maximize(); // Открытие браузира (макс окно)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Ожидание (Время ожидание элементов)
        driver.get("https://www.google.com/"); // ссылка на браузер
    }

    @Test
    public void shouldBeRightTitle() {
        title = driver.getTitle(); // Заберает текст со странице и запичывает его
        Assert.assertEquals(title, "Google", "The page contains a wrong title");
    }


    @AfterMethod
    public void  tearDown() {
        driver.quit(); // закрывает браузер
    }


}
