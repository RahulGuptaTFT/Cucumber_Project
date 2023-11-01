Feature: Bookcart apllication Test.

  Scenario Outline: Check Add-to-cart functionality.

    And User enters the "<username>" or "<password>" and click Login.
    And User search for the "<book>".
    When User add the book to the cart.
    Then AddToCart badge should be updated.

    Examples:
      | username   | password  | book    |
      | Abcxyz123  | AbcXyz123 | Roomies |
