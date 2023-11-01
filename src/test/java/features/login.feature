Feature: Bookcart apllication Test.

# Background is used when you have duplicate staps in multiple scenario.
#  Background:
#    And User clicks on login button.

  Scenario: Check login is successful with valid credentials.

#    Given User navigate to bookcart apllication.
    And User clicks on login button.
    And User enters the username as "Abcxyz123".
    And user enters the password "AbcXyz123".
    When click login button.
    Then Login should be success.

@smoke
  Scenario: Check login is successful with invalid credentials.

#    Given User navigate to bookcart apllication.
    And User clicks on login button.
    And User enters the username as "Abcxyz1234".
    And user enters the password "AbcXyz1234".
    When click login button.
    But Login should be fail.