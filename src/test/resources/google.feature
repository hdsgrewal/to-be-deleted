Feature: Test google landing page

  Scenario: Test the title of the page
    When I am on the landing page
    Then The title is "Google"

  Scenario: Test the URL
    When I am on the landing page
    Then The URL is "https://www.google.com/"

  Scenario: Test the language change to french
    When I am on the landing page
    And I change the language to french
    Then The language of page should be "fr-CA"

  Scenario: Test the gmail link
    When I am on the landing page
    And I click on the gmail link
    Then The gmail page should open

  Scenario: Test to check the drop down list containing the google applications opens
    When I am on the landing page
    And I click on the google apps link
    And when I click on the google account link from the drop down
    Then The title of the page should be "Google Account"

  Scenario: Test the google search functionality
    When I am on the landing page
    And Type Canada in the search
    Then I can see a list of suggestions
