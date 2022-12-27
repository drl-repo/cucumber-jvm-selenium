package uitest.stepdef;

import org.openqa.selenium.WebDriver;
import uitest.PageObject;
import uitest.Hook;


public class BaseStep{
    
    private WebDriver driver;
    protected PageObject pageObject;
    
    public BaseStep(Hook hook){        
        this.driver = hook.getDriver();
        this.pageObject = new PageObject(this.driver);
    }
}