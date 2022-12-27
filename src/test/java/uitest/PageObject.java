package uitest;

import org.openqa.selenium.WebDriver;
import uitest.pages.LoginPage;
import uitest.pages.InventoryPage;

public class PageObject{
    
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static InventoryPage inventoryPage;
    
    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage loginPage(){
        return (loginPage==null) ? loginPage = new LoginPage(driver) : loginPage;
    }
     public InventoryPage inventoryPage(){
        return (inventoryPage==null) ? inventoryPage = new InventoryPage(driver) : inventoryPage;
    }
    
}