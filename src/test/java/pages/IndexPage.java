package pages;

import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    public WebDriver driver;

    public ElementHelper  elementHelper;

    public IndexPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver,this);
    }

  @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
  public WebElement alertsFrameWindowsMenu;

    public void interactWithAlertsFrameWindowMenu(){
        elementHelper.clickElement(alertsFrameWindowsMenu);
    }

}
