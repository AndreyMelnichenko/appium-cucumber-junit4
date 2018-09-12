Feature: Draft management

  @debug
  Scenario: Upload saved document
    Given I entered into "mobox.ua" login "admin@mobox.ua" and password "12341234"
    And I open "Testing" folder
    And I open "Date and Time Fields and qrcode for testing and with Erdinger DataFields" document
    And Tap on some field and send keys with "Test"
    And Tap Done button
    And Save and Back to docs list
    And I back to main screen
    When User go to "drafts"
    And Click on Delete button
    Then Stop test