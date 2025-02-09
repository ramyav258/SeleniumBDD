Feature: Add gift cards to cart

  Scenario Outline: Validate Login functionality
    Given User is in the Home page
    And change delivery to Norway
    Then Click on Gift Cards
    And select the card type and choose the card
    Then Enter the details <Rows>
    And click on add to cart
    Then Validate the confirmation message
		
    Examples: 
      | Rows |
      |    0 |
      |    1 |
