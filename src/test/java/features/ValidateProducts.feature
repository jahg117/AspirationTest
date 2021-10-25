@test
Feature: Search Products

  Scenario: Validate 2 products are displayed
    Given I navigate to aspiration site
    When I click on spend and save option
    Then I validate the correct aspiration products are displayed
    And I click on GetStarted
    And I validate the input email address is displayed
