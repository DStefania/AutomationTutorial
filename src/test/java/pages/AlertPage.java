package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;

    public ElementHelper elementHelper;
    public AlertHelper alertHelper;
    public PageHelper pageHelper;

    public AlertPage (WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
        pageHelper = new PageHelper(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy ( id = "alertButton")
    public WebElement alertOkbuttonElement;
    @FindBy (id = "timerAlertButton")
    public WebElement alertWaitButtonElement;
    @FindBy (id= "confirmButton")
    public WebElement alertOkCancelElement;
    @FindBy (id= "promtButton")
    public WebElement alertPromptElement;

    public void dealAlertOk(){
       elementHelper.clickElement(alertOkbuttonElement);
       alertHelper.acceptAlert();
    }

    public void dealAlertTimer (){
        elementHelper.clickElement(alertWaitButtonElement);
        alertHelper.acceptAlert();
        pageHelper.scrollPage(0,400);
    }

    public void dealAlertCancel (){
        elementHelper.clickElement(alertOkCancelElement);
        alertHelper.dismissAlert();
    }

    public void dealAlertPrompt(String value){
        elementHelper.clickElement(alertPromptElement);
        alertHelper.fillAlert(value);
    }
}
