@tag
Feature: Calculator

  Scenario: divide two numbers
    Given Two input values, 4 and 2, and an operation /
    When I perform the operation
    Then I expect the result 2

  Scenario: divide by zero
    Given Two input values, -7 and 0, and an operation /
    When I perform the operation
    Then I expect the divide by zero exception

  Scenario: raise a number to a power
    Given Two input values, 3 and 4, and an operation ^
    When I perform the operation
    Then I expect the result 81

  Scenario: raise a number to a negative power
    Given Two input values, 5 and -4, and an operation ^
    When I perform the operation
    Then I expect the illegal argument exception

  Scenario Outline: divide by zero
    Given Two input values, <first> and <second>, and an operation <third>
    When I perform the operation
    Then I expect the result <result>
    Examples:
      | first | second | third  | result |
      | 24    | 6      | /      | 4     |
      | -48 | 16     | /      | -3    |
      | 19   | 3     | /      | 6      |
      | 21    | 185    | /      | 0      |
      | -1    | 7      | ^      | -1     |
      | 0     | 0      | ^      | 1      |
      | 2     | 10      | ^      | 1024    |
      | -8    | 2      | ^      | 64   |