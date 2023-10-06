Feature: User
  As an admin
  I want to see list of user
  So that I can create new user

  Scenario: Get - As an admin, I should be able to get a list of users
    Given I set the GET endpoint for user list
    When I send a GET HTTP request
    Then I receive a valid HTTP response code 200

  Scenario: Get - As an admin, I should be able to handle empty user list
    Given I set the GET endpoint for an empty user list
    When I send a GET HTTP request
    Then I receive a valid HTTP response code 200
    And the response body should be empty

  Scenario: POST - As an admin, I should be able to create a new user with valid data
    Given I set the POST endpoint for creating users
    And I have valid user data
    When I send a POST HTTP request with valid data
    Then I receive a valid HTTP response code 201
    And the response body should contain the newly created user details

  Scenario: POST - As an admin, I should handle creating a user with invalid endpoint
    Given I set POST Invalid endpoints
    When I send POST Invalid HTTP request
    Then I receive valid HTTP response code 404

  Scenario: Get By ID - As an admin, I should be able to get an existing user by ID
    Given I set the GET by ID endpoint with user ID
    When I send a GET by ID HTTP request
    Then I receives a valid HTTP response code 200
    And I receive valid data for detail user

  Scenario: Get By ID - As an admin, II should handle accessing an invalid endpoint
    Given I set the GET by ID endpoint
    When I send GET by ID HTTP request
    Then I receive a valid HTTP response code 404

  Scenario: PUT - As an admin, I should be able to update an existing user with valid data
    Given I set the PUT endpoint for updating users
    When I send a PUT HTTP request with valid data
    Then I receive valid HTTP response code 200

  Scenario: PUT - As an admin, I should handle updating a user with an invalid endpoint
    Given I set an invalid PUT endpoint for updating users
    When I send a PUT HTTP request with valid data
    Then I received a valid HTTP response code 404

  Scenario: DELETE - As an admin, I should be able to delete an existing user
    Given I set the DELETE endpoint for deleting users
    When I send a DELETE HTTP request
    Then I received valid HTTP response code 200

  Scenario: DELETE - As an admin, I should handle deleting a non-existent user with an Invalid endpoint
    Given I set the DELETE Invalid endpoint
    When I send a DELETE Invalid HTTP request
    Then I receive a valid HTTP response code 404




