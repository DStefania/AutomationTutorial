package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;

    public void interactWithAlertsFrameWindowMenu() {
        elementHelper.clickElement(alertsFrameWindowsMenu);
        LoggerUtility.infoLog("The user clicks on Alert Window Frame Menu");
    }

    public void interactWithFormsMenu() {
        elementHelper.clickElement(formsMenu);
    }

    public void interactWithElementsMenu() {
        elementHelper.clickElement(elementsMenu);
        LoggerUtility.infoLog("The user clicks on Forms Menu");
    }
}
