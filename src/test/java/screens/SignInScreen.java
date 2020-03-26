package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInScreen extends BaseScreen{


    @FindBy(id = "com.ebay.kijiji.ca:id/new_login_fragment_email")
    private WebElement emailInput;

    @FindBy(id = "com.ebay.kijiji.ca:id/new_login_fragment_password")
    private WebElement passwordInput;

    @FindBy(id = "com.ebay.kijiji.ca:id/new_login_fragment_continue")
    private WebElement signinButton;

    private By loginFail = By.id("com.ebay.kijiji.ca:id/message");


    public SignInScreen(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public void sendCredentials(String user, String password) {
        writeText(emailInput, user);
        writeText(passwordInput, password);
        tap(signinButton);
    }


    public WebElement getSigninButton() {
        return signinButton;
    }

    public By getLoginFail() {
        return loginFail;
    }
}
