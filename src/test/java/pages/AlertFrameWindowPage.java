package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsSubmenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesElement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsSubmenu;

    public void interactWithAlertsSubMenu() {
        elementHelper.clickElement(alertsSubmenu);
    }

    public void interactWithFramesSubMenu() {
        elementHelper.clickElement(framesElement);
    }

    public void interactWithWindowsSubMenu() {
        elementHelper.clickElement(browserWindowsSubmenu);
    }


}
