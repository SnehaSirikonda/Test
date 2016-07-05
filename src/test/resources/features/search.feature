@web
Feature: Test
  As a tester 
  I want to write few scenario 
  so that i can finish this task

  Scenario Outline: Search
    Given I am on wikipedia home page
    And I see title of page is "Wikipedia"
    When I search for a "<search term>"
    And I see suggestion as "Did you mean"
    And I click on suggestion
    Then I see first search result displayed 20 results
    And I click on any link
    And I see tables of contents

    Examples: 
      | search term   |
      | furry rabbits |
