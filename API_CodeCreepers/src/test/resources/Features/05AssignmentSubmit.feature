Feature: Assignment Submit Module
Background: User sets Authoization to No  Auth

Scenario Outline: Check if user is able to create a new assignment submission id with valid endpoints and request body
Given: User creates POST request for assignment submit module for the LMS API endpoints
When User sends HTTPS request and request body with mandatory and additional fields from the assignment submit excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 created status with response body for the assignment submit module post request

Examples: 
      |SheetName                | RowNumber |
      | AssignmentSubmit        |         2 |
         
      

      

Scenario: Check if user is able to retrive all submission with valid LMS API endpoints
Given: User creates GET Request for the LMS API endpoint
When User sends HTTPS GET Request
Then User receives 200 OK Status with response body



Scenario Outline: Check if user is able to retrive assinment submissions by grades with valid batchid LMS API endpoints
Given: User creates GET Request for the LMS API endpoint
When User sends HTTPS Get Request with a valid Batch <ID>
Then User receives 200 OK Status with response body for GET Grades using batchid

Examples:
|ID|
|6481|   


Scenario Outline: Check if user able to  grade assignment with valid submission  Id and mandatory request body
Given: User creates PUT Request for the LMS API endpoint  and Valid submission Id
When User sends HTTPS Put Request and  request Body with mandatory  fields from the assignment submit excel sheet "<SheetName>" and <RowNumber>   
Then User receives 200 OK Status with updated value in response body 

Examples: 
      |SheetName                | RowNumber |
      | AssignmentSubmit        |         0 |
      
Scenario Outline: Check if user is able to retrive assinment submissions by grades with valid studid LMS API endpoints
Given: User creates GET Request for the LMS API endpoint
When User sends HTTPS Get Request with a valid Stud "<ID>"
Then User receives 200 OK Status with response body for GET Grades using studid

Examples:
|ID|
|U9357| 

Scenario Outline: Check if user is able to retrive assinment submissions  with valid userid LMS API endpoints
Given: User creates GET Request for the LMS API endpoint
When User sends HTTPS Get Request with a valid User "<ID>"
Then User receives 200 OK Status with response body for GET submissions using userid

Examples:
|ID|
|U9357|

Scenario Outline: Check if user is able to retrive assinment submissions  with valid batchid LMS API endpoints
Given: User creates GET Request for the LMS API endpoint
When User sends HTTPS Get Request with a valid batchid <ID>
Then User receives 200 OK Status with response body for GET submissions using batchid

Examples:
|ID|
|6481|  

Scenario Outline: Check if user is able to retrive assinment submissions by grades with valid assignment id LMS API endpoints
Given: User creates GET Request for the LMS API endpoint
When User sends HTTPS Get Request with a valid assignment <ID>
Then User receives 200 OK Status with response body for GET submissions using assignmentid

Examples:
|ID|
|3935|  

Scenario Outline: Check if user able to update a submission with valid  submission ID and mandatory request body
Given: User creates PUT Request for the LMS API endpoint  and Valid submission Id
When User sends HTTPS Put Request to update submission and  request Body with mandatory  fields from the assignment submit excel sheet "<SheetName>" and <RowNumber>   
Then User receives 200 OK Status with updated submission value in response body 

Examples: 
      |SheetName                | RowNumber |
      | AssignmentSubmit        |         1 |
