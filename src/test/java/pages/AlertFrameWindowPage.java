package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage {

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsSubmenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesElement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsSubmenu;

    public void interactWithAlertsSubMenu() {
        elementHelper.clickElement(alertsSubmenu);
        LoggerUtility.infoLog("The user clicks on Alerts Sub Menu");
    }

    public void interactWithFramesSubMenu() {
        elementHelper.clickElement(framesElement);
        LoggerUtility.infoLog("The user clicks on Frames Sub Menu");
    }

    public void interactWithWindowsSubMenu() {
        elementHelper.clickElement(browserWindowsSubmenu);
        LoggerUtility.infoLog("The user clicks on Windows Sub Menu");
    }
}
