package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.StaticWait;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import screens.HomeScreen;
import screens.SignInScreen;

import java.util.concurrent.TimeUnit;

public class SigninSteps {

    private AppiumDriver<?> appiumDriver;
    private HomeScreen homeScreen;
    private SignInScreen signInScreen;

    public SigninSteps(Hook hook){
        appiumDriver = hook.getDriver();
        homeScreen = new HomeScreen(appiumDriver);
    }
    
    
    @Given("^the user is in the app home screen$")
    public void theUserIsInTheAppHomeScreen() {
        homeScreen.tapDenyButton();
    }


    @When("^the user tries to login with valid data$")
    public void theUserTriesToLoginWithValidData() {
        signInScreen = homeScreen.goToLoginForm();
        signInScreen.sendCredentials(System.getenv("EMAIL"),System.getenv("PASSWORD"));

    }

    @Then("^the user is logged in$")
    public void theUserIsLoggedIn() {
        WebElement email = homeScreen.goToSideMenu();
        Assert.assertTrue("Esta presente",email.isDisplayed());
        Assert.assertEquals("The email is incorrect", System.getenv("EMAIL"),email.getText());

    }

    @When("^the user tries to login with invalid email$")
    public void theUserTriesToLoginWithInvalidEmail() {
        signInScreen = homeScreen.goToLoginForm();
        signInScreen.sendCredentials("notvalidemail@gmail.com",System.getenv("PASSWORD"));
    }

    @When("^the user tries to login with invalid password$")
    public void theUserTriesToLoginWithInvalidPassword() {
        signInScreen = homeScreen.goToLoginForm();
        signInScreen.sendCredentials(System.getenv("EMAIL"),"invalidpassword");

    }

    @When("^the user tries to logout from the app$")
    public void theUserTriesToLogoutFromTheApp() {
        homeScreen.goToSignOutPage();
        homeScreen.waitElementVisibility(homeScreen.getSignOut());
        homeScreen.logOut();

    }

    @Then("^the user is logged out of the app$")
    public void theUserIsLoggedOutOfTheApp() {
        homeScreen.tap(homeScreen.getSideMenu());
        Assert.assertTrue("Mensaje de bienvenido no encontrado", homeScreen.getSideMenu().isDisplayed());
    }

    @Then("^the user is informed that his credentials are wrong$")
    public void theUserIsInformedThatHisCredentialsAreWrong() {
        homeScreen.waitElementVisibility(signInScreen.getLoginFail());
        WebElement loginFaiPopup = appiumDriver.findElement(signInScreen.getLoginFail());
        Assert.assertTrue("Esta presente",loginFaiPopup.isDisplayed());
        System.out.println(loginFaiPopup.getText());
    }

    @Given("^the guest is in the app home screen$")
    public void theGuestIsInTheAppHomeScreen() {
        homeScreen.tapDenyButton();
    }
}
