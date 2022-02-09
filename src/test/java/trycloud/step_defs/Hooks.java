package trycloud.step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import trycloud.utility.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    // we can set up hook class that contains
    //methods that run before each scenario and after each scenario
    //or even when we learn tags

    @Before
    public void setupDriver() {

        // set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // you can add maximize browser if you want to do it
        // Driver.getDriver().manage().window().maximize();
    }





    @After
    public void tearDown(Scenario scenario) {

        // check if scenario failed or not
        if(scenario.isFailed()){
            //this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            // scenario.attach(screenshot,"image/png","what ever we want");
            scenario.attach(screenshot,"image/png","Image for failed step");
        }
        Driver.closeBrowser();
    }



}
