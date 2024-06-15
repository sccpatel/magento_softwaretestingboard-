#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Sign up and Sign in

  Scenario: User signs up with valid details
    Given the user is on the sign-up page
    When the user enters valid details
    And submits the sign-up form
    Then the user should be signed up successfully
    And the user is on the sign-in page
    When the user enters valid credentials
    And submits the sign-in form
    Then the user should be signed in successfully
