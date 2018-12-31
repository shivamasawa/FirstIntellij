package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FirstPage;
import pages.HomePage;
import resources.BasePage;

import java.io.IOException;

public class FirstPageTest extends BasePage {
    public WebDriver driver;
    FirstPage firstPage;
    HomePage homePage;
    public static Logger log = (Logger) LogManager.getLogger(BasePage.class.getName());

    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized.");
        firstPage = new FirstPage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    public void verifyLogin() {
        firstPage.getUserName().sendKeys(prop.getProperty("user"));
        firstPage.getPassword().sendKeys(prop.getProperty("pwd"));
        firstPage.loginButton().click();
        Assert.assertTrue(homePage.getUserElement());
        log.info("User Logged in Successfully");
    }
    /*@DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        data[0][0] = prop.getProperty("user1");
        data[0][1] = prop.getProperty("pwd1");
        data[1][0] = prop.getProperty("user2");
        data[1][1] = prop.getProperty("pwd2");
        return data;
    }*/

}
