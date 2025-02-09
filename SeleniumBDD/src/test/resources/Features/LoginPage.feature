Feature: Login and validate the error messages

  
  Scenario Outline: Validate Login functionality
  Given User is in the Home page
  And validate the home page title <Title>
  And change delivery to Norway
  Then click on sign in button
  And enter email address <Email>
  Then click on continue button
  And enter password <Password>
  When user is signed in
  And change delivery to Norway
  Then click on sign out button
  
  Examples:
  | Title                               | Email                        | Password     |
  | Amazon.com. Spend less. Smile more. | seleniumtestingbdd@gmail.com | selenium123  |
  | Amazon.com. Spend less. Smile more. | newseleniumid@gmail.com      | seleniumuser |
  
  Scenario Outline: Validate wrong email error message
  Given User is in the Home page
  Then click on sign in button
  And enter email address <email>
  Then click on continue button
  Then Validate error message on entering wrong email
  
  Examples:
  | email    |
  | selenium |
  Scenario Outline: Validate wrong password error message
    Given User is in the Home page
    Then click on sign in button
    And enter email address <email>
    Then click on continue button
    And enter password <password>
    When user is signed in
    Then validate error page

    Examples: 
      | email                        | password | 
      | seleniumtestingbdd@gmail.com | password | 
