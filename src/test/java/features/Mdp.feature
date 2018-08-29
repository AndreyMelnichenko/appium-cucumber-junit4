Feature: Log-In Page

  @appium
  Scenario: Enter to App
    Given I am open app
    When  I watch logo
    Then I watch Hello message
    And I watch input server credentials field
    And I watch input field description
    And I watch ACTIVATE button