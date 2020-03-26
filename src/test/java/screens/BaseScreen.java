package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseScreen {

    protected AppiumDriver<?> appiumDriver;
    protected WebDriverWait webDriverWait;

    public BaseScreen(AppiumDriver<?> appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver,this);
    }

    public void tap(WebElement element) {
        element.click();
    }
    public void writeText(WebElement element, String word) {
        element.sendKeys(word);
    }

    public void waitElementVisibility(By element){
        webDriverWait = new WebDriverWait(appiumDriver, Long.parseLong("10"));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void implicitWait(long value){
        appiumDriver.manage().timeouts().implicitlyWait(value, TimeUnit.MILLISECONDS);
    }

    public void waitElementClickable(By element){
        webDriverWait = new WebDriverWait(appiumDriver, Long.parseLong("5"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
