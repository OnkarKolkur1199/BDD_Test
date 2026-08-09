Feature: Login page automation

@SmokeTest
Scenario: Check login with valid credentials
Given User is on login page
When User enters valid username and password
And Click on login button
Then User navigated to home page
And Close the browser
