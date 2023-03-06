package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DemoQaPage;

public class DemoQaLoginTest extends TestBaseLogin {

    String userName = "userName";

    String password ="1234553";

    String actualErrorMessage;

    String expectedErrorMassage = "Invalid username or password!";

    DemoQaPage demoQaPage;

    @Test
    public void demoQaLoginTest() {
        demoQaPage = new DemoQaPage(driver);
        demoQaPage.getLogin(userName, password);
        actualErrorMessage = demoQaPage.getErrorMassage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMassage,
                "Фактический текст сообщения не соответствует ожидаемому");
    }

}
