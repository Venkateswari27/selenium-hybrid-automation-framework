Feature: cart functionality

@smoke
@cart

Scenario Outline: Add product to cart successfully

Given User is logged in
When User adds product "<productName>" to cart
Then Cart badge show "1"

Examples:
| productName |
| Sauce Labs Backpack |
| Sauce Labs Bike Light |

@regression 
@cart

Scenario Outline: Remove product successfully

  Given User has product "<productName>" in cart
  When User removes product "<productName>" from cart
  Then Cart should be empty

Examples:
| productName |
| Sauce Labs Backpack |
| Sauce Labs Bolt T-Shirt |