Feature: Registration into Website

  Background:
    Given Close adsBlocker Extension
    Given Click MyAccount Page

#  Scenario: Valid email and password
#    When User Enter "abdelradhij@gmail.com" for email and "ahowqp666aaaaa6" for Password
#    Then successfully login into Website

  Scenario: Incorrect Email ID and own password
    When User Enter "abdelrahman@jjhsd" for email and "ahop6666" for Password
    Then Error Message displayed You must enter valid email

  Scenario: Empty email and own password
    When User Enter "" for email and "ahowqp666aaaaa6" for Password
    Then Error Message displayed You must enter valid email

  Scenario: Valid email and Empty password
    When User Enter "abdelrahadshijj@gmail.com" for email and "" for Password
    Then Error Message displayed You must enter Password

  Scenario: Empty username and password
    When User Enter "" for email and "" for Password
    Then Error Message displayed You must enter valid email

#  abdelrahman888@gmail.com
  # ahowqp6666