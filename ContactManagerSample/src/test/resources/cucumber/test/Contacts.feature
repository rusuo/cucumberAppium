Feature: add a new contact

@android
  Scenario: Add a new user on mobile native app
    Given I am on add user page
    Then I add a new contact

@web
  Scenario: Add a new user on web page
    Given I am on add user page
    Then I add a new contact

