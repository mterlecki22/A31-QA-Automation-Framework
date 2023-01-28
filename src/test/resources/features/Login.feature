Feature:

  Scenario: Login Success
   Given I open browser
   And I open Login Page
   When I enter email "demo@class.com"
   And I enter password "te$t$tudent"
   And I submit
   Then I am logged in

  Scenario: Login incorrect password
    Given I open browser
    And I open Login Page
    When I enter email "demo@class.com"
    And I enter password "testpassword"
    And I submit
    Then I am presented with an error message

  Scenario: Login Not existing email
    Given I open browser
    And I open Login Page
    When I enter email "mitchel.terlecki@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    Then I am presented with an error message

  Scenario: Play a song
    Given I open browser
    And I open Login Page
    When I enter email "mitchel.terlecki@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    Then I am presented with an error message

