package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class AccountCreationPage {
    public AccountCreationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@data-ui-id='page-title-wrapper']")
    public WebElement createAccountPageTitle;
    @FindBy(name = "firstname")
    public WebElement firstname;
    @FindBy(name = "lastname")
    public WebElement lastname;
    @FindBy(name = "email")
    public WebElement email;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "password_confirmation")
    public WebElement password_confirmation;
    @FindBy(xpath = "//*[@id='gender']")
    public WebElement genderDropdown;
    @FindBy(xpath = "//*[@id='dob']")
    public WebElement dateOfBirthTextBox;

    @FindBy(xpath = "//*[@class='ui-datepicker-year']")
    public WebElement yearDropdown;

    @FindBy(xpath = "//*[@class='ui-datepicker-month']")
    public WebElement monthDropdown;
    @FindBy(xpath = "(//tr/td/a)[10]")
    public  WebElement selectDay;

    @FindBy(xpath= "//*[@title='Mobile Number']")
    public WebElement mobileNumber;
    @FindBy(name = "customer_goal")
    public WebElement customer_goal;
    @FindBy(xpath = "//*[@id='is_subscribed_yes']")
    public WebElement isSubscribed;
    @FindBy(xpath = "//*[@id='is_subscribed_no']")
    public WebElement notSubscribed;
    @FindBy(xpath = "//div[@class='primary']")
    public WebElement joinUpButton;













}
