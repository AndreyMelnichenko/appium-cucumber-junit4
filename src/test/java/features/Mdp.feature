Feature: Log-In Page

  @all
  @login
  Scenario: Enter to App
    Given I am open app
    When  I watch logo
    Then I watch Hello message
    And I watch input server credentials field
    And I watch input field description
    And I watch ACTIVATE button

  @all
  Scenario: Input empty credentials field
    Given I am open app
    When I watch input server credentials field
    Then I clear input field
    And I click to ACTIVATE button
    And Watch error message

  @all
  Scenario Outline: Validate credentials field
    Given I am open app
    When I watch input server credentials field
    Then I clear input field
    And I try enter with "<credentials>"
    And I click to ACTIVATE button
    And I watch error pop-up

  Examples:
  | credentials |
  | 42452645264 |
  | wrwwerwrwrw |
  | !@##$%$##$% |

  @all
  @firstscreen
  Scenario: Second Display Check
    Given I am open app
    When I fill credentials field with "mobox.ua"
    Then I click to ACTIVATE button
    And I watch logo

  @all
  Scenario: Enter with empty LOGIN and PASSWORD
    Given I am open app
    When I fill credentials field with "mobox.ua"
    And I click to ACTIVATE button
    Then I should watch second screen
    And CheckBox click
    And Try to enter with empty fields
    And Watch error message as "user cannot be empty"

  @all
  @secondScreen
  Scenario: Enter with empty PASSWORD
    Given I am open app
    When I go to second screen with "mobox.ua"
    And CheckBox click
    And I fill login "user"
    And I clear password field
    Then I click to LOGIN button
    And Watch error message as "Password cannot be empty"

    @debug
    Scenario: Cogwheel test
      Given I go to second screen with "mobox.ua"
      When I watch second screen
      Then I watch cogwheel and click on it
      And I may check text on pop-up
      And I may erase access to server
      And I watch logo

    Scenario: Cancel to erase access