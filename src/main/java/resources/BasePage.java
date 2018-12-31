package resources;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BasePage {
    protected static WebDriver driver;
    protected Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\New IntelliJ\\src\\config\\configs.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashawa.shivam\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\ashawa.shivam\\Downloads\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void getScreenshot(String result) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D://New IntelliJ//screenshots//"+result+"snap.png"));    }

    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
}
