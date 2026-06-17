Feature: Login functionality

@smoke
@login

Scenario: Valid Login

  Given User is on login page
  When User enters username "standard_user"
  And User enters password "secret_sauce"
  And User clicks login button
  Then User should login successfully
  
@regression
@login

Scenario Outline: Invalid Login

  Given User is on login page
  When User enters username "<username>"
  And User enters password "<password>"
  And User clicks login button
  Then Error message "<errorMessage>" should be displayed
  
  Examples:
| username      | password     | errorMessage |
| invalid_user  | secret_sauce | Epic sadface: Username and password do not match any user in this service |
| standard_user | wrong_pass   | Epic sadface: Username and password do not match any user in this service |
| locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |