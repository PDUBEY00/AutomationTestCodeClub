@ignore
Feature: Test car tax details

As a user
I want to supply my car details
so that I can see my tax due date

Scenario: Test car tax details on vehicle enquiry webpage
Given Vehicle inquiry page is available
When user enters car "GU18 SCZ" details
And Confirms the details are correct
Then details of car should be displayed which are "GU18 SCZ" and tax due date is "01 March 2019"



Scenario Outline: Test car tax details on vehicle enquiry webpage
Given Vehicle inquiry page is available
When user enters car "<RegNo>" details
And Confirms the details are correct
Then details of car should be displayed which are "<RegNo>" and tax due date is "<TaxDueDate>"
Examples:
|RegNo   |TaxDueDate |
|GU18 SCZ|01 March 2019|
#|ML58 KMA |


