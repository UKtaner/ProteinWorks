package stepDefinitions;

import Utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.http.Cookies;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountCreationPage;
public class AccountCreation_stepDef {
       AccountCreationPage accountCreationPage=new AccountCreationPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
    @And("Navigate to create an account page {string}")
    public void navigateToCreateAnAccountPage(String createCountPage) {
        Log.startTestCase("TESTCASE -");
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().get(createCountPage);
         }
    @And("Verify that Create An Account page is visible.")
    public void verifyThatCreateAnAccountPageIsVisible() {
        Assert.assertTrue("Create An Account page is not visible",accountCreationPage.createAccountPageTitle.isDisplayed());
    }
    @Given("Fill details: as {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} respectively.")
    public void fill_details_as_respectively(String firstName, String lastName, String email, String password, String confirmPassword, String gender, String dateOfBirth, String mobileNumber, String yourMainGoal) throws InterruptedException {
       Driver.waitAndSendText(accountCreationPage.firstname,firstName,5);
        Driver.waitAndSendText(accountCreationPage.lastname,lastName,5);
        Driver.waitAndSendText(accountCreationPage.email,email,5);
        Driver.waitAndSendText(accountCreationPage.password,password,5);
                try {
            ReusableMethods.waitFor(5);
            JSUtils.clickElementByJS(accountCreationPage.acceptCookie);
            ReusableMethods.waitFor(5);
            JSUtils.clickElementByJS(accountCreationPage.offerPopUp);

        }
        catch(Exception e){
        System.out.println("POPUP CLEARED");
        }

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
        Driver.selectAnItemFromDropdown(accountCreationPage.customer_goal,"Toning");
        Driver.waitAndSendText(accountCreationPage.referralCode,"Optional",5);
        JSUtils.scrollDownByJS();

    }
    @Given("Click COUNT ME IN button.")
    public void click_count_me_in_button() {
        wait.until(ExpectedConditions.visibilityOf(accountCreationPage.isSubscribed));
        JSUtils.clickElementByJS(accountCreationPage.countMeIn);
        //Driver.waitAndClick( accountCreationPage.notSubscribed,2);

    }
    @Given("Click JOIN UP button.")
    public void click_join_up_button() {
        wait.until(ExpectedConditions.visibilityOf(accountCreationPage.joinUpButton));
        accountCreationPage.joinUpButton.click();

    }
    @Then("Verify that Personal Info is visible")
    public void verifyThatPersonalInfoIsVisible() {
//        wait.until(ExpectedConditions.visibilityOf(accountCreationPage.personalInfo));
//        accountCreationPage.personalInfo.click();
    }
    @Then("Close the application")
    public void closeTheApplication() {Log.endTestCase("TESTCASE -");
       //Driver.closeDriver();
    }





}
