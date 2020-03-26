package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import screens.HomeScreen;
import screens.ProductsPageScreen;
import screens.SavedSearchsScreen;
import screens.SignInScreen;

import java.util.List;
import java.util.Map;

public class SaveSearchSteps {

    private AppiumDriver<?> appiumDriver;
    private HomeScreen homeScreen;
    private ProductsPageScreen productsPageScreen;
    private SavedSearchsScreen savedSearchsScreen;
    private SignInScreen signInScreen;
    private String query;
    private String frequency;

    public SaveSearchSteps(Hook hook) {
        this.appiumDriver = hook.getDriver();
        homeScreen = new HomeScreen(appiumDriver);

    }


    @When("^the user enters the the data$")
    public void theUserEntersTheTheData(DataTable queryData) {
        List<Map<String, String>> data = queryData.asMaps(String.class, String.class);
        productsPageScreen = homeScreen.goToResultsPage(data.get(0).get("query"));
        frequency = data.get(0).get("frequency");

    }

    @And("^the user save the search with daily notifications$")
    public void theUserSaveTheSearchWithDailyNotifications() {
        query = productsPageScreen.saveSearch(frequency);
        savedSearchsScreen = homeScreen.goToSavedSearchs();
    }

    @And("^the user save the search with weekly notifications$")
    public void theUserSaveTheSearchWithWeeklyNotifications() {
        query = productsPageScreen.saveSearch(frequency);
        savedSearchsScreen = homeScreen.goToSavedSearchs();
    }

    @Then("^the search and notifications are saved$")
    public void theSearchAndNotificationsAreSaved() {
        Assert.assertEquals("The names of the save search doesn't match", query, savedSearchsScreen.getNameSearch().getText());
        Assert.assertTrue("Frequency is incorrect", savedSearchsScreen.getFrequencySearch().getText().contains(frequency));

    }

    @Given("^the user is authenticated$")
    public void theUserIsAuthenticated() {
        homeScreen.tapDenyButton();
        signInScreen = homeScreen.goToLoginForm();
        signInScreen.sendCredentials(System.getenv("EMAIL"), System.getenv("PASSWORD"));
    }

    @And("^the saved search is deleted$")
    public void theSavedSearchIsDeleted() {
        savedSearchsScreen.goToProductsPage();
        productsPageScreen.deleteSearch();
        Assert.assertEquals("Cannot delete search", "OFF", productsPageScreen.getSwitchSaveSearch().getText());
    }

    @When("^the guest enters the the data$")
    public void theGuestEntersTheTheData(DataTable queryData) {
        List<Map<String, String>> data = queryData.asMaps(String.class, String.class);
        productsPageScreen = homeScreen.goToResultsPage(data.get(0).get("query"));
        frequency = data.get(0).get("frequency");
    }

    @And("^the guest save the search with daily notifications$")
    public void theGuestSaveTheSearchWithDailyNotifications() {
        signInScreen = productsPageScreen.saveSearchGuest(frequency);
    }

    @Then("^the user is redirected to login page$")
    public void theUserIsRedirectedToLoginPage() {
        Assert.assertTrue("The login button is not present", homeScreen.getLoginButtonConfirm().isDisplayed());
    }
}
