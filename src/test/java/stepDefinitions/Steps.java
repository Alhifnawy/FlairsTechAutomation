package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import orange.pages.AdminPage;
import orange.pages.LoginPage;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    int initialRecordCount, finalRecordCount;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^User is on the OrangeHRM login page$")
    public void userIsOnLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    @When("^User enters valid credentials$")
    public void userEntersValidCredentials() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }

    @And("^User clicks on the Admin tab$")
    public void userClicksOnAdminTab() {
        adminPage.clickAdminTab();
    }

    @And("^User records the current number of records$")
    public void userRecordsTheNumberOfRecords() {
        initialRecordCount = adminPage.getNumberOfRecords();
    }

    @And("^User adds a new user with details: employee name \"(.*)\", username \"(.*)\" and password \"(.*)\"$")
    public void userAddsANewUser(String empName, String usrName, String pass) throws InterruptedException {
        adminPage.clickAddButton();
        adminPage.fillUserForm(empName, usrName, pass);
        adminPage.clickSaveButton();
    }

    @Then("^The number of records should increase by one$")
    public void verifyRecordIncrease() {
        finalRecordCount = adminPage.getNumberOfRecords();
        Assert.assertEquals(finalRecordCount, initialRecordCount + 1);
    }

    @When("^User deletes the newly added user \"(.*)\"$")
    public void userDeletesNewUser(String username) {
        System.out.println("username:" + username);
        adminPage.clickDeleteButton(username);
        adminPage.confirmDelete();
    }

    @Then("^The number of records should decrease by one$")
    public void verifyRecordDecrease() {
        finalRecordCount = adminPage.getNumberOfRecords();
        Assert.assertEquals(finalRecordCount, initialRecordCount);
    }
}
