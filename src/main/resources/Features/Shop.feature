Feature: Shop

  Background:
    Given Close adsBlocker Extension
    Given User go to Shop Page

  Scenario: Filter By Price Functionality
    When Adjust the filter by price between 150 to 450 rps
    Then successfully Filter Shop

  Scenario: Product Categories Functionality
    When Click on Android
    Then View only that Android products

  Scenario: Sort by Popularity item
    When Select sort by Popularity
    Then View the popular products only

  Scenario: Sort by Rating item
    When Select sort by Rating
    Then View the Rating products only

  Scenario: Sort by Newness item
    When Select sort by Newness
    Then View the Newness products only

  Scenario: Sort by Price item
    When Select sort by Price
    Then View the Price products only

  Scenario: Sort by PriceDesc item
    When Select sort by PriceDesc
    Then View the PriceDesc products only

  Scenario: Sale Functionality
    When Click on Sale written product
    Then View the actual price with old price

  Scenario: Make Order
    When Click on Add to Basket
    And Complete The process
    Then Order has been received



