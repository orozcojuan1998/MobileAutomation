Feature: Sign in


  Scenario: Test successful login
    Given the user is in the app home screen
    When the user tries to login with valid data
    Then the user is logged in


  Scenario: Test login invalid email
    Given the user is in the app home screen
    When the user tries to login with invalid email
    Then the user is informed that his credentials are wrong


  Scenario: Test login invalid password
    Given the user is in the app home screen
    When the user tries to login with invalid password
    Then the user is informed that his credentials are wrong

  Scenario: Test successful logout
    Given the user is in the app home screen
    And the user tries to login with valid data
    And the user is logged in
    When the user tries to logout from the app
    Then the user is logged out of the app
