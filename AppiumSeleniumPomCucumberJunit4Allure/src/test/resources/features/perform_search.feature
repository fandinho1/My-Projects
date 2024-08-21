@tag
Feature: Perform some searchs in Chrome
  As an user I want to perform different searchs in chrome and navigate to the different results

  @tag1
  Scenario: Perform and specific search and see its results
    Given the user is in the Chrome search bar
		When he performs a search by typing "appium"
		Then he should see "Appium http://appium.io Appium" result
