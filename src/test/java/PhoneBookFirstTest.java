import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PhoneBookFirstTest extends TestBase { // extends Унаследование класса

    String login;

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

    By addNewContact = By.xpath("//*[@class='btn btn-info my-1 btn-block']");

    By fistNameImput = By.xpath("//*[@id='form-name']");

    By lastNameImput = By.xpath("//*[@id='form-lastName']");

    By aboutImput = By.xpath("//*[@id='form-about']");

    By saveButton = By.xpath("//*[@class='btn btn-primary']");

    By fistNameField = By.xpath("//div[@id='contact-first-name']");
    By lastNameField = By.xpath("//div[@id='contact-last-name']");

    By contactDescription = By.xpath("//div[@id='contact-description']");

    @Test
    public void loginTest() {
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail'")).clear();
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail'")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).clear();
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@class='btn btn-info my-1 btn-block']")).click();


        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='navbar-nav mr-auto']/li[last()]")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "http://phonebook.telran-edu.de:8080/contacts");

    }

    public void getAuth() {
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail'")).clear();
        driver.findElement(By.xpath("//*[@id='defaultRegisterFormEmail'")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).clear();
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@class='btn btn-info my-1 btn-block']")).click();

    }

    @Test
    public  void addNewContactTest() {
        String firsName = "Pater";
        String lastName = "Bolt";
        String about = "Peter is my friend";
        getAuth();
        driver.findElement(addNewContact).click();
        driver.findElement(fistNameImput).clear();
        driver.findElement(fistNameImput).sendKeys("Pater");
        driver.findElement(lastNameImput).clear();
        driver.findElement(lastNameImput).sendKeys("Bolt");
        driver.findElement(aboutImput).clear();
        driver.findElement(aboutImput).sendKeys("Peter is my friend");
        driver.findElement(saveButton).click();

        Assert.assertEquals(driver.findElement(fistNameField).getText(),firsName);
        Assert.assertEquals(driver.findElement(lastNameField).getText(),lastName);
        Assert.assertEquals(driver.findElement(contactDescription).getText(),about);



    }


}
