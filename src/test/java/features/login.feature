Feature: Login
  As a user I should be able to log in to the app

  @new
  Scenario: Login with a valid credentials
  As a user I should be able to log in using valid username and password

    Given I am on the dm page
    When I click on the user icon
    And I click on the prijava button
    And I enter valid email "tester@yopmail.com"
    And I enter valid password "iTest123!"
    And I click on the prijavaDva button
    Then I should be logged in


