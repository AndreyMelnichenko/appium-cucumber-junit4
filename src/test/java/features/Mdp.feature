Feature: Log-In Page

  @appium
  @login
  Scenario: Enter to App
    Given I am open app
    When  I watch logo
    Then I watch Hello message
    And I watch input server credentials field
    And I watch input field description
    And I watch ACTIVATE button

  @appium
  Scenario: Input empty credentials field
    Given I am open app
    When I watch input server credentials field
    Then I clear input field
    And I click to ACTIVATE button
    And Watch error message

  @appium
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

  @appium
  @firstscreen
  Scenario: Second Display Check
    Given I am open app
    When I fill credentials field with "mobox.ua"
    Then I click to ACTIVATE button
    And I am watch second screen