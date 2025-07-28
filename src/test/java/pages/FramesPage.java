package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement firstBlockElement;

    @FindBy(id = "sampleHeading")
    private WebElement secondBlockElement;

    public void dealWithBigFrame() {
        frameHelper.switchFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        LoggerUtility.infoLog("The user switches to specific frame");
        elementHelper.printTextElement(firstBlockElement);
        frameHelper.switchToParent();
        LoggerUtility.infoLog("The user switches to parent frame");
    }

    public void dealWithLittleFrame() {
        frameHelper.switchFrameByString("frame2");
        elementHelper.printTextElement(secondBlockElement);
    }
}
