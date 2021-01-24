Feature: Exercise1 on Values

  @Test
  Scenario: Validation of values on https://www.exercise1.com/values Page
    Given I am on the page https://www.exercise1.com/values
    Then I validate that the number of values on the page are 5
    And I validate that the number of values on the page are greater than 0
    And I validate that the total balance of values on the page are correct
    And I validate that the values on the page are formatted
    And I validate the total balance matches the sum of values on the page
 
