Feature: Data capture screen- Incomplete fields validation

  @smoke
  Scenario Outline: Error message validation when input data is not entered correctly
    Given user is on the Home Page
    When I enter user details as "<name>" "<address>" "<email>"
    And I submit the form
    Then "<errorMessage>" message should be displayed to the user

    Examples:
      |name   |address          |email                    |errorMessage|
      |       |                 |                         |Name is required. Email is required. Address is required.           |
      |Angela |                 |                         |Email is required. Address is required. |
      |       | Dummy address   |                         |Name is required. Email is required. |
      |       |                 |theresa@invalidmail.co.uk|Name is required. Address is required. |
      |       | Dummy address   |theresa@invalidmail.co.uk|Name is required. |
      |Boris  |                 |theresa@invalidmail.co.uk|Address is required. |
      |Boris  | Dummy Address   |                         |Email is required. |