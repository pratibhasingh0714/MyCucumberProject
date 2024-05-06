package stepsDefination;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObject.AccountPage;
import pageObject.LoginPage;

import java.util.List;
import java.util.Map;

public class AccountPageDefination {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getDriver());

    @Given("User has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {

        List<Map<String, String>> maps = dataTable.asMaps();
        String username = maps.get(0).get("Username");
        String password = maps.get(0).get("Password");

        DriverFactory.getDriver().get("https://www.childrensplace.com/us/home");

        accountPage = loginPage.doLogin(username,password);

    }

    @Given("User is in logged in page")
    public void user_is_in_logged_in_page() {
        Assert.assertTrue(accountPage.getWelcomeMsg());

    }
    @Then("User gets the account section")
    public void user_gets_the_account_section(DataTable drawerTable) {
        List<String> expectedDrawerList = drawerTable.asList();
        List<String> actualDrawerList = accountPage.getAccountSectionList();
        Assert.assertTrue(expectedDrawerList.containsAll(actualDrawerList));

    }
    @And("Account section should be {int}")
    public void account_section_should_be(Integer expectedCount) {
        Assert.assertTrue(accountPage.getAccountDrawerSize() == expectedCount);

    }
}
