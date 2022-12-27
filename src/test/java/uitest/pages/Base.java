package uitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class Base{
    
    protected WebDriver driver;
    int timeout = 30;
    String baseUrl = "https://www.saucedemo.com";
    
    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);
    
    }

}