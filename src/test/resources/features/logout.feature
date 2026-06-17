Feature: Logout functionality

@smoke
@login

Scenario: Logout successfully

Given User is logged in
When User clicks on menu button
And User clicks on logout button
Then User should logout successfully
