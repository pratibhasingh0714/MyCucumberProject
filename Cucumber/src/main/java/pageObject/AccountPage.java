package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountPage {
    private WebDriver driver;

    private By accountSection = By.xpath("//div[@id='sideNavUserInfo']/child::div");
    private  By Welcome = By.xpath("//span[contains(text(),'Welcome')]");

    public AccountPage(WebDriver driver)
    {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public int getAccountDrawerSize()
    {
        return driver.findElements(accountSection).size();
    }

    public boolean getWelcomeMsg()
    {
        return  driver.findElement(Welcome).isDisplayed();
    }

    public List<String> getAccountSectionList()
    {
        List<WebElement> elements = driver.findElements(accountSection);
        List<String> accountList = new ArrayList<String>();
        for(WebElement e: elements)
        {
            String list = e.getText();
            accountList.add(list);
        }
        return  accountList;
    }
}
