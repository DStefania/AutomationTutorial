package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTablesTest {
    public WebDriver driver;

    @Test
    public void testMethod() {
        //deschidem o instanta de Chrome
        driver = new ChromeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com");

        //facem browser-ul sa fie in modul maxiize
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement webTablesSubmenu =driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesSubmenu.click();

        //verificam cate elemente sunt in lista
        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(), tableSize, "Expected table size: "+tableSize + " is not corect" );

        //identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement = driver.findElement(By.id("firstName"));
        String firstnameValue = "Stef";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement = driver.findElement(By.id("lastName"));
        String lastnameValue = "Danila";
        lastnameElement.sendKeys((lastnameValue));

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "1224trs@gmal.com";
        emailElement.sendKeys((emailValue));

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "30";
        ageElement.sendKeys((ageValue));

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "3620";
        salaryElement.sendKeys((salaryValue));

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "IT";
        departmentElement.sendKeys((departmentValue));

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement submitElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);

        //verificare ca s-a adaugat un rand nou in lista
        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize + 1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));

        //edit functionality

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Stefuta";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "David";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "akjakahd@yahoo.com";
        editEmailElement.clear();
        editEmailElement.sendKeys(editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "65";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "6500";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "QA";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        WebElement submitEditElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitEditElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize + 1);
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editLastNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editAgeValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editSalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editDepartmentValue));


        //delete element

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

       // verificare valiare date tabel: a revenit la valoarea initiala
        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(), tableSize);

        driver.quit();
    }
}
