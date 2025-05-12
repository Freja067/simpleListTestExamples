Feature: SimpleList behavior

  Scenario: Adding a single element increases the list size
    Given an empty SimpleList
    When I add "apple"
    Then the list size should be 1
    And the element at index 0 should be "apple"

  Scenario: Adding null results in retrievable null element
    Given an empty SimpleList
    When I add null
    Then the list size should be 1
    And the element at index 0 should be null

  Scenario: Adding multiple elements stores them in order
    Given an empty SimpleList
    When I add the following elements:
      | value |
      | apple |
      | banana |
      | cherry |
    Then the list size should be 4
    And the element at index 0 should be "apple"
    And the element at index 1 should be "banana"
    And the element at index 2 should be "cherry"

  Scenario: Removing an element decreases the size
    Given an empty SimpleList
    When I add "item"
    And I remove element at index 0
    Then the list size should be 0

  Scenario: Getting element at invalid index throws
    Given an empty SimpleList
    Then getting element at index 10 should throw an IndexOutOfBoundsException

  Scenario: Removing element at invalid index throws
    Given an empty SimpleList
    Then removing element at index 5 should throw an IndexOutOfBoundsException
