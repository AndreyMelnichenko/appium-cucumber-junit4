Feature: Actions with docs

  @all
  Scenario: Change document and Save
    Given I entered into "mobox.ua" login "admin@mobox.ua" and password "12341234"
    When I open "Testing" folder
    And I open "Date and Time Fields and qrcode for testing and with Erdinger DataFields" document
    And Tap on some field and send keys with "Test"
    And Tap Done button
    And Save and Back to docs list
    Then I back to main screen
    And User go to "drafts"
    And Check entered text

  @all
  Scenario: Send document to server
    Given I entered into "mobox.ua" login "admin@mobox.ua" and password "12341234"
    When I open "Testing" folder
    And I open "Date and Time Fields and qrcode for testing and with Erdinger DataFields" document
    And Tap on some field and send keys with "Test"
    And Tap Done button
    And Upload and Back to docs list
    Then I back to main screen
    And User go to "Posted"
    And Check Posted document

  @all
  Scenario: Cancel send document to server
    Given I entered into "mobox.ua" login "admin@mobox.ua" and password "12341234"
    When I open "Testing" folder
    And I open "Date and Time Fields and qrcode for testing and with Erdinger DataFields" document
    And Tap on some field and send keys with "Test"
    And Tap Done button
    And Discard changes and Back to docs list
    Then I back to main screen
    And User go to "drafts"
    And Check clear doc

  @debug
  Scenario: Open Doc -> Insert info -> Save -> Draft check
    Given I entered into "mobox.ua" login "admin@mobox.ua" and password "12341234"
    When I open "Testing" folder
    And I open "Date and Time Fields and qrcode for testing and with Erdinger DataFields" document
    And Tap on some field and send keys with "Test"
    And Tap Done button
    And Click on Search icon
    And I am click on "Erdinger"
    And I am put into fielad "Firma" a search pattern "gmbh"
    Then I am watch search result by "Search results"
    And All found elements should contain "gmbh"
    And Click on random doc
    And Save and Back to docs list
    And I back to main screen
    And User go to "drafts"
    And Check contained text
