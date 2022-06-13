@TC_0101
Feature:Account creation
  Scenario Outline:User should create a new account.
    Given Launch browser
    And Navigate to create an account page "https://www.theproteinworks.com/customer/account/create/"
    And Verify that Create An Account page is visible.
    And Fill details: as "<FirstName>", "<LastName>", "<Email>", "<Password>", "<ConfirmPassword>", "<Gender>", "<DateOfBirth>", "<MobileNumber>", "<YourMainGoal>" respectively.
    And Click JOIN UP button.
    And Click COUNT ME IN button.
    Then Verify that Personal Info is visible
    Then Close the application

    Examples:Test Data
      |FirstName|LastName|Email|Password|ConfirmPassword|Gender|DateOfBirth|MobileNumber|YourMainGoal|
       |Test02|test02|test02@gmail.com|test.123456|test.123456|Male|Jan/1987/1|07536715151|Toning|
