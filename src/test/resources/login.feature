@login
  Feature: Login Page

    @login1
      Scenario: Login to ASK
      Given I login to ASK Page as Teacher
      Then I should see page title as "Assessment Control @ Portnov"
      When I type "reacarolyn@gmail.com" into element with xpath "//input[@formcontrolname='email']"
      And I type "12345" into element with xpath "//input[@formcontrolname='password']"
      Then I click on element using JavaScript with xpath "//button[@type='submit']"
      And I wait for element with xpath "//*[text()='TEACHER']" to be present

    @login2
    Scenario Outline: Login errors
      Given I login to ASK Page as Teacher
      Then I should see page title as "Assessment Control @ Portnov"
      When I type "<Email>" into element with xpath "//input[@formcontrolname='email']"
      And I type "<Password>" into element with xpath "//input[@formcontrolname='password']"
      Then I click on element using JavaScript with xpath "//button[@type='submit']"
      And "<Error>" messages will be displayed

      Examples:
      | Email                     | Password          | Error                            |
      |r                          | 12345             | Should be a valid email address  |
      |                           | 12345             | This field is required           |
      |reatabofunda@gmail.com     |                   | This field is required           |

