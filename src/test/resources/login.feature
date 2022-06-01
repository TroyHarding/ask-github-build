@login
Feature: Login Page

  @login1
  Scenario: Login to ASK as Teacher account
    Given I open ASK page using url as "http://ask-m.portnov.com/#/login"
    When I enter email as "larry211@bergservices.cf" and password as "user1234" and click Sign In
    And I click on Users Management from Navigation menu

   @login2
   Scenario: Login to ASK as Student account
     Given I open ASK page using url as "http://ask-m.portnov.com/#/login"
     When I enter email as "jasonjason0@omdiaco.com" and password as "user1234" and click Sign In
     And I click on Grades from Navigation menu