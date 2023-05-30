Feature: ServiceNow Incident Management getIncidentswithQP

Scenario: Get all the incidents with Query Parameter

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "sys_id"
When send the request with QP
Then validate the response

