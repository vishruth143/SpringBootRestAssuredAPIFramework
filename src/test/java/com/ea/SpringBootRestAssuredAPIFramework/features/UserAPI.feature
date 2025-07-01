Feature: Reqres User API Testing

  @smoke @regression
  Scenario: Get a user by ID
    When I send a GET request to "/api/users/2"
    Then the response status code should be 200
    And the response should contain "Janet"

  @regression
  Scenario: Create a new user
    When I send a POST request to "/api/users" using payload for "Create a new user"
    Then the response status code should be 201
    And the response should contain "morpheus"