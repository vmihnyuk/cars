Feature: Comparison

Scenario: Comparison of two cars

  Given User is on Home page
  When User navigates to 'RESEARCH' from main page
  Then User is on Research page

  When User chooses a 'first' car
  Then Combobox for the 'first' car filled correctly

  When User click Search
  Then User is on Car page

  When User navigate to Compare Trims for the 'first' car
  Then User is on Compare Trims Page

  When Save Engine and Trims of the 'first' car
    And User navigate to main page
  Then User is on main page

  When User navigates to 'RESEARCH' from main page
  Then User is on Research page

  When User chooses a 'second' car
  Then Combobox for the 'second' car filled correctly

  When User click Search
  Then User is on Car page

  When User navigate to Compare Trims for the 'second' car
  Then User is on Compare Trims Page

  When Save Engine and Trims of the 'second' car
    And User navigates to 'RESEARCH' from Compare Trims Page
  Then User is on Research page

  When User click Comparisons button
  Then User is on Compare Cars page

  When User chooses 'first' car for compare
  Then User is on Model Compare page

  When User click Add Another Car
  Then User is on Add Another Car page

  When User adds 'second' car for compare
  Then User is on Model Compare page
    And Compare parameters of 'first' car
    And Compare parameters of 'second' car