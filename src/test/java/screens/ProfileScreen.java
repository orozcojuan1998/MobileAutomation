package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileScreen extends BaseScreen {

    @FindBy(id = "com.ebay.kijiji.ca:id/srp_constraint_layout")
    private WebElement adBody;

    @FindBy(id = "com.ebay.kijiji.ca:id/DeleteAd")
    private WebElement deleteIcon;

    @FindBy(xpath = "//*[@class=\"android.widget.RadioGroup\"]/*[@text=\"Not offering this anymore\"]")
    private WebElement radioReason;

    @FindBy(id = "com.ebay.kijiji.ca:id/dialog_button_positive")
    private WebElement confirmDelete;

    @FindBy(id = "com.ebay.kijiji.ca:id/my_ads_no_ads_text")
    private WebElement emptyAdsDialog;

    public ProfileScreen(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public void deleteAd(){
        tap(adBody);
        implicitWait(500);
        tap(deleteIcon);
        implicitWait(500);
        tap(radioReason);
        implicitWait(500);
        tap(confirmDelete);
        implicitWait(500);
    }

    public WebElement getEmptyAdsDialog() {
        return emptyAdsDialog;
    }
}
