Feature: Login to Leaftaps application

Background:
Given Launch the chrome browser
And Load the URL and maximize


Scenario Outline:Create lead with mandatory details
When Enter the Username as "<username>"
And Enter the Password as "<password>"
And Click Login
Then Verify HomePage is displayed
And Click on CRMSFA
And Click on CreateLead link
And Enter CompanyName as "<companyname>"
And Enter the Firstname as "<firstname>"
And Enter the Lastname as "<lastname>"
And Click on Create Leads button
Then View Lead page should be displayed

Examples:
|username|password|companyname|firstname|lastname|
|DemoSalesManager|crmsfa|TestLeaf|Haja|J|
|DemoSalesManager|crmsfa|TestLeaf|Vishali|K|

