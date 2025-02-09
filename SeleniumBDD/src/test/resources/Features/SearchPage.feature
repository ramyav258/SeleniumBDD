Feature: Search for the products

  Scenario: Search for products in HomePage and print lowest price
    Given User is in the Home page
    Then search for product    
    |computer|
    And change delivery to Norway
    And validate page title    
    |Amazon.com : computer|
    Then get the price of the first product


  Scenario: Sort from Low to High and print price of lowest
    Given User is in the Home page
    Then search for product
    | wool socks |
    And change delivery to Norway
    And sort products by High to Low
    Then get the price of the first product

