Feature: Assignment Module
Background: User sets Authoization to No  Auth

Scenario Outline: Check if user is able to create a new assignment with valid endpoints and request body
Given: User creates POST request for assignment module for the LMS API endpoints
When User sends HTTPS request and request body with mandatory and additional fields from the assignment excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 created status with response body for the assignment module post request

Examples: 
      |SheetName          | RowNumber |
      | Assignment        |         0 |
      
      
Scenario Outline: Check if user able to retrieve a record with valid Assignment ID
Given: User creates GET Request for the LMS API endpoint with valid  Assignment ID
When User sends HTTPS Request with a valid Assignment <ID>
Then User receives 200 OK Status with response body for GET assignment 

Examples:
|ID|
|3515|   

Scenario: Check if user is able to retrive all assignments with valid LMS API endpoints
Given: User creates GET Request for the LMS API endpoint
When User sends HTTPS GET Request to retrieve all assignments
Then User receives 200 OK Status with response body for Get All

Scenario Outline: Check if user able to retrieve a record with valid Batch ID
Given: User creates GET Request for the LMS API endpoint with valid  Batch ID
When User sends HTTPS Request with a valid Batch <ID>
Then User receives 200 OK Status with response body for GET assignment using batchid

Examples:
|ID|
|6481|  

Scenario Outline: Check if user able to update a record with valid AssignmentID and mandatory request body
Given: User creates PUT Request for the LMS API endpoint  and Valid Assignment Id 
When User sends HTTPS PUT Request and  request Body with mandatory and additional  fields from the assignment excel sheet "<SheetName>" and <RowNumber>
Then User receives 200 OK Status with updated value in response body for the PUT request

Examples: 
      |SheetName          | RowNumber |
      | Assignment        |         1 |
