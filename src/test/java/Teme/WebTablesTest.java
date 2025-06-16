package Teme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTablesTest {
    public WebDriver driver;

    @Test
    public void testMethod(){
        //dechidem o instanta de Chrome
        driver =new ChromeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com/webtables");

        //maximizez pagina
        driver.manage().window().maximize();

        // identificam un element
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="Stefania";
      firstNameElement.sendKeys(firstnameValue);

        WebElement lastnameElement= driver.findElement(By.id("lastName"));
        String lastnameValue="Danila";
       lastnameElement.sendKeys(lastnameValue);
    }
}
