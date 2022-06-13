package stepDefinitions;

import Utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.http.Cookies;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AccountCreationPage;
public class AccountCreation_stepDef {
       AccountCreationPage accountCreationPage=new AccountCreationPage();


    @Given("Launch browser")
    public void launch_browser()
    {
        Driver.getDriver().manage().deleteAllCookies();
        Log.startTestCase("TESTCASE01 -");
    }
    @And("Navigate to webpage.")
    public void navigateToWebpage() {
        Driver.getDriver().get(ConfigReader.getProperty("proteinWorks_url"));
    }
    @And("Verify that home page {string} is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully(String homePage) {
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(homePage));
    }
    @And("Navigate to create an account page {string}")
    public void navigateToCreateAnAccountPage(String createCountPage) {
        Driver.getDriver().get(createCountPage);
        Assert.assertTrue("Create An Account page is not visible",accountCreationPage.createAccountPageTitle.isDisplayed());
    }
    @Given("Fill details: as {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} respectively.")
    public void fill_details_as_respectively(String firstName, String lastName, String email, String password, String confirmPassword, String gender, String dateOfBirth, String mobileNumber, String yourMainGoal) {
       Driver.waitAndSendText(accountCreationPage.firstname,firstName,5);
        Driver.waitAndSendText(accountCreationPage.lastname,lastName,5);
        Driver.waitAndSendText(accountCreationPage.email,email,5);
        Driver.waitAndSendText(accountCreationPage.password,password,5);
        Driver.waitAndSendText(accountCreationPage.password_confirmation,confirmPassword,5);

        Select select1=new Select(accountCreationPage.genderDropdown);
        select1.selectByVisibleText(gender);

        Driver.waitAndClick(accountCreationPage.dateOfBirthTextBox,5);
        //Select select2=new Select(accountCreationPage.monthDropdown);
        //select2.selectByVisibleText(dateOfBirth.substring(0,3));
        Driver.selectAnItemFromDropdown(accountCreationPage.monthDropdown,dateOfBirth.substring(0,3));
        Driver.selectAnItemFromDropdown(accountCreationPage.yearDropdown,dateOfBirth.substring(4,8));
        Driver.waitAndClick(accountCreationPage.selectDay,5);

        Driver.waitAndSendText(accountCreationPage.mobileNumber,mobileNumber,2);
        Driver.waitAndSendText(accountCreationPage.customer_goal,yourMainGoal,2);

    }
    @Given("Click COUNT ME IN button.")
    public void click_count_me_in_button() {
        accountCreationPage.notSubscribed.click();

    }
    @Given("Click JOIN UP button.")
    public void click_join_up_button()  {
        accountCreationPage.joinUpButton.click();

    }
    @Then("Verify that {string} page is visible")
    public void verifyThatPageIsVisible(String personalInfo) {
    }

    @Then("Close the application")
    public void closeTheApplication() {
        Log.endTestCase("TESTCASE01 -");
        //Driver.closeDriver();
    }



}
