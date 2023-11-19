Feature: My Account

  Background:
    Given Close adsBlocker Extension
    Given User go to MyAccount Page
    Given User Enter "abdelrahman888" for UserName and "ahowqp6666" for Password

  Scenario: User DashBoard
    Then successfully login

  Scenario: Show orders
    When Click on Orders Button
    Then view orders successfully

  Scenario: Show order Detail
    When Click on Orders Button
    And Click on View Button
    Then view order detail successfully

  Scenario: Show order Detail Num, Data, State
    When Click on Orders Button
    And Click on View Button
    Then view order detail orderNum, data, state successfully

  Scenario: Show Addresses Store in Account
    When Click on Addresses
    Then view Address Title successfully

  Scenario: Edit Shipping Address
    When Click on Addresses
    And Click on Edit ShippingAddress
    Then view Edit Page successfully

  Scenario: Account Details
    When Click on Account Detail
    Then view Account Detail successfully

  Scenario: Log Out
    When Click on Log out
    Then successfully logout




#  abdelrahman888@gmail.com
  # ahowqp6666