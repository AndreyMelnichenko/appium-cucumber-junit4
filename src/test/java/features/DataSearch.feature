Feature: Data Search Feature

  @debug
  Scenario: Insert Data to doc
    Given I entered into "mobox.ua" login "admin@mobox.ua" and password "12341234"
    And User go to "Data search"
    When I am in Data Search item
    And I am click on "Erdinger"
    And I am put into fielad "Firma" a search pattern "gmbh"
    Then I am watch search result by "Search results"
    And All found elements should contain "gmbh"
    And Click on random doc
    And Show associated docs
    And Click to doc to insert data
    And Check doc into draft