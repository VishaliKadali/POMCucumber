Feature: ServiceNow Incident Management CreateIncidentwithShort_descCategory
Scenario: Create Incident

Given set the endpoint
And add the auth
When send the post request
Then validate the response as 201
