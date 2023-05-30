Feature: Login to Leaptaps

Background:
Given Launch the chrome browser
And Load the URL and maximize

Scenario Outline: Login positive flow
When Enter the Username as <username>
And Enter the Password as <password>
And Click Login
Then Verify HomePage is displayed
Examples:
|username|password|
|'DemoSalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|

Scenario Outline: Login Negative flow
When Enter the Username as <username>
And Enter the Password as <password>
And Click Login
But Verify Error message is displayed

Examples:
|username|password|
|'Demo'|'crmsfae'|
