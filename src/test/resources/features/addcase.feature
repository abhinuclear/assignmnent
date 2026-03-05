Feature: Add Apple Case to Cart

  Scenario: Add all materials for iPhone 16 Pro

    Given I navigate to casekaro website
    When I click on Mobile Covers
    And I search for iPhone
    And I select iPhone 16 pro
    And I add Hard material
    And I add Soft material
    And I add Glass material
    Then I open the cart
    And I validate 3 items are added
    And I print cart details