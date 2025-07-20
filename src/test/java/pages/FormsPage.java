package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {
    public WebDriver driver;
    public ElementHelper elementHelper;
    public FrameHelper frameHelper;

    public FormsPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        frameHelper =new FrameHelper(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy( xpath ="//span[text()='Practice Form']" )
    public WebElement practiceForm;

    public void interactWithPracticeFormSubMenu (){
        elementHelper.clickElement(practiceForm);
    }
}
