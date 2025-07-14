package pages;

import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowPage {
    public WebDriver driver;

    public ElementHelper elementHelper;

    public AlertFrameWindowPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//span[text()='Alerts']")
    public WebElement alertsSubmenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesElement;

    public void interactWithAlertsSubMenu(){
        elementHelper.clickElement(alertsSubmenu);
    }

    public void interactWithFramesSubMenu(){
        elementHelper.clickElement(framesElement);
    }


}
