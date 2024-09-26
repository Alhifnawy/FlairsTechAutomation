Feature: Admin User Management

  Background:
    Given User is on the OrangeHRM login page
  Scenario: Add and delete a user
    When User enters valid credentials
    And User clicks on the Admin tab
    And User records the current number of records
    And User adds a new user with details: employee name "John", username "abdurahman" and password "password123"
    Then The number of records should increase by one
    When User deletes the newly added user "abdurahman"
    Then The number of records should decrease by one

  Scenario: Add and delete a user
    When User enters valid credentials
    And User clicks on the Admin tab
    And User records the current number of records
    And User adds a new user with details: employee name "Sam", username "Hifnawy" and password "password123"
    Then The number of records should increase by one
    When User deletes the newly added user "Hifnawy"
    Then The number of records should decrease by one