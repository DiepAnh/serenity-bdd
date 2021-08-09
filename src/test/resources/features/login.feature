Feature: As user, I want to login system

  @login
  Scenario: Login with Valid Credentials
    Given I am on Login Page
    When I login with Info
      | username | password |
      | skynet   | 123456   |
    Then Redirect to Order List Page