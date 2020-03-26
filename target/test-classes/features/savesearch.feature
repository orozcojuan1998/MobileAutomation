Feature: Save Search


  Scenario: Test saved search with daily notification
    Given the user is authenticated
    When the user enters the the data
      | query  | frequency |
      | Lenovo | Daily     |
    And the user save the search with daily notifications
    Then the search and notifications are saved
    And the saved search is deleted

  Scenario: Test saved search with weekly notification
    Given the user is authenticated
    When the user enters the the data
      | query | frequency |
      | Dell  | Weekly    |
    And the user save the search with weekly notifications
    Then the search and notifications are saved
    And the saved search is deleted

  Scenario: Test saved search while not logged in
    Given the guest is in the app home screen
    When the guest enters the the data
      | query | frequency |
      | Dell  | Daily     |
    And the guest save the search with daily notifications
    Then the user is redirected to login page










