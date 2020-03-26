package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomeScreen extends BaseScreen {


    @FindBy(id = "com.ebay.kijiji.ca:id/cancel")
    private WebElement denyButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/home_search_icon")
    private WebElement sideMenu;

    @FindBy(id = "com.ebay.kijiji.ca:id/signInButtonInDrawer")
    private WebElement loginButton;

    @FindBy(xpath = " //*[@text=\"Post\"] ")
    private WebElement postButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/home_search_edittext")
    private WebElement searchItem;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.RelativeLayout[7]")
    private WebElement savedSearchs;

    @FindBy(id = "com.ebay.kijiji.ca:id/new_login_choice_sign_in")
    private WebElement loginButtonConfirm;

    private By deny = By.id("com.ebay.kijiji.ca:id/cancel");

    private By emailDetail = By.id("com.ebay.kijiji.ca:id/user_profile_email");

    private By profileAccount = By.id("com.ebay.kijiji.ca:id/userProfileContainer");

    private By settings = By.id("com.ebay.kijiji.ca:id/action_settings");

    private By signOut = By.id("com.ebay.kijiji.ca:id/logoutButton");

    private By sideMenuButton = By.id("com.ebay.kijiji.ca:id/home_search_icon");


    public HomeScreen(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public WebElement getDenyButton() {
        return denyButton;
    }

    public WebElement getSideMenu() {
        return sideMenu;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }



    public WebElement getPostButton() {
        return postButton;
    }

    public By getEmailDetail() {
        return emailDetail;
    }



    public By getProfileAccount() {
        return profileAccount;
    }

    public By getSettings() {
        return settings;
    }

    public By getSignOut() {
        return signOut;
    }

    public WebElement getLoginButtonConfirm() {
        return loginButtonConfirm;
    }

    public SignInScreen goToLoginForm() {
        tap(sideMenu);
        implicitWait(500);
        tap(loginButton);
        implicitWait(500);
        tap(loginButtonConfirm);
        implicitWait(500);
        return new SignInScreen(appiumDriver);
    }

    public void goToSignOutPage() {
        waitElementVisibility(profileAccount);
        WebElement profile = appiumDriver.findElement(profileAccount);
        tap(profile);
        waitElementVisibility(settings);
        WebElement settings = appiumDriver.findElement(this.settings);
        tap(settings);
    }

    public PostScreen goToPostPage() {
        tap(postButton);

        return new PostScreen(appiumDriver);
    }

    public ProductsPageScreen goToResultsPage(String query) {
        writeText(searchItem,query);
        tap(searchItem);
        ((AndroidDriver<MobileElement>) appiumDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
        implicitWait(1000);
        return new ProductsPageScreen(appiumDriver,query);
    }

    public SavedSearchsScreen goToSavedSearchs() {
        tap(sideMenu);
        tap(savedSearchs);

        return new SavedSearchsScreen(appiumDriver);
    }

    public void tapDenyButton() {
        waitElementVisibility(deny);
        tap(getDenyButton());
    }

    public void logOut() {
        WebElement signOut = appiumDriver.findElement(getSignOut());
        tap(signOut);
        implicitWait(1000);
    }

    public WebElement goToSideMenu() {
        waitElementVisibility(sideMenuButton);
        tap(this.getSideMenu());
        return appiumDriver.findElement(getEmailDetail());
    }
}
