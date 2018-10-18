Feature: User Registration
As a user
I want to login
So that can access home page

Scenario: User able to Login
Given Webpage is launched
When User enter valid credentials "angular" , "password" and "login"
Then home page should be displayed


