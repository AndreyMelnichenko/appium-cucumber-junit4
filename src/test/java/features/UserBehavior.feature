Feature: User Behavior

  @debug
  Scenario: Open Document
    Given I entered into "mobox.ua" login "admin@mobox.ua" and password "12341234"
    When I open "Testing" folder
    Then I open "Date and Time Fields and qrcode for testing and with Erdinger DataFields" document
    And Tap on some field