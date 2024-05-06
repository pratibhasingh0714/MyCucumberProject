Feature: Account feature

  Background:
#    Given User has already logged in to application
#      | Username                    | Password  |
#      | pratibhasingh0714@gmail.com | India@123|
    Given User navigates to childrens place website


    Scenario: Login page title
     # Given User is in logged in page
      When User gets the title of the page
      Then User validates the title of the page "The Children's Place"


   Scenario: Account logged in section
    # Given User is in logged in page
     Then Click on user icon on home page
     Then User gets the account section
       | Log In         |
       | Create Account |
       | Track Order    |
     And Account section should be 3
