package uitest;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;

public class Hook{

    private static WebDriver driver;

    @BeforeAll
    public static void init(){
        if (driver == null) {
            driver = new ChromeDriver();
        }
        System.out.println("Starting Test...");
    }   

    public WebDriver getDriver(){
        return driver;
    }

    @AfterAll
    public static void afterAll(){
        driver.close();
    }

    @After
    public void afterEachScenario(Scenario scenario){
        
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        }   
        
    }
}