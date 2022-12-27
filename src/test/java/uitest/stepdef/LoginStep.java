package uitest.stepdef;

import io.cucumber.java.en.*;
import org.testng.Assert;

import uitest.Hook;
import uitest.stepdef.BaseStep;
import uitest.pages.LoginPage;
import uitest.pages.InventoryPage;


public class LoginStep extends BaseStep{
    
    private LoginPage loginPage;
    
    public LoginStep(Hook hook){
        super(hook);
        this.loginPage = pageObject.loginPage();
    }
   
    @Given("i login page")
    public void login_form() {
        loginPage.visit();
    }

    @When("i type {string} and {string}")
    public void fill_credentials(String username, String password) {
        loginPage
            .fillUsername(username)
            .fillPassword(password);
    }   

    @And("i click login button")
    public void click_login() {
        loginPage.clickLogin();
    }

    @Then("i should see {string}")
    public void see_error_message(String expectErrMessage) {
        String errorMessage = loginPage.getErrorMessage().getText();
        Assert.assertEquals(errorMessage, expectErrMessage);
    }

    @Then("i should see inventory page")
    public void see_inventory_page() {
        InventoryPage inventoryPage = pageObject.inventoryPage();
        Assert.assertTrue(inventoryPage.pageHeader.isDisplayed());
    }

}
