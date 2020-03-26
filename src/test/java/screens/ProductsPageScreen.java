package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ProductsPageScreen extends BaseScreen {

    private String query;

    @FindBy(id = "com.ebay.kijiji.ca:id/save_search_switch")
    private WebElement switchSaveSearch;

    @FindBy(id = "com.ebay.kijiji.ca:id/saved_search_name")
    private WebElement searchName;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RadioGroup/android.widget.RadioButton[2]")
    private WebElement weeklyNotification;

    @FindBy(id = "com.ebay.kijiji.ca:id/done")
    private WebElement doneButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/dialog_button_positive")
    private WebElement deleteButton;

    @FindBy (id = "com.ebay.kijiji.ca:id/dialog_button_positive")
    private WebElement confirmationButton;



    public ProductsPageScreen(AppiumDriver<?> appiumDriver, String query) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.query = query;
    }

    public String saveSearch(String frequency){
        tap(switchSaveSearch);
        writeText(searchName, query);
        if (frequency.equals("Weekly")){
            tap(weeklyNotification);
        }
        tap(doneButton);
        implicitWait(500);
        tap(confirmationButton);
        tap(appiumDriver.findElementByAccessibilityId("Navigate up"));


        return query;
    }

    public void deleteSearch() {
        implicitWait(1000);
        tap(switchSaveSearch);
        tap(deleteButton);
    }

    public WebElement getSwitchSaveSearch() {
        return switchSaveSearch;
    }

    public SignInScreen saveSearchGuest(String frequency) {
        tap(switchSaveSearch);
        writeText(searchName, query);
        if (frequency.equals("Weekly")){
            tap(weeklyNotification);
        }
        tap(doneButton);
        appiumDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        return new SignInScreen(appiumDriver);
    }
}
