package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSElement(WebElement element) {
        waitVisibleElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickElement(WebElement element) {
        waitVisibleElement(element);
        element.click();
    }

    public void validateListSize(List<WebElement> elementsList, int expectedSize) {
        Assert.assertEquals(elementsList.size(), expectedSize, "Actual elements list size " + elementsList.size() + " is different than: " + expectedSize);

    }

    public void validateElementContainsText(WebElement element, String expectectText) {
        Assert.assertTrue(element.getText().contains(expectectText), "Actual element text: " + element.getText() + " is different than" + expectectText);
    }

    public void clearElement(WebElement element) {
        waitVisibleElement(element);
        element.clear();
    }

    public void fillElement(WebElement element, String value) {
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys keyValue) {
        element.sendKeys(keyValue);
    }

    public void clearFillElement(WebElement element, String value) {
        clearElement(element);
        fillElement(element, value);
    }

    public void clearFillPressElement(WebElement element, String value, Keys keyValue) {
        clearElement(element);
        fillElement(element, value);
    }

    public void waitVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibleList(List<WebElement> elementsList) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
    }
}

