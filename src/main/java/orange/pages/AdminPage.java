package orange.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    String UserElement = "//*[contains(text(),'TEXT_REPLACE')]/parent::*/following-sibling::*//*[@class=\"oxd-icon bi-trash\"]";

    // Locators
    By adminTab = By.linkText("Admin");
    By userRecordsCount = By.xpath("//*[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/span");  //

    // Adjust the locator according to the actual element
    By addButton = By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    By saveButton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    By deleteUserButton;
    By confirmDelete = By.xpath("//*[contains(@class, 'label-danger')]");

    // Locators for Add User Form (replace with actual locators)
    By userRole = By.xpath("//*[contains(text(),'User Role')]/parent::*/following-sibling::*//*[@class=\"oxd-select-wrapper\"]");
    By userRoleAdmin = By.xpath("//*[contains(text(),'Admin')]");
    By employeeName = By.xpath("//*[@placeholder=\"Type for hints...\"]");
    By employeeNameSelect = By.xpath("//*[@class=\"oxd-autocomplete-dropdown --positon-bottom\"]");
    By username = By.xpath("//*[contains(text(),'Username')]/parent::*/following-sibling::*/input");
    By status = By.xpath("//*[contains(text(),'Status')]/parent::*/following-sibling::*//*[@class=\"oxd-select-wrapper\"]");
    By statusEnabled = By.xpath("//*[contains(text(),'Enabled')]");
    By password = By.xpath("//*[contains(text(),'Password')]/parent::*/following-sibling::*/input");
    By confirmPassword = By.xpath("//*[contains(text(),'Confirm Password')]/parent::*/following-sibling::*/input");

    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickAdminTab() {
        driver.findElement(adminTab).click();
    }

    public int getNumberOfRecords() {
        String info = driver.findElement(userRecordsCount).getText();
        int number = Integer.parseInt(StringUtils.substringBetween(info, "(", ")"));
        System.out.println(number);
        return Integer.parseInt(StringUtils.substringBetween(info, "(", ")"));  // Extracting the number from the displayed text
//        return Integer.parseInt(info.split(" ")[5]);  // Extracting the number from the displayed text
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void fillUserForm(String empName, String usrName, String pass) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(userRole).click();
        driver.findElement(userRoleAdmin).click();
        driver.findElement(employeeName).sendKeys(empName);
        Thread.sleep(4000);
        driver.findElement(employeeNameSelect).click();
        driver.findElement(status).click();
        driver.findElement(statusEnabled).click();
        driver.findElement(username).sendKeys(usrName);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void clickDeleteButton(String name) {

        System.out.println("name:" + name);
        UserElement = UserElement.replace("TEXT_REPLACE",name);
        System.out.println("UserElement:" + UserElement);
        deleteUserButton = By.xpath(UserElement);
        System.out.println(deleteUserButton);
        driver.findElement(deleteUserButton).click();
    }

    public void confirmDelete(){
        driver.findElement(confirmDelete).click();
    }
}
