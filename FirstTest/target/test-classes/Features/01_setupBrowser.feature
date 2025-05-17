@setup
Feature: Setup Browser

  # Scenario 1: Setting up browser and navigate to the URL
  Scenario: Open Chrome and navigate to the URL from the config file
    Given I open the Chrome browser
    When I navigate to the URL
    Then I should see the page title
