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
        Driver.getDriver().get(ConfigReader.getProperty("proteinWorks_url"));
    }
    @And("Navigate to create an account page {string}")
    public void navigateToCreateAnAccountPage(String createCountPage) {
        Driver.getDriver().get(createCountPage);
         }
    @And("Verify that Create An Account page is visible.")
    public void verifyThatCreateAnAccountPageIsVisible() {
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
        Driver.waitAndClick( accountCreationPage.notSubscribed,2);
    }
    @Given("Click JOIN UP button.")
    public void click_join_up_button()  {
        Driver.waitAndClick( accountCreationPage.joinUpButton,2);
    }
    @Then("Verify that Personal Info is visible")
    public void verifyThatPersonalInfoIsVisible() {
        accountCreationPage.personalInfo.isDisplayed();
    }
    @Then("Close the application")
    public void closeTheApplication() {
        Log.endTestCase("TESTCASE01 -");
        Driver.closeDriver();
    }





}
