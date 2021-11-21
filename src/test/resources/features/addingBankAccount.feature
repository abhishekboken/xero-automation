@XeroOrganisation @addBankAccount @regression
Feature: Bank account inside Xero Organisation
  As a Xero User,
  In order to manage my business successfully,
  I want to be able to add an “ANZ (NZ)” bank account inside any Xero Organisation.

  Background: Login to Xero production
    Given user login to Xero production with security questions

  Scenario: Verify ANZ bank account inside any Xero Organisation
    Given user navigates to Bank Accounts sub menu under Accounting
    When user clicks on Add Bank Account
    And user adds the bank details for 'Loan' account type
    Then user can view the bank details on the Dashboard