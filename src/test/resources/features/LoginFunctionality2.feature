Feature: Spree login functionality 2
  Background:
    Given Not a validated user
    When User browse to the site
    Then Spree home page should display
    When User click login link
    Then Browser display Login page

  Scenario: 1.Valid user with valid password
    # This is a comment
    When User enter user email as "shiftqa1@gmail.com"
    And User enter password as "shiftedtech"
    And User click login button
    Then Home page should display
    And Login success message display

  Scenario: 2.Valid user with valid password - Admin
    When User enter user email as "hema0ahmad@gmail.com"
    And User enter password as "hema123"
    And User click login button
    Then Home page should display
    And Login success message display

  Scenario Outline: 3.Valid user with valid password - Data Driven
    When User enter user email as "<EmailAddress>"
    And User enter password as "<Password>"
    And User click login button
    Then Home page should display
    And Login success message display
    Examples:
    |EmailAddress        |Password    |
    |hema0ahmad@gmail.com|hema123     |
    |shiftqa1@gmail.com  |shiftedtech |