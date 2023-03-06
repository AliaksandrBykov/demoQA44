package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaPage {
    WebDriver driver;

    public DemoQaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
// статическое поля
    @FindBy (xpath = "//input[@id='userName']")
    private WebElement userNameInput;

    @FindBy(xpath =  "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@id='login']" )
    private WebElement loginButton;

    @FindBy(xpath = "//p[@id='name']")
    private WebElement errorMessage;

    public void getLogin(String userName, String password) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMassage() {
        return errorMessage.getText();
    }




}

