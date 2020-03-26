package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedSearchsScreen extends BaseScreen {

    @FindBy(id = "com.ebay.kijiji.ca:id/first_line")
    private WebElement nameSearch;

    @FindBy(id = "com.ebay.kijiji.ca:id/second_line")
    private WebElement frequencySearch;



    public SavedSearchsScreen(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public WebElement getNameSearch() {
        return nameSearch;
    }

    public WebElement getFrequencySearch() {
        return frequencySearch;
    }

    public void goToProductsPage() {
        tap(nameSearch);
    }
}
