Feature: Ad Management

  Background: User authentication
    Given the user is authenticated

  Scenario: Create ad without photos
    Given the user wants to create a new ad
    When the user enters the data to create the ad
    Then the add is successfully create in the app
    And the post is deleted

  Scenario: Create ad with empty title
    Given the user wants to create a new ad
    When the user enters the data to create the ad with empty data
    Then the user is informed that the title can't be empty

  Scenario: Create ad with invalid phone number
    Given the user wants to create a new ad
    When the user enters the data to create the ad with invalid phone number
    Then the user is informed that the title can't be empty
