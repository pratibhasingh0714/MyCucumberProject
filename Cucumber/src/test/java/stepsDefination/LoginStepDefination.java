package stepsDefination;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;

public class LoginStepDefination {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private static  String loginPageTitle;

    @Given("User navigates to childrens place website")
    public void user_navigates_to_childrens_place_website() {
        DriverFactory.getDriver().get("https://www.childrensplace.com/us/home");
    }

    @When("User gets the title of the page")
    public void get_Title_Of_The_Page() {
        loginPageTitle = loginPage.getLoginPageTitle();
    }

    @Then("User validates the title of the page {string}")
    public void user_validates_the_home_page(String expectedTitle) {
        Assert.assertTrue(loginPageTitle.contains(expectedTitle));
    }

    @And("Click on user icon on home page")
    public void click_on_user_icon_on_home_page() {
        loginPage.clickOnUserIcon();
    }

    @And("User should be in Account login page")
    public void user_should_be_in_page() {
       Assert.assertTrue(loginPage.validateAccountText());
    }

    @And("User clicks Login button on right nav")
    public void user_clicks_login_button_on_right_nav() {
        loginPage.clickOnLoginLink();

    }

    @Then("User clicks on Continue button")
    public void user_clicks_on_Continue_button() {
        loginPage.clickOnContinueButton();

    }
    @Then("forget password link should be displayed")
    public void forget_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.validateForgetLink());

    }

    @And("enters username {string}")
    public void enters_username(String username) {
        loginPage.enterUsername(username);

    }
    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();

    }
    @And("enters password {string}")
    public void enters_password(String password) {
        loginPage.enterPassword(password);
    }
    @Then("Click on login button")
    public void click_on_login_button() {
        loginPage.clickOnLoginButton();

    }
//    @Then("Verify the Welcome text message")
//    public void verify_the_text_message() {
//
//    }
//    @And("Click on Logout button")
//    public void click_on_button() {
//
//    }

}
