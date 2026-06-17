Feature: Checkout functionality

@smoke
@checkout

Scenario: Checkout product successfully

  Given User has product "Sauce Labs Backpack" in cart
  When User clicks checkout button
  When User enters firstName "John"
  And User enters lastName "David"
  And User enters zipCode "12345"
  And User clicks continue button
  And User clicks finish button
  Then Order should be placed successfully
  
  
@regression
@checkout

Scenario Outline: invalid checkout details

  Given User has product "Sauce Labs Backpack" in cart
  When User clicks checkout button
  And User enters firstName "<firstName>"
  And User enters lastName "<lastName>"
  And User enters zipCode "<zipCode>"
  And User clicks continue button
  Then Checkout error message "<errorMessage>"
  
  Examples:
  | firstName | lastName | zipCode | errorMessage                      |
  |           | David    | 12345   | Error: First Name is required     |
  | John      |          | 12345   | Error: Last Name is required      |
  | John      | David    |         | Error: Postal Code is required    |