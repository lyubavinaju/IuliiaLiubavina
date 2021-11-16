Feature: User Table Page

  Scenario: Select vip test
    Given I open JDI GitHub site
    And I login as user "ROMAN IOVLEV"
    And I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan" on User Table Page
    Then 1 log row has "Vip: condition changed to true" text in log section on "User Table" Page
