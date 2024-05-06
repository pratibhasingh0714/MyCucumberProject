package hooks;


import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class AppHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties properties;

    @Before(order =0)
    public  void getProperty()
    {
        configReader = new ConfigReader();
        properties = configReader.init_prop();
    }

    @Before(order =1)
    public  void launchBrowser()
    {
        driverFactory = new DriverFactory();
        String browserName = properties.getProperty("browser");
        driver = driverFactory.init_driver(browserName);
    }

    @After(order =1)
    public void takeScreenshot(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs,"image/png",screenshotName);
        }
    }

    @After(order = 0)
    public void tearDown()
    {
        driver.quit();
    }
}
