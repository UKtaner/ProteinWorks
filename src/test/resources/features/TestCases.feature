
Feature:Account creation
  @PositiveTest
  @TC_0101
  Scenario Outline:User should create a new account.
    Given Navigate to create an account page "https://eager-musk.theproteinworks.com/customer/account/create/"
    And Verify that Create An Account page is visible.
    And Fill details: as "<FirstName>", "<LastName>", "<Email>", "<Password>", "<ConfirmPassword>", "<Gender>", "<DateOfBirth>", "<MobileNumber>", "<YourMainGoal>" respectively.
    And Click JOIN UP button.
    And Click COUNT ME IN button.
    Then Verify that Personal Info is visible
    Then Close the application

    Examples:Test Data
      | FirstName | LastName | Email            | Password     | ConfirmPassword | Gender | DateOfBirth | MobileNumber | YourMainGoal |
      | Test02    | test02   | test02@gmail.com | test.123456  | test.123456     | Male   | Jan/1987/1  | 07536715151  | Toning       |
  @NegativeTest
  @TC_0102
  Scenario Outline:User provides invalid Date of Birth for a new account creation and should get invalid entry message.
    Given Navigate to create an account page "https://eager-musk.theproteinworks.com/customer/account/create/"
    And Verify that Create An Account page is visible.
    And Fill details: as "<FirstName>", "<LastName>", "<Email>", "<Password>", "<ConfirmPassword>", "<Gender>", "<DateOfBirth>", "<MobileNumber>", "<YourMainGoal>" respectively.
    And Click JOIN UP button.
    And Click COUNT ME IN button.
    Then Verify that Personal Info is visible
    Then Close the application

    Examples:Test Data
      | FirstName | LastName | Email            | Password     | ConfirmPassword | Gender | DateOfBirth | MobileNumber | YourMainGoal |
      | Test03    | test03   | test03@gmail.com | test.123456  | test.123456     | Male   | Jun/2022/10 | 07536715151  | Toning       |
  @NegativeTest
  @TC_0103
  Scenario Outline:User provides invalid First Name for a new account creation and should get invalid entry message.
    Given Navigate to create an account page "https://eager-musk.theproteinworks.com/customer/account/create/"
    And Verify that Create An Account page is visible.
    And Fill details: as "<FirstName>", "<LastName>", "<Email>", "<Password>", "<ConfirmPassword>", "<Gender>", "<DateOfBirth>", "<MobileNumber>", "<YourMainGoal>" respectively.
    And Click JOIN UP button.
    And Click COUNT ME IN button.
    Then Verify that Personal Info is visible
    Then Close the application

    Examples:Test Data
      | FirstName | LastName | Email            | Password     | ConfirmPassword | Gender | DateOfBirth | MobileNumber | YourMainGoal |
      | 000000    | test03   | test03@gmail.com | test.123456  | test.123456     | Male   | Jun/2022/10 | 07536715151  | Toning       |

  @NegativeTest
  @TC_0104
  Scenario Outline:User provides invalid Last Name for a new account creation and should get invalid entry message.
    Given Navigate to create an account page "https://eager-musk.theproteinworks.com/customer/account/create/"
    And Verify that Create An Account page is visible.
    And Fill details: as "<FirstName>", "<LastName>", "<Email>", "<Password>", "<ConfirmPassword>", "<Gender>", "<DateOfBirth>", "<MobileNumber>", "<YourMainGoal>" respectively.
    And Click JOIN UP button.
    And Click COUNT ME IN button.
    Then Verify that Personal Info is visible
    Then Close the application

    Examples:Test Data
      | FirstName | LastName | Email            | Password     | ConfirmPassword | Gender | DateOfBirth | MobileNumber | YourMainGoal |
      | Test05    | ........ | test05@gmail.com | test.1234567 | test.1234567    | Male   | Mar/1988/6  | 07536715152  | Toning       |
  @NegativeTest
  @TC_0105
  Scenario Outline:User provides invalid Mobile Number for a new account creation and should get invalid entry message.
    Given Navigate to create an account page "https://eager-musk.theproteinworks.com/customer/account/create/"
    And Verify that Create An Account page is visible.
    And Fill details: as "<FirstName>", "<LastName>", "<Email>", "<Password>", "<ConfirmPassword>", "<Gender>", "<DateOfBirth>", "<MobileNumber>", "<YourMainGoal>" respectively.
    And Click JOIN UP button.
    And Click COUNT ME IN button.
    Then Verify that Personal Info is visible
    Then Close the application

    Examples:Test Data
      | FirstName | LastName | Email            | Password     | ConfirmPassword | Gender | DateOfBirth | MobileNumber | YourMainGoal |
      | Test06    | test06   | test06@gmail.com | test.1234567 | test.1234567    | Male   | Mar/1988/6  | A7534715151  | Toning       |
