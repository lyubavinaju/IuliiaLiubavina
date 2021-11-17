Feature: Different elements page

  Scenario: Select elements test
    Given I open JDI GitHub site
    When I login as user "ROMAN IOVLEV"
    And I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    And I select "Water" checkbox on Different elements page
    And I select "Wind" checkbox on Different elements page
    And I select "Selen" radio on Different elements page
    And I select "Yellow" in dropdown on Different elements page
    Then I should be logged in as user "ROMAN IOVLEV"
    And 'Different Elements' page should be opened
    And Checkbox "Water" should be selected on Different elements page
    And Checkbox "Wind" should be selected on Different elements page
    And Value  "Selen" should be selected in radio on Different elements page
    And Value "Yellow" should be selected in dropdown on Different elements page
    And 1 log row has "Water: condition changed to true" text in log section on "Different elements" Page
    And 1 log row has "Wind: condition changed to true" text in log section on "Different elements" Page
    And 1 log row has "metal: value changed to Selen" text in log section on "Different elements" Page
    And 1 log row has "Colors: value changed to Yellow" text in log section on "Different elements" Page
