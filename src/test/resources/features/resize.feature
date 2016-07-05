@web
Feature: Resize

  Scenario: Resize the window
    Given I am on travelX site
    When I resize the window
    And I swipe the slider to left again left
    Then I see the third item is displayed
