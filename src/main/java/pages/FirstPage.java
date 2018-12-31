package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage {
    public WebDriver driver;
    By username = By.xpath("//*[@class='Km0IJL col col-3-5']/div/form/div[1]/input");
    By password = By.xpath("//*[@class='Km0IJL col col-3-5']/div/form/div[2]/input");
    By login = By.xpath("//*[@class='_2AkmmA _1LctnI _7UHT_c']");
    public FirstPage(WebDriver driver) {
        this.driver=driver;
    }
    public WebElement getUserName() {
        return driver.findElement(username);
    }
    public WebElement getPassword() {
        return driver.findElement(password);
    }
    public WebElement loginButton() {
        return driver.findElement(login);
    }
}
