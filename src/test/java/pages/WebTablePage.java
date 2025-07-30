package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstnameElement;
    @FindBy(id = "lastName")
    private WebElement lastnameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    private WebElement editEmailElement;
    @FindBy(id = "age")
    private WebElement editAgeElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void addNewEntry(int tableSize, String firstnameValue, String lastnameValue, String emailValue, String ageValue,
                            String salaryValue, String departmentValue) {
        elementHelper.validateListSize(tableList, tableSize);
        LoggerUtility.infoLog("The user validates that the table has " +tableSize +" rows");
        clickAddButton();
        fillFirstName(firstnameValue);
        fillLastName(lastnameValue);
        fillEmailAddress(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();

        int expectedTableSize = tableSize +1;
        elementHelper.validateListSize(tableList, expectedTableSize);
        LoggerUtility.infoLog("The user validates that the table contains " + expectedTableSize + " rows");
        elementHelper.validateElementContainsText(tableList.get(tableSize), firstnameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + firstnameValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), lastnameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + lastnameValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), emailValue);
        LoggerUtility.infoLog("The user validates that the table contains " + emailValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), ageValue);
        LoggerUtility.infoLog("The user validates that the table contains " + ageValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), salaryValue);
        LoggerUtility.infoLog("The user validates that the table contains " + salaryValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), departmentValue);
        LoggerUtility.infoLog("The user validates that the table contains " + departmentValue +" value");
    }

    public void editNewEntry(int tableSize, String editFirstnameValue, String editLastnameValue, String editEmailValue, String editAgeValue,
                             String editSalaryValue, String editDepartmentValue) {

        clickEditButton();
        fillEditFirstName(editFirstnameValue);
        fillEditLastName(editLastnameValue);
        fillEditEmailAddress(editEmailValue);
        fillEditAge(editAgeValue);
        fillEditSalary(editSalaryValue);
        fillEditDepartment(editDepartmentValue);
        clickSubmit();

        int expectedTableSize=tableSize + 1;

        elementHelper.validateListSize(tableList, expectedTableSize);
        LoggerUtility.infoLog("The user validates that the table has "+ expectedTableSize +" rows");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstnameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editFirstnameValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastnameValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editLastnameValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editEmailValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editAgeValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editSalaryValue +" value");
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);
        LoggerUtility.infoLog("The user validates that the table contains " + editSalaryValue +" value");

    }

    public void deleteNewEntry(int tableSize) {
        clickDeleteButton();
        LoggerUtility.infoLog("The user clicks on delete button");
    }

    public void clickAddButton() {
        elementHelper.clickElement(addElement);
        LoggerUtility.infoLog("The user clicks on add button");
    }

    public void fillFirstName(String firstnameValue) {
        elementHelper.fillElement(firstnameElement, firstnameValue);
        LoggerUtility.infoLog("The user fills first name field with value" + firstnameValue );
    }

    public void fillLastName(String lastnameValue) {
        elementHelper.fillElement(lastnameElement, lastnameValue);
        LoggerUtility.infoLog("The user fills last name field with value " + lastnameValue );
    }

    public void fillEmailAddress(String emailValue) {
        elementHelper.fillElement(emailElement, emailValue);
        LoggerUtility.infoLog("The user fills email field with value " + emailValue );
    }

    public void fillAge(String ageValue) {
        elementHelper.fillElement(ageElement, ageValue);
        LoggerUtility.infoLog("The user fills age field with value " + ageValue );
    }

    public void fillSalary(String salaryValue) {
        elementHelper.fillElement(salaryElement, salaryValue);
        LoggerUtility.infoLog("The user fills salary field with value " + salaryValue );
    }

    public void fillDepartment(String departmentValue) {
        elementHelper.fillElement(departmentElement, departmentValue);
        LoggerUtility.infoLog("The user fills department field with value " + departmentValue );
    }

    public void clickSubmit() {
        elementHelper.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clicks on submit button" );
    }

    public void clickEditButton() {

        elementHelper.clickJSElement(editElement);
        LoggerUtility.infoLog("The user clicks on Edit button" );
    }

    public void fillEditFirstName(String firstnameValue) {
        elementHelper.clearFillElement(editFirstNameElement, firstnameValue);
        LoggerUtility.infoLog("The user edit firs name field with value " + firstnameValue );
    }

    public void fillEditLastName(String lastnameValue) {
        elementHelper.clearFillElement(editLastNameElement, lastnameValue);
        LoggerUtility.infoLog("The user edit last name field with value " + lastnameValue );
    }

    public void fillEditEmailAddress(String emailValue) {
        elementHelper.clearFillElement(editEmailElement, emailValue);
        LoggerUtility.infoLog("The user edit email field with value " + emailValue );
    }

    public void fillEditAge(String ageValue) {
        elementHelper.clearFillElement(editAgeElement, ageValue);
        LoggerUtility.infoLog("The user edit age field with value " + ageValue );
    }

    public void fillEditSalary(String salaryValue) {
        elementHelper.clearFillElement(editSalaryElement, salaryValue);
        LoggerUtility.infoLog("The user edit salary field with value " + salaryValue );
    }

    public void fillEditDepartment(String departmentValue) {
        elementHelper.clearFillElement(editDepartmentElement, departmentValue);
        LoggerUtility.infoLog("The user edit department field with value " + departmentValue );
    }

    public void clickDeleteButton() {
        elementHelper.clickJSElement(deleteElement);
        LoggerUtility.infoLog("The user clicks the delete button " );
    }
}
