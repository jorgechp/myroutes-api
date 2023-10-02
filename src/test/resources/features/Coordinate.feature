Feature: Handle Coordinates
  In order to use the app
  As a user
  I want to register myself and get an account

  Scenario: Register new coordinate
    Given I login as "demo" with password "password"
    When I register a new coordinate "40.753°N, 73.983°W"
    Then The response code is 201
    And It has been created a coordinate "40.753°N, 73.983°W"