Feature: Create Offer

  Scenario: Create Offer
    Given I have open the browser home page
    When  I open appcharge dashboard-sandbox login page
    And  I set valid credentials
    And  I click to login button
    Then Must navigate to home page with user
    When I click to pricing
    When I click to create new button in office pricing page
    When  I set value to usd price
    When  I click to save button
    Then Must open page with pricing lists