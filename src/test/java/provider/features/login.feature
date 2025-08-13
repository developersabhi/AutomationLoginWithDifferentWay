Feature: Login with different different way.

  Scenario Outline: Valid and invalid login attempts
    Given the user is on the login page
    Then verify the login functionality with invalid username "<username>" and invalid "<password>" and error message "<message>"
    Examples:
      | username        | password  | message                                                 |
      | invalidUser     | 123456    | Invalid login ID                          |
      | admin@getid.com | wrongPass | Invalid email or password.                       |
      |                 | 123456    | Login ID field is required                              |
      | admin@getid.com |           | Password field is required                              |
      |                 |           | Login ID field is required & Password field is required |
      | admin@getid.com | 123456    |                                                         |


