package pageObject;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    //By Locators
    private By userIcon = By.id("non-login-user");
    private  By accoundHeader = By.xpath("//p[contains(text(),'account')]");
    private  By loginLink = By.xpath("//button[@id='login']");
    private  By emaiAddress = By.cssSelector("#emailAddress");
    private  By conitueButton = By.xpath("//button[contains(text(),'Continue')]");
    private  By password = By.id("password");
    private  By loginButton =  By.xpath("//button[contains(text(),'Log In')]");
    private  By forgetPassLink = By.id("forgotPasswordForm");

    //constructor of the page class

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Write a method for the feature

    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public void clickOnUserIcon()
    {
        driver.findElement(userIcon).click();
    }

    public boolean validateAccountText()
    {
        return  driver.findElement(accoundHeader).isDisplayed();
    }

    public boolean validateForgetLink()
    {
        return  driver.findElement(forgetPassLink).isDisplayed();
    }

    public void clickOnLoginLink()
    {
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String userName)
    {
        driver.findElement(emaiAddress).sendKeys(userName);
    }

    public void enterPassword(String passw)
    {
        driver.findElement(password).sendKeys(passw);
    }

    public void clickOnContinueButton()
    {
        driver.findElement(conitueButton).click();
    }
    public void clickOnLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public AccountPage doLogin(String un, String pw)
    {
        driver.findElement(userIcon).click();
        driver.findElement(loginLink).click();
        driver.findElement(emaiAddress).sendKeys(un);
        driver.findElement(conitueButton).click();
        driver.findElement(password).sendKeys(pw);
        driver.findElement(loginButton).click();

        return new AccountPage(driver);
    }

}
