Feature: Positive Flow
  Description: Here we test successful High level User data entry flow

  @ui_test
  Scenario Outline: Validate that correct Card is suggested for the correct user
    Given user is on the Home Page
    When I enter user details as "<name>" "<address>" "<email>"
    And I submit the form
    Then Following message should be displayed to the user
    |Thanks for submitting your application, you are eligible for this cards:|
    And "<eligibleCards>" should be shown in the result

    Examples:
      |name   |address          |email                    |eligibleCards|
      |Boris |10 Downing Street |boris@invalidmail.co.uk  |C1           |
      |Angela |1 Rathbone Place |angela@invalidmail.co.uk |C1, C2       |
      |Theresa|22 Singapore road|theresa@invalidmail.co.uk|C2           |

  @ui_test
  Scenario Outline: Validate that error message displayed for the invalid user
    Given user is on the Home Page
    When I enter user details as "<name>" "<address>" "<email>"
    And I submit the form
    Then Following message should be displayed to the user
      |Unfortunately you're not eligible for any cards|

    Examples:
      |name       |address          |email                      |
      |Outsider   |any address      |anyone@invalidmail.co.uk   |
      |Outsider2  |any address2     |anyone2@invalidmail.co.uk  |
