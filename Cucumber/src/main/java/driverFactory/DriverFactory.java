package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class DriverFactory {

    //private static WebDriver driver;
    public static ThreadLocal<WebDriver> tLocal = new ThreadLocal<WebDriver>();


    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @return
     */
    public WebDriver init_driver(String browser)
    {
        if(browser.equals("chrome"))
        {
            //WebDriverManager.chromedriver().setup();
            String pathSeperator = File.separator;
            String userdir = System.getProperty("user.dir");
        String chromeDriverPath = userdir + pathSeperator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //ChromeDriver driver = new ChromeDriver(chromeOptions);
        tLocal.set(new ChromeDriver());
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tLocal.set(new FirefoxDriver());
        }
        else if (browser.equals("ie")) {
            WebDriverManager.iedriver().setup();
            tLocal.set(new InternetExplorerDriver());
        }
        else {
            System.out.println("Please pass the correct browser: " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * This method is used to get thr driver with threadlocal
     * @return
     */
    public static synchronized WebDriver getDriver()
    {

        return tLocal.get();
    }
}
