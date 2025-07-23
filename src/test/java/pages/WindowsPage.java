package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowElement;

    public void dealWIthNewTab() {
        elementHelper.clickElement(newTabElement);
        tabHelper.switchToSpecificTab(1);
        //inchidem tab-ul pe care te afli in momentul respectiv //driver.quite() - inchide tot browser-ul
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }

    public void dealWithNewWindow() {
//din cauza reclamei fortam site-ul sa acceseze un URL specific
// driver.navigate().to("https://demoqa.com/browser-windows");
        elementHelper.clickElement(newWindowElement);
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
