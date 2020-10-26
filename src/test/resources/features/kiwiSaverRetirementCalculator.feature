@KiwiSaver @KiwiSaverProjectedBalance @Major
Feature: KiwiSaver projected balance with KiwiSaver Retirement Calculator
  As a Product Owner
  I want that the KiwiSaver Retirement Calculator users are able to calculate what their KiwiSaver projected balance would be at retirement
  So that the users are able to plan their investments better

 Scenario Outline: Employed user project balance
    Given user navigates to 'KiwiSaver Retirement Calculator' page
    And user whose current age is '<age>'
    And has employment status '<status>'
    And has a Salary of '<salary>' per annum
    When contributes to KiwiSaver @'<contributes>'%
    When chooses a '<profile>' risk profile
    Then can calculate his projected balances at retirement.
    Examples:
      | age | status   | salary | contributes | profile   |
      | 30  | Employed | 82000  | 4          | Defensive |

  Scenario Outline: <status> user project balance
    Given user refreshes the page to clear projection criteria
    Given user whose current age is '<age>'
    And has employment status '<status>'
    And current KiwiSaver balance is $'<balance>'
    When voluntary contributes $'<voluntary>' '<frequency>'
    And chooses a '<profile>' risk profile
    And has saving goals requirement of $'<goal>'
    Then can calculate his projected balances at retirement.
    Examples:
      | age | status        | balance | voluntary | frequency   | profile      | goal   |
      | 45  | Self-employed | 100000  | 90        | Fortnightly | Conservative | 290000 |
      | 55  | Not employed  | 140000  | 10        | Annually    | Balanced     | 200000 |

  Scenario: Close the browser
    Then user closes the browser