package screens;

import entities.Ad;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostScreen extends BaseScreen {


    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowPhotosButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/done")
    private WebElement skipDoneButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/titleEditText")
    private WebElement titleInput;

    @FindBy(id = "com.ebay.kijiji.ca:id/descriptionEditText")
    private WebElement descriptionInput;

    @FindBy(id = "com.ebay.kijiji.ca:id/post_ad_category_info")
    private WebElement category;

    @FindBy(xpath = "//*[@class=\"android.widget.ListView\"]/android.widget.LinearLayout[6]")
    private WebElement services;

    @FindBy(xpath = "//*[@class=\"android.widget.ListView\"]/android.widget.LinearLayout[6]")
    private WebElement nannyService;

    @FindBy(id = "com.ebay.kijiji.ca:id/post_ad_location_contact_spoke")
    private WebElement locationInput;

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowConfirm;

    @FindBy(id = "com.ebay.kijiji.ca:id/universal_address_entry")
    private WebElement locationTextBox;

    @FindBy(id = "com.ebay.kijiji.ca:id/phoneEditText")
    private WebElement phoneInput;

    @FindBy(id = "com.ebay.kijiji.ca:id/save")
    private WebElement saveButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/post_ad_button")
    private WebElement postButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/skip")
    private WebElement skipAdButton;

    @FindBy(id = "com.ebay.kijiji.ca:id/success")
    private WebElement successDialog;

    @FindBy(id = "com.ebay.kijiji.ca:id/dialog_button_positive")
    private WebElement agreeTerms;

    @FindBy(id = "com.ebay.kijiji.ca:id/close")
    private WebElement closeWindow;

    @FindBy(id =("android:id/button2"))
    private WebElement confirmButton;

    public PostScreen(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public void denyGoToPostForm() {
        tap(allowPhotosButton);
        tap(skipDoneButton);
        implicitWait(1000);
    }
//childcare, nanny
    //I am offering
    public void sendPostData(Ad ad, boolean flag) {
        writeText(titleInput,ad.getTitle());
        writeText(descriptionInput,ad.getDescription());
        tap(category);
        implicitWait(500);
        tap(services);
        tap(nannyService);
        tap(skipDoneButton);
        implicitWait(500);
        tap(locationInput);
        tap(allowConfirm);
        tap(confirmButton);
        writeText(locationTextBox,ad.getLocation());
        tap(saveButton);
        tap(saveButton);
        writeText(phoneInput,ad.getPhone());
        tap(postButton);
        if (flag){
            tap(agreeTerms);
            implicitWait(1000);
            tap(skipAdButton);
        }
        implicitWait(500);
    }


    public WebElement getSuccessDialog() {
        return successDialog;
    }

    public WebElement getTitleInput() {
        return titleInput;
    }

    public WebElement getDescriptionInput() {
        return descriptionInput;
    }

    public WebElement getCategory() {
        return category;
    }

    public WebElement getLocationInput() {
        return locationInput;
    }

    public WebElement getPhoneInput() {
        return phoneInput;
    }

    public ProfileScreen closeTab() {
        tap(closeWindow);
        implicitWait(500);

        return new ProfileScreen(appiumDriver);
    }
}
