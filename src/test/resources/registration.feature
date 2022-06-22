@registration
Feature: ASK registration
  
  Background: ASK login page
    Given I open ASK page using url as "http://ask-m.portnov.com/#/login"
    Then I should see page title as "Assessment Control @ Portnov"
    And I wait for element with xpath "//mat-card[@class='registration mat-card show']" to be present
    When I click element with xpath "//span[contains(text(),'Register Now')]"
    Then I wait for element with xpath "//mat-card[@class='mat-card']" to be present

  @registration1
  Scenario: Register to ASK with valid credential
    When I type First name as "Carl" into element with xpath "//input[@id='mat-input-2']"
    And I type Last Name as "Carlson" into element with xpath "//input[@id='mat-input-3']"
    And I type Email as "ccarlson78@getcashstash.com" into element with xpath "//input[@id='mat-input-4']"
    And I type Group Code as "ASK26" into element with xpath "//input[@id='mat-input-5']"
    And I type Password as "user1234" into element with xpath "//input[@id='mat-input-6']"
    And I type Confirm Password as "user1234" into element with xpath "//input[@id='mat-input-7']"
    And I click element with xpath "//span[contains(text(),'Register Me')]"
    And I wait for element with xpath "//h4[contains(text(),'You have been Registered.')]" to be present
    And I should see confirmation as "You have been Registered." at xpath "//h4[contains(text(),'You have been Registered.')]"

  @registration2
  Scenario Outline: Register to ASK with invalid input data
    When I type First name as <firstName> into element with xpath <xpath>
    And I type Last Name as <lastName> into element with xpath <xpath1>
    And I type Email as <email> into element with xpath <xpath2>
    And I type Group Code as <groupCode> into element with xpath <xpath3>
    And I type Password as <password> into element with xpath <xpath4>
    And I type Confirm Password as <confirmPassword> into element with xpath <xpath5>
    And I click element with xpath <xpath6>
    Then element with xpath <xpath7> should have text <text>
    Examples:
      | firstName | xpath                        | lastName  | xpath1                       | email                         | xpath2                       | groupCode | xpath3                       | password   | xpath4                       | confirmPassword | xpath5                       | xpath6                                   | xpath7                           | text                             |
      | ""    | "//input[@id='mat-input-2']" | "Carlson" | "//input[@id='mat-input-3']" | "ccarlson78@getcashstash.com" | "//input[@id='mat-input-4']" | "ASK26"   | "//input[@id='mat-input-5']" | "user1234" | "//input[@id='mat-input-6']" | "user1234"        | "//input[@id='mat-input-7']" | "//span[contains(text(),'Register Me')]" | "//mat-error[@id='mat-error-0']" | "This field is required" |
      | "Carl"    | "//input[@id='mat-input-2']" | "" | "//input[@id='mat-input-3']" | "ccarlson78@getcashstash.com" | "//input[@id='mat-input-4']" | "ASK26"   | "//input[@id='mat-input-5']" | "user1234" | "//input[@id='mat-input-6']" | "user1234"        | "//input[@id='mat-input-7']" | "//span[contains(text(),'Register Me')]" | "//mat-error[@id='mat-error-0']" | "This field is required" |
      | "Carl"    | "//input[@id='mat-input-2']" | "Carlson" | "//input[@id='mat-input-3']" | "ccarlson78getcashstash.com" | "//input[@id='mat-input-4']" | "ASK26"   | "//input[@id='mat-input-5']" | "user1234" | "//input[@id='mat-input-6']" | "user1234"        | "//input[@id='mat-input-7']" | "//span[contains(text(),'Register Me')]" | "//mat-error[@id='mat-error-0']" | "Should be a valid email address" |
      | "Carl"    | "//input[@id='mat-input-2']" | "Carlson" | "//input[@id='mat-input-3']" | "" | "//input[@id='mat-input-4']" | "ASK26"   | "//input[@id='mat-input-5']" | "user1234" | "//input[@id='mat-input-6']" | "user1234"        | "//input[@id='mat-input-7']" | "//span[contains(text(),'Register Me')]" | "//mat-error[@id='mat-error-0']" | "This field is required" |

#  @registration3
#  Scenario: Register with invalid data
#    When I type First name as "Carl" into element with xpath "//input[@id='mat-input-2']"
#    And I type Last Name as "Carlson" into element with xpath "//input[@id='mat-input-3']"
#    And I type Email as "ccarlson78@getcashstash.com" into element with xpath "//input[@id='mat-input-4']"
#    And I type Group Code as "ASK26" into element with xpath "//input[@id='mat-input-5']"
#    And I type Password as "user12" into element with xpath "//input[@id='mat-input-6']"
#    And I type Confirm Password as "user1234" into element with xpath "//input[@id='mat-input-7']"
#    And I click element with xpath "//span[contains(text(),'Register Me')]"
#    Then element with xpath "//mat-error[@id='mat-error-4']" should have text "Entered passwords should match"
