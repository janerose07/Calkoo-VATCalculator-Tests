Feature: VAT Calculator Functionality

   @TestCase1 @Regression
   Scenario Outline: Verify tax rates are displayed based on selected country
    Given User navigate to the VAT calculator page
    When User selects "<country>" as the country
    Then User should see "<expected_tax_rates>" as available tax rates

    Examples:
      | country    | expected_tax_rates| 
      | Portugal   | 6,13,23        | 
      | Austria    | 10,13,20       |
      | Luxembourg | 3,8,14,17      |


  @TestCase2 @Smoke @Regression
  Scenario: Calculate VAT amounts when providing net amount
    Given User navigate to the VAT calculator page
    When User selects "<country>" as the country
    And User enters "<net_amount>" as the net amount
    Then the gross amount should be calculated as "<gross_amount>"
    And the VAT amount should be calculated as "<vat_amount>"
    Examples:
      | country         | net_amount | gross_amount  | vat_amount  |
      | Germany         | 100.00     | 119.00        | 19.00       |
      | Portugal        | 50         | 61.50         | 11.50       |
      | United Kingdom  | 999999999  | 1199999998.80 | 199999999.8 |
      | India           | 75.257     | 96.33         | 21.07       |
