@KiwiSaver @KiwiSaverInformationIcon @Major
Feature: KiwiSaver Retirement Calculator fields information icon
  As a Product Owner
  I want that while using the KiwiSaver Retirement Calculator all fields in the calculator have got the information icon present
  So that the user is able to get a clear understanding of what needs to be entered in the field

  Scenario: Verify Current Age KiwiSaver Retirement Calculator fields information icon
    Given user navigates to 'KiwiSaver Retirement Calculator' page
    When user clicks information icon besides 'Current age'
    Then following message is displayed below the 'Current age' field
"""
This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.
"""