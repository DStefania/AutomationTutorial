package tests;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.clickElement(formsMenu);

        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.clickElement(practiceForm);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Elena";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameValue = "Zanfir";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        String emailValue = "Elena.zamfir@yahoo.com";
        emailElement.sendKeys(emailValue);

        WebElement mobileElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileValue = "0727123145";
        mobileElement.sendKeys(mobileValue);

//        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
//        String subjectsValue = "Accounting";
//        subjectsElement.sendKeys(subjectsValue);
//        subjectsElement.sendKeys(Keys.ENTER);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Accounting", "Maths", "Arts");
        for (int index = 0; index < subjectsValue.size(); index++) {
            subjectsElement.sendKeys(subjectsValue.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue) {
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other":
                genderElementList.get(2).click();
                break;
        }

       pageHelper.scrollPage(0,400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Sports", "Reading");
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbiesValues.contains(hobbiesElementList.get(index).getText())) {
                hobbiesElementList.get(index).click();
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/Beyond the Sky-16.jpg";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());
        String filename = file.getName();

        WebElement adressElement = driver.findElement(By.id("currentAddress"));
        String adressValue = "Int Mesteacanului 10P1";
        adressElement.sendKeys(adressValue);


        WebElement stateElement = driver.findElement(By.id("state"));
        elementHelper.clickJSElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        elementHelper.clickJSElement(cityElement);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Lucknow";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

        //wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstNameValue), "First Name text is not displayed right");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastNameValue), "Last Name text is not displayed right");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student Email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Emailul nu este corect");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender nu este corect");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile", "Mobile text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), mobileValue, "Mobile nu este corect");

        Assert.assertEquals(tableDescriptionList.get(5).getText(), "Subjects", "Subjects text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(5).getText(), String.join(", ", subjectsValue), "Subject nu este corect");

        Assert.assertEquals(tableDescriptionList.get(6).getText(), "Hobbies", "Hobbies text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(6).getText(), String.join(", ", hobbiesValues), "Hobbie-urile nu sunt corecte");

        Assert.assertEquals(tableDescriptionList.get(7).getText(), "Picture", "Picture text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(7).getText(), filename, "Picture name is not correct");
    }
}
// de terminat asserturile, de cautat pentru subject si hobbies ai o lista de stringuri si vrei sa fie transformata lista intr-un string delimitat cu virgula si spatiu cu assert equals

// PROIECT FINAL, creare de cont. loghim, produs in cos, scos, wishlist
//https://automationexercise.com/