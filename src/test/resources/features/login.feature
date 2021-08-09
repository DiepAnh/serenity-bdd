Feature: As user, I want to login system

  @login_success
  Scenario: Login with Valid Credentials
    Given I am on Login Page
    When I login with Info
      | username | password |
      | skynet   | 123456   |
    Then Redirect to Order List Page

  @login_fail
  Scenario Outline: Login with Invalid Credentials
    Given I am on Login Page
    When I login with Info
      | username   | password   |
      | <username> | <password> |
    Then Login error "<reason>"
    Examples:
      | username | password | reason                          |
      |          | 123456   | username is require             |
      | skynet   |          | password is require             |
      | skynet   | 654321   | in correct username or password |