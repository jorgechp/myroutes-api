Feature: Create Coordinate
  In order to create a route
  As a user
  I need to register its coordinates

  Scenario: Register Coordinate
    When I register a new coordinate "40.753°N, 73.983°W"
    Then The response code is 201
    And It has been created a coordinate "40.753°N, 73.983°W"
