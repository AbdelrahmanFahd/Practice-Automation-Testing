Feature: Login into Website

  Background:
    Given Close adsBlocker Extension
    Given User go to MyAccount Page

  Scenario: Valid username and password
    When User Enter "abdelrahman888" for UserName and "ahowqp6666" for Password
    Then successfully login


  Scenario: Incorrect username and incorrect password
    When User Enter "abdelrahman" for UserName and "ahop6666" for Password
    Then Error Message displayed Invalid UserName

  Scenario: Correct username and empty password
    When User Enter "abdelrahman" for UserName and "" for Password
    Then Error Message displayed Password required

  Scenario: Empty username and correct password
    When User Enter "" for UserName and "ahop6666" for Password
    Then Error Message displayed Username required

  Scenario: Empty username and empty password
    When User Enter "" for UserName and "" for Password
    Then Error Message displayed Username required

  Scenario: Password should be masked
    When User Enter Password
    Then Password must be Masked


  Scenario: Authentication
    When User Enter "abdelrahman888" for UserName and "ahowqp6666" for Password
    And successfully login
    And User Sign out And press Back
    Then Home Page Must be visible

#  abdelrahman888@gmail.com
  # ahowqp6666