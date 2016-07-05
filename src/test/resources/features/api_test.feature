@api
Feature: Posts
  As a tester
  I want to test posts end point
  So that i can finish test end point

  Scenario Outline: Get request end point
    When I execute get request on "<URI>"
    Then I expect "<status code>"

    Examples: 
      | URI      | status code |
      | /posts   |         200 |
      | /postss  |         404 |
      | /posts/1 |         200 |
