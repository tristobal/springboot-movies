Feature: The list of movies
  Scenario: User search all Star Wars Movies
    Given The name of the movie 'Star Wars'
    When The user consume the service hitting the 'movie' endpoint
    Then the services responded with a list of 10 movies
