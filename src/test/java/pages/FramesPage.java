package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {
    public WebDriver driver;
    public ElementHelper elementHelper;
    public FrameHelper frameHelper;

    public FramesPage (WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        frameHelper =new FrameHelper(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy( id ="sampleHeading" )
    public WebElement firstBlockElement;

    @FindBy ( id = "sampleHeading")
    public  WebElement secondBlockElement;

    public void dealWithBigFrame (){
        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        elementHelper.printTextElement(firstBlockElement);
        frameHelper.switchToParent();
    }

    public void dealWithLittleFrame (){
        frameHelper.switchFrameByString("frame2");
        elementHelper.printTextElement(secondBlockElement);
    }

}
