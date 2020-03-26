package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Ad;
import helpers.StaticWait;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import screens.HomeScreen;
import screens.PostScreen;
import screens.ProfileScreen;

public class CreateAdSteps {

    private AppiumDriver<?> appiumDriver;
    private HomeScreen homeScreen;
    private PostScreen postScreen;
    private ProfileScreen profileScreen;
    private Ad ad;

    public CreateAdSteps(Hook hook){
        appiumDriver = hook.getDriver();
        homeScreen = new HomeScreen(appiumDriver);
    }

    @Given("^the user wants to create a new ad$")
    public void theUserWantsToCreateANewAd() {
        homeScreen.tap(homeScreen.getSideMenu());
        postScreen = homeScreen.goToPostPage();
        postScreen.denyGoToPostForm();

    }

    @When("^the user enters the data to create the ad$")
    public void theUserEntersTheDataToCreateTheAd() {
        ad = new Ad("Great nanny service","Nanny services in Alberta, Canada","Alberta", "417-545-0160");
        postScreen.sendPostData(ad,true);

    }

    @Then("^the add is successfully create in the app$")
    public void theAddIsSuccessfullyCreateInTheApp() {
        Assert.assertTrue("Success element not present", postScreen.getSuccessDialog().isDisplayed());
        Assert.assertEquals("Unsuccessful ad creation","Success!", postScreen.getSuccessDialog().getText());

    }

    @When("^the user enters the data to create the ad with empty data$")
    public void theUserEntersTheDataToCreateTheAdWithEmptyData() {
        ad = new Ad("","Nanny services in Toronto","York", "416-555-0160");
        postScreen.sendPostData(ad,false);
    }

    @Then("^the user is informed that the title can't be empty$")
    public void theUserIsInformedThatTheTitleCanTBeEmpty() {
        Assert.assertTrue("The element is not presente", postScreen.getTitleInput().isDisplayed());
        Assert.assertTrue("The element is not presente", postScreen.getDescriptionInput().isDisplayed());
        Assert.assertTrue("The element is not presente", postScreen.getCategory().isDisplayed());
        Assert.assertTrue("The element is not presente", postScreen.getLocationInput().isDisplayed());
        Assert.assertTrue("The element is not presente", postScreen.getPhoneInput().isDisplayed());

    }

    @When("^the user enters the data to create the ad with invalid phone number$")
    public void theUserEntersTheDataToCreateTheAdWithInvalidPhoneNumber() {
        ad = new Ad("New product","Nanny services in Toronto","York", "Text");
        postScreen.sendPostData(ad,false);
    }

    @And("^the post is deleted$")
    public void thePostIsDeleted() {
        profileScreen = postScreen.closeTab();
        profileScreen.deleteAd();
        Assert.assertEquals("Ad couldn't be removed","List an item now",profileScreen.getEmptyAdsDialog().getText());
    }
}
