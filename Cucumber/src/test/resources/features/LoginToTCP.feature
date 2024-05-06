Feature: Login feature

  Background:
    Given User navigates to childrens place website

  Scenario: Home page title
    When User gets the title of the page
    Then User validates the title of the page "The Children's Place"
    And Click on user icon on home page
    And User should be in Account login page


  Scenario: Login to TCP
    When User gets the title of the page
    Then Click on user icon on home page
    And User clicks Login button on right nav
    And enters username "pratibhasingh0714@gmail.com"
    And User clicks on Continue button
    Then forget password link should be displayed
    And enters password "India@123"
    Then Click on login button
  #  Then Verify the Welcome text message
  #  And Click on Logout button

