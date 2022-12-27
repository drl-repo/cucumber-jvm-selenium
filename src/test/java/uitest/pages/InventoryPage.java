package uitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import uitest.pages.Base;

public class InventoryPage extends Base{

    @FindBy(xpath="//div[@class='header_secondary_container']/span[text()='Products']")
    public WebElement pageHeader;
    
    public InventoryPage(WebDriver driver){
        super(driver);
    }
   
}