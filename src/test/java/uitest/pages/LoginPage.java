package uitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import uitest.pages.Base;

public class LoginPage extends Base{

    @FindBy(id="user-name")
    private WebElement inpUsername;

    @FindBy(id="password")
    private WebElement inpPassword;

    @FindBy(id="login-button")
    private WebElement btnLogin;

    @FindBy(css="[data-test='error']")
    private WebElement divErrorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void visit(){
        driver.get(baseUrl);
    }

    public LoginPage fillUsername(String str){
        inpUsername.sendKeys(str);
        return this;
    }

    public LoginPage fillPassword(String str){
        inpPassword.sendKeys(str);
        return this;
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public WebElement getErrorMessage(){
        return divErrorMessage;
    }

}