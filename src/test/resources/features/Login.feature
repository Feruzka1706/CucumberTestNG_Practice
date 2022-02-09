
@feature1
Feature: As a user, I should be able to login to TryCloud app

  Background:
    Given user on the login page

     #Positive Test Case for Login
  Scenario Outline: verify user login successfully "<username>"
    When user enter valid "<username>" and "<password>"
    And  user click login button
    Then user should be at dashboard page
    Examples:
      | username | password    |
      | User9    | Userpass123 |
      | User39   | Userpass123 |
      | User65   | Userpass123 |


    #Negative Test Case for Login feature
  Scenario Outline: verify user login fail with invalid credentials "<username>"
    When user enter valid "<username>" and "<password>"
    And  user click login button
    Then "<message>" message should be displayed

    Examples:
      | username | password    | message                     |
      | User9    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password. |

