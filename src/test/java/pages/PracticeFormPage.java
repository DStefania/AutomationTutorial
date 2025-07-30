package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameElement;

    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameElement;

    @FindBy(css = "input[placeholder='name@example.com']")
    private WebElement emailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileElement;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;

    @FindBy(css = "div[id='genterWrapper']>div>div>label[class='custom-control-label']")
    private List<WebElement> genderElementList;

    @FindBy(css = "div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']")
    private List<WebElement> hobbiesElementList;

    @FindBy(id = "uploadPicture")
    private WebElement uploadElement;

    @FindBy(id = "currentAddress")
    private WebElement addressElement;

    @FindBy(id = "state")
    private WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;

    @FindBy(id = "city")
    private WebElement cityElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;

    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(xpath = "//table//td[1]")
    private List<WebElement> tableDescriptionList;

    @FindBy(xpath = "//table//td[2]")
    private List<WebElement> tableValueList;

    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue, String mobileValue, List<String> subjectsValue,
                               String genderValue, List<String> hobbiesValues, String uploadValue, String addressValue, String stateValue, String cityValue) {
        elementHelper.fillElement(firstNameElement, firstNameValue);
        LoggerUtility.infoLog("The user fills first name field with value: " + firstNameValue);
        elementHelper.fillElement(lastNameElement, lastNameValue);
        LoggerUtility.infoLog("The user fills last name field with value: " + lastNameValue);
        elementHelper.fillElement(emailElement, emailValue);
        LoggerUtility.infoLog("The user fills email field with value: " + emailValue);
        elementHelper.fillElement(mobileElement, mobileValue);
        LoggerUtility.infoLog("The user fills mobile field with value: " + mobileValue);
        for (int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
            LoggerUtility.infoLog("The user fills the subjects field with value: " + subjectsValue.get(index));
        }
        switch (genderValue) {
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
        }
        LoggerUtility.infoLog("The user checks gender field the value: " + genderValue);

        pageHelper.scrollPage(0, 400);
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbiesValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
                LoggerUtility.infoLog("The user fills hobbies field with value: " + hobbiesElementList.get(index).getText());
            }
        }
        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user uploads the file: " + file.getAbsolutePath());
        elementHelper.fillElement(addressElement, addressValue);
        LoggerUtility.infoLog("The user fills the address field value: " + addressValue);
        elementHelper.clickJSElement(stateElement);
        elementHelper.fillPressElement(stateInputElement, stateValue, Keys.ENTER);
        LoggerUtility.infoLog("The user fills the state field value: " + stateValue);
        elementHelper.clickJSElement(cityElement);
        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);
        LoggerUtility.infoLog("The user fills the city field value: " + cityValue);
        elementHelper.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clicks the Sumit button ");
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue,
                                   String genderValue, String mobileValue, List<String> subjectsValue,
                                   List<String> hobbiesValues, String filename, String addressValue,
                                   String stateValue, String cityValue) {
        elementHelper.validateElementEqualsText(tableDescriptionList.get(0), "Student Name");
        LoggerUtility.infoLog("The user validate the presence of value Student Name ");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        LoggerUtility.infoLog("The user validate the presence of value: " + firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);
        LoggerUtility.infoLog("The user validate the presence of value: " + lastNameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        LoggerUtility.infoLog("The user validate the presence of value Student Email ");
        elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);
        LoggerUtility.infoLog("The user validate the presence of value: " + emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        LoggerUtility.infoLog("The user validate the presence of value Gender ");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);
        LoggerUtility.infoLog("The user validate the presence of value: " + genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        LoggerUtility.infoLog("The user validate the presence of value Mobile ");

        elementHelper.validateElementEqualsText(tableValueList.get(3), mobileValue);
        LoggerUtility.infoLog("The user validate the presence of value: " + mobileValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
        LoggerUtility.infoLog("The user validate the presence of value Subjects ");
        elementHelper.validateElementEqualsText(tableValueList.get(5), String.join(", ", subjectsValue));
        LoggerUtility.infoLog("The user validate the presence of value: " + subjectsValue);


        elementHelper.validateElementEqualsText(tableDescriptionList.get(6), "Hobbies");
        LoggerUtility.infoLog("The user validate the presence of value Hobbies ");
        elementHelper.validateElementEqualsText(tableValueList.get(6), String.join(", ", hobbiesValues));
        LoggerUtility.infoLog("The user validate the presence of value: " + hobbiesValues);


        File file = new File(filename);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        LoggerUtility.infoLog("The user validate the presence of value Picture ");
        elementHelper.validateElementEqualsText(tableValueList.get(7), file.getName());
        LoggerUtility.infoLog("The user validate the presence of value: " + filename);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        LoggerUtility.infoLog("The user validate the presence of value Address ");
        elementHelper.validateElementEqualsText(tableValueList.get(8), addressValue);
        LoggerUtility.infoLog("The user validate the presence of value: " + addressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        LoggerUtility.infoLog("The user validate the presence of value State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        LoggerUtility.infoLog("The user validate the presence of value state: " + stateValue);

        elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
        LoggerUtility.infoLog("The user validate the presence of value city: " + cityValue);
    }
}
