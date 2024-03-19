package tek.tdd.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    public WebElement waitForVisibility(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }


    //Click
    public void clickOnElement(WebElement element) {
        waitForClickable(element).click();
    }

    public void sendText(WebElement element, String textValue) {
        waitForVisibility(element).sendKeys(textValue);
    }

    public boolean isElementDisplayed(WebElement element) {
        return waitForVisibility(element).isDisplayed();
    }

    public boolean isElementEnabled(WebElement element) {
        return waitForVisibility(element).isEnabled();
    }

    public String getElementText(WebElement element) {
        return waitForVisibility(element).getText();
    }

    public void selectFromDropDown(WebElement element, String visibleText) {
        WebElement selectElement = waitForVisibility(element);
        Select select = new Select(selectElement);
        select.selectByVisibleText(visibleText);
    }

}
