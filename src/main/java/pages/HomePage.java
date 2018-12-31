package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;
    By userlogin = By.xpath("//*[@id='container']/div/header/div[1]/div/div[3]/div[1]/div/div/div");
    By phonenumberElement = By.xpath("//*[@id='container']/div/footer/div/div[3]/div[1]/div[6]/div/div[2]/div/div/p[8]/a");
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    public boolean getUserElement() {
        return driver.findElement(userlogin).isDisplayed();
    }
    public String getPhoneNumber() {
        return driver.findElement(phonenumberElement).getText();
    }
}
